package onlineRetailStore.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import onlineRetailStore.business.Product;

/**
 *
 * @author Sampath Kumar Gunasekaran Product DB Utility class to get, add, and
 * update product details into the database.
 */
public class ProductDB {

    public static Product getProduct(String productCode) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Product "
                + "WHERE ProductCode = ?";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            Product product = null;
            if (rs.next()) {
                product = new Product();
                product.setProductName(rs.getString("ProductName"));
                product.setCategory(rs.getString("Category"));
                product.setPrice(Integer.parseInt(rs.getString("Price")));
                product.setProductAddedDate(rs.getString("ProductAddedDate"));
                product.setProductOrderEmail(rs.getString("ProductOrderEmail"));
                product.setProductCode(productCode);
                product.setProductDesc(rs.getString("ProductDesc"));
                product.setQuantity(Integer.parseInt(rs.getString("Quantity")));
                product.setStatus(rs.getString("Status"));
            }
            connection.close();
            return product;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Product> getProducts() throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Product ";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Product product = null;
            ArrayList<Product> products = new ArrayList<>();
            while (rs.next()) {
                product = new Product();
                product.setProductName(rs.getString("ProductName"));
                product.setCategory(rs.getString("Category"));
                product.setPrice(Integer.parseInt(rs.getString("Price")));
                product.setProductAddedDate(rs.getString("ProductAddedDate"));
                product.setProductCode(rs.getString("ProductCode"));
                product.setProductOrderEmail(rs.getString("ProductOrderEmail"));
                product.setProductDesc(rs.getString("ProductDesc"));
                product.setQuantity(Integer.parseInt(rs.getString("Quantity")));
                product.setStatus(rs.getString("Status"));
                products.add(product);
            }
            connection.close();
            return products;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Product> getProductsByStatus(String status) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Product "
                + "WHERE status = ?";

        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, status);
            rs = ps.executeQuery();
            Product product = null;
            ArrayList<Product> products = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    product = new Product();
                    product.setProductName(rs.getString("ProductName"));
                    product.setCategory(rs.getString("Category"));
                    product.setPrice(Integer.parseInt(rs.getString("Price")));
                    product.setProductOrderEmail(rs.getString("ProductOrderEmail"));
                    product.setProductAddedDate(rs.getString("ProductAddedDate"));
                    product.setProductCode(rs.getString("ProductCode"));
                    product.setProductDesc(rs.getString("ProductDesc"));
                    product.setQuantity(Integer.parseInt(rs.getString("Quantity")));
                    product.setStatus(rs.getString("Status"));
                    products.add(product);
                }
            }
            connection.close();
            return products;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Product> getProducts(String email, String status) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Product "
                + "WHERE ProductOrderEmail = ? and status = ?";

        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, status);
            rs = ps.executeQuery();
            Product product = null;
            ArrayList<Product> products = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    product = new Product();
                    product.setProductName(rs.getString("ProductName"));
                    product.setCategory(rs.getString("Category"));
                    product.setPrice(Integer.parseInt(rs.getString("Price")));
                    product.setProductAddedDate(rs.getString("ProductAddedDate"));
                    product.setProductCode(rs.getString("ProductCode"));
                    product.setProductDesc(rs.getString("ProductDesc"));
                    product.setQuantity(Integer.parseInt(rs.getString("Quantity")));
                    product.setStatus(rs.getString("Status"));
                    product.setProductOrderEmail(rs.getString("ProductOrderEmail"));
                    products.add(product);
                }
            }
            connection.close();
            return products;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static int addProduct(Product product) throws IOException {

        PreparedStatement ps = null;
        Connection connection = null;
        String query
                = "INSERT INTO Product (ProductName, ProductCode, ProductAddedDate, ProductOrderEmail, Category, Price, Status, ProductDesc, Quantity) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getProductCode());
            ps.setString(3, product.getProductAddedDate());
            ps.setString(4, product.getProductOrderEmail());
            ps.setString(5, product.getCategory());
            ps.setInt(6, product.getPrice());
            ps.setString(7, product.getStatus());
            ps.setString(8, product.getProductDesc());
            ps.setInt(9, product.getQuantity());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static int updateProduct(String PCode, Product product) throws IOException {

        PreparedStatement ps = null;
        Connection connection = null;
        String query = "UPDATE Product SET "
                + "ProductName = ?, "
                + "ProductCode = ?, "
                + "ProductAddedDate = ?, "
                + "ProductOrderEmail = ?, "
                + "Category = ?, "
                + "Price = ?, "
                + "Status = ?, "
                + "ProductDesc = ?, "
                + "Quantity = ? "
                + "WHERE ProductCode = ?";
        try {
            connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getProductCode());
            ps.setString(3, product.getProductAddedDate());
            ps.setString(4, product.getProductOrderEmail());
            ps.setString(5, product.getCategory());
            ps.setInt(6, product.getPrice());
            ps.setString(7, product.getStatus());
            ps.setString(8, product.getProductDesc());
            ps.setInt(9, product.getQuantity());
            ps.setString(10, PCode);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
