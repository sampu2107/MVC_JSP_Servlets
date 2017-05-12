<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- title of the Page--%>
        <title>Flopkart</title>
        <%-- importing CSS stylesheet --%>
        <link rel="stylesheet" href="styles/main.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/home.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <script src="scripts/script.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%-- Code to specify Header section of the page--%>
        <header>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Flopkart Retail Store</a> 
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <c:if test="${sessionScope.theUser == null && sessionScope.theAdmin == null }">
                            <li><a href="UserController?action=about">About Us</a></li>
                            <li><a href="login.jsp">Login</a></li>
                            </c:if>
                            <c:if test="${sessionScope.theAdmin.type == 'admin'}">
                            <li class="active"><a href="UserController?action=main">Home</a></li>
                            <li><a href="ProductController?action=view">View Products</a></li>
                            <li><a href="newproduct.jsp">Add Products</a></li>
                            <li><a href="UserController?action=about">About Us</a></li>
                            <li><a href="UserController?action=view">Profile</a></li>
                            <li><a href="UserController?action=logout">Logout</a></li>
                            </c:if>
                            <c:if test="${sessionScope.theUser.name != null && sessionScope.theUser.type == 'customer'}">
                            <li class="active"><a href="UserController?action=main">Home</a></li>
                            <li><a href="ProductController?action=products">Products</a></li>
                            <li><a href="ProductController?action=viewitems">Cart(<span class="count"><c:out value="${sessionScope.theUser.numCart}"/></span>)</a></li>
                            <li><a href="ProductController?action=viewhistory">Order History</a></li>
                            <li><a href="aboutl.jsp?user=${sessionScope.theUser.name}">About Us</a></li>
                            <li><a href="UserController?action=view">Profile</a></li>
                            <li><a href="UserController?action=logout">Logout</a></li>
                            </c:if>
                    </ul>
                </div>
            </nav>
        </header>
