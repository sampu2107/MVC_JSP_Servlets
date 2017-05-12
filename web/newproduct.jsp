<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<h1 align="Center">Adding a Product</h1>
<%-- Code to go back to Main page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to input product details --%>
<section id="newstudy_form">
    <form action="ProductController?action=add" method="post">
        Product Code *:<input type="text" name="productCode" required /><br><br>
        Product Name *:<input type="text" name="product_name" required /><br><br>
        Product Quantity *:<input type="text" name="quantity" required /><br><br>
        Product Price *:<input type="text" name="price" required /><br><br>
        Product Description *:<textarea name="description"  required></textarea><br> <br>
        <div id="parentDiv">
        </div>
        <input type="submit" value="Add" class="btn btn-primary"/>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>