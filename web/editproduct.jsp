<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Editing a product page --%>
<h3 id="page_name">Editing a Product</h3>
<%-- Code to go back to Main page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to edit product details --%>
<section id="newstudy_form">
    <form action="ProductController?action=update&AMP;ProductCode=${requestScope.product.productCode}" method="post">
        Product Name *:<input type="text" name="product_name" value="${requestScope.product.productName}" required /><br><br>
        Product Quantity *:<input type="text" name="quantity" value="${requestScope.product.quantity}" required /><br><br>
        Product Price *:<input type="text" name="price" value="${requestScope.product.price}" required /><br><br>
        Product Description *:<textarea name="description"  required>${requestScope.product.productDesc}</textarea><br> <br>
        <div id="parentDiv">
        </div>
        <input type="submit" class="btn btn-primary" value="Update"/>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>