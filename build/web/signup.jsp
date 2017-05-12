<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@include file="header.jsp" %>

<%--Code to signup form --%>
<section id="signup_form">
    <section>
        <form action="UserController?action=create" method="post">
            <label>User Name *</label>
            <input type="text" name="username" required/> <br><br>
            <label>Name *</label>
            <input type="text" name="name" required/> <br><br>
            <label>Email *</label>
            <input type="email" name="email" required/> <br><br>
            <label>Password *</label>
            <input type="password" name="password" required/> <br><br>
            <label>Confirm Password *</label>
            <input type="password" name="confirm_password" required /> <br>
            <input type="submit" value="Create Account" id="signup_button">
            <br>
            <h1 align="center"><c:out value="${requestScope.msg}"/></h1>
        </form>
    </section>
</section>
<%-- Include tag is used to import footer page --%>
<%@include file="footer.jsp" %>