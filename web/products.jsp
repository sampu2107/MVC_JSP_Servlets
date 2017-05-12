<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<h1 align="center">Products</h1>
<%-- Code to go Back to the Main Page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to display products details --%> 
<%-- Clicking on View items allows the user to view the item and Add to cart button adds the item in the cart--%>
<section id="studies_section">
    <table class="table table-hover" >
        <thead class="thead-default">
            <tr>
                <th>Product Name</th>
                <th>Product Description</th>		
                <th>Unit Price</th>
                <th>View Items</th>
                <th>Add to Cart</th>
            </tr>
        </thead>
        <c:forEach var="product" items="${product}">
            <tr>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.productDesc}"/></td>
                <td><c:out value="${product.price}$"/></td>
                <td><form action="ProductController?action=viewitems&AMP;ProductCode=${product.productCode}" method="post"><input type="submit" class="btn btn-success "
                                                                                                                                  value="View Item" /></form></td>
                <td><form action="ProductController?action=addtocart&AMP;ProductCode=${product.productCode}" method="post"><input type="submit" class="btn btn-success" value="Add To Cart" /></form></td>                                                
            </tr>
        </c:forEach>
    </table>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>