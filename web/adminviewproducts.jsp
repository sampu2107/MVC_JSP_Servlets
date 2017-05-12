<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Code to display products in List --%>
<table class="table table-hover" >
    <thead class="thead-default">
        <%--Column Names --%>
        <tr>
            <th>Product Name</th>
            <th>Image</th>		
            <th>Quantity</th>
            <th>Price</th>
            <th>Edit</th>
        </tr>
    </thead>
    <c:forEach var="product" items="${product}">
        <tr>
            <td><c:out value="${product.productName}" /></td>
            <td><img src="${product.getImageURL(product.productCode)}" id="question_page_image" alt="Product"/></td>
            <td><c:out value="${product.quantity}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><form action="ProductController?action=edit&AMP;ProductCode=${product.productCode}" method="post"><input type="submit" class="btn btn-info" value="Edit" /></form></td>                                                
        </tr>
    </c:forEach>
</table>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>