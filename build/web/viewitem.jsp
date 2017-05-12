<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>

<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<h3 id="page_name">Item</h3>
<%-- Code to go back to Main page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to view the Item --%>
<section id="newstudy_form">
    <table class="table table-hover" >
        <thead class="thead-default">
            <tr>
                <th>Product Name</th>
                <th>Image</th>		
                <th>Product Description</th>
                <th>Quantity</th>
                <th>Category</th>     
            </tr>
        </thead>
        <tr>
            <td><c:out value="${product.productName}"/></td>
            <td><img src="${product.getImageURL(product.productCode)}" id="question_page_image" alt="Product"/></td>
            <td><c:out value="${product.productDesc}"/></td>
            <td><c:out value="${product.quantity}"/></td>
            <td><c:out value="${product.category}"/></td>                                               
        </tr>
    </table>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>