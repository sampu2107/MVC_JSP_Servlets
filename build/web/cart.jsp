<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to go back to Main page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<br><br>
<%-- Code to display items in the cart --%>
<section class="participate">
    <%-- Display the products in the cart --%>
    <%-- Clicking on Pay button displays Payment.jsp page where 
            the user can see their order--%>
    <table class="table table-hover" >
        <thead class="thead-default">
            <%--Column Names --%>
            <tr>
                <th>Product Name</th>
                <th>Image</th>
                <th>Unit Price</th>
                <th>Product Description</th>
            </tr>
        </thead>
        <c:forEach var="product" items="${product}">
            <tr>
                <td><c:out value="${product.productName}"/></td>
                <td><img src="${product.getImageURL(product.productCode)}" id="question_page_image" alt="Product"/></td>
                <td><c:out value="${product.price}$"/></td>
                <td><c:out value="${product.productDesc}"/></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td> 
        </tr>
    </table>
    <form action="ProductController?action=pay" method="post"><input type="submit" value="make payment" class="btn btn-block btn-group-lg btn-primary"></form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>