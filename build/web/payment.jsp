<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to go back to the main page --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Code to display Payment page  --%>
<h1><c:out value="Email has been successfully sent to ${sessionScope.theUser.email} . . ."/></h1>
<h3><c:out value="Below Order has been successfully placed by ${sessionScope.theUser.name} . . ."/></h3>
<table >
    <%--Column Names --%>
    <tr>
        <th>Product Name</th>
        <th>Unit Price</th>
        <th>Ordered By</th>
    </tr>
    <c:forEach var="product" items="${product}">
        <tr>
            <td><c:out value="${product.productName}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.getProductOrderEmail()}"/></td>
        </tr>
    </c:forEach>
</table>

<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>