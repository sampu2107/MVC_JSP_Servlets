package onlineRetailStore.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import onlineRetailStore.business.Payment;
import onlineRetailStore.business.Product;
import onlineRetailStore.business.User;
import onlineRetailStore.utility.MailUtil;
import onlineRetailStore.utility.PaymentDB;
import onlineRetailStore.utility.ProductDB;

/**
 *
 * @author Sampath Kumar Gunasekaran Product controller which controls the flow
 * of application related to product details.
 */
public class ProductController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/main.jsp";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("theUser");
        User admin = (User) session.getAttribute("theAdmin");
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            if (user != null) {
                url = "/main.jsp";
            } else {
                if (admin != null) {
                    url = "/admin.jsp";
                } else {
                    url = "/main.jsp";
                }
            }
        } else if (action.equalsIgnoreCase("viewitems")) {
            if (user != null) {
                String productCode = request.getParameter("ProductCode");
                if (productCode != null) {
                    Product product = ProductDB.getProduct(productCode);
                    request.setAttribute("product", product);
                    url = "/viewitem.jsp";
                } else {
                    ArrayList<Product> products = ProductDB.getProducts(user.getEmail(), "cart");
                    request.setAttribute("product", products);
                    url = "/cart.jsp";
                }
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("view")) {
            if (admin != null) {
                ArrayList<Product> products = ProductDB.getProducts();
                request.setAttribute("product", products);
                url = "/adminviewproducts.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("edit")) {
            if (admin != null) {
                String productCode = request.getParameter("ProductCode");
                if (productCode != null) {
                    Product product = ProductDB.getProduct(productCode);
                    request.setAttribute("product", product);
                    url = "/editproduct.jsp";
                }
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("viewhistory")) {
            if (user != null) {
                ArrayList<Product> products = ProductDB.getProducts(user.getEmail(), "paid");
                request.setAttribute("product", products);
                url = "/orderhistory.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("update")) {
            if (admin != null) {
                String productCode = request.getParameter("ProductCode");
                String productName = request.getParameter("product_name");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                int price = Integer.parseInt(request.getParameter("price"));
                String productdesc = request.getParameter("description");
                String category = request.getParameter("categorySelect");
                Product product = ProductDB.getProduct(productCode);
                product.setProductCode(productCode);
                product.setProductName(productName);
                product.setQuantity(quantity);
                product.setPrice(price);
                product.setCategory(category);
                product.setProductDesc(productdesc);
                ProductDB.updateProduct(productCode, product);
                ArrayList<Product> products = ProductDB.getProducts();
                request.setAttribute("product", products);
                url = "/adminviewproducts.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("add")) {
            if (admin != null) {
                String productCode = request.getParameter("productCode");
                String productName = request.getParameter("product_name");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                int price = Integer.parseInt(request.getParameter("price"));
                String productdesc = request.getParameter("description");
                Product product = new Product();
                product.setProductCode(productCode);
                product.setProductName(productName);
                product.setQuantity(quantity);
                product.setPrice(price);
                product.setProductDesc(productdesc);
                product.setProductOrderEmail(admin.getEmail());
                product.setStatus("available");
                ProductDB.addProduct(product);
                ArrayList<Product> products = ProductDB.getProducts();
                request.setAttribute("product", products);
                url = "/adminviewproducts.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("addtocart")) {
            if (user != null) {
                String productCode = request.getParameter("ProductCode");
                Date currDate = new Date();
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String cartDate = df.format(currDate);
                Product cart = ProductDB.getProduct(productCode);
                Product cartRecord = new Product();
                cartRecord.setProductCode(productCode + "Cart");
                cartRecord.setProductName(cart.getProductName());
                cartRecord.setProductDesc(cart.getProductDesc());
                cartRecord.setCategory(cart.getCategory());
                cartRecord.setPrice(cart.getPrice());
                cartRecord.setStatus("cart");
                cartRecord.setProductOrderEmail(user.getEmail());
                cartRecord.setProductAddedDate(cartDate);
                ProductDB.addProduct(cartRecord);
                user.setNumCart(user.getNumCart() + 1);
                session.setAttribute("theUser", user);
                ArrayList<Product> products = ProductDB.getProductsByStatus("available");
                request.setAttribute("product", products);
                url = "/products.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("pay")) {
            if (user != null) {
                Date currdate = new Date();
                ArrayList<Product> products = ProductDB.getProducts(user.getEmail(), "cart");
                for (int i = 0; i < products.size(); i++) {
                    products.get(i).setStatus("paid");
                    products.get(i).setProductOrderEmail(user.getEmail());
                    ProductDB.updateProduct(products.get(i).getProductCode(), products.get(i));
                }
                Payment payment = new Payment();
                payment.setOrderDate(currdate);
                payment.setProductCode(products.get(0).getProductCode());
                payment.setUsername(user.getName());
                PaymentDB.addPayment(payment);
                user.setNumCredits(user.getNumCredits() + 2);
                user.setNumOffers(user.getNumOffers() + 1);
                session.setAttribute("theUser", user);
                String to = user.getEmail();
                String from = "wermsam92@gmail.com";
                String subject = "Thanks for your order";
                String body = "Dear " + user.getName() + ",\n\n" + "Thanks for placing the order. Your order details will be shortly sent. ";
                boolean isBodyHTML = false;
                try {
                    MailUtil.sendMail(to, from, subject, body, isBodyHTML); //code to trigger a mail to the user
                    user.setNumCart(0);
                    session.setAttribute("theUser", user);
                    ArrayList<Product> paidProducts = ProductDB.getProducts(user.getEmail(), "paid");
                    request.setAttribute("product", paidProducts);
                    url = "/payment.jsp";
                } catch (MessagingException ex) {
                    System.out.println(ex);
                }
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("products")) {
            if (user != null) {
                ArrayList<Product> products = ProductDB.getProductsByStatus("available");
                request.setAttribute("product", products);
                url = "/products.jsp";
            } else {
                url = "/login.jsp";
            }
        }
        // forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
