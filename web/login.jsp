<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@include file="header.jsp" %>
<%-- Section to input login details --%>

<section id="login_form">
    <%-- Code to create login form--%>
    <form action="UserController?action=login" method="post" class="loginAdmin_form">
        <input type="hidden" name="action" value="login">
        Email Address *:<input type="email" name="email" required/> <br><br>
        Password *:<input type="password" name="password" required/><br>
        <label>&nbsp;</label>
        <input type="submit" value="Log in" id="login_button">
        <h1 align="center"><c:out value="${requestScope.msg}"/></h1>
        <%-- Code to go to Sign up for a new account  --%>
        <a href="signup.jsp" id="sign_up_link">Sign up</a>
    </form><br>
</section>
<%-- Include tag is used to import footer page --%>
<%@include file="footer.jsp" %>