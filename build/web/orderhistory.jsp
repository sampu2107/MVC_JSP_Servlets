<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to go back to Main page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<br>
<%-- Code to Display Order History of the user--%>
<section class="participate">
    <br>
    <br>
    <h3><c:out value="${sessionScope.theUser.name}'s Order History"/></h3>
    <table class="table table-hover" >
        <thead class="thead-default">
            <%--Column Names --%>
            <tr>
                <th>Product Name</th>
                <th>Unit Price</th>
                <th>Email Address</th>
            </tr>
        </thead>
        <c:forEach var="product" items="${product}">
            <tr>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.price}$"/></td>
                <td><c:out value="${product.productOrderEmail}"/></td>
            </tr>
        </c:forEach>
    </table>
</section>            
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>