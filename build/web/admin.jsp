<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display a running carousel  --%>
<div class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">

            <div class="item active">
                <img src="images/4.jpg" alt="Chania" width="1000" height="600">
                <div class="carousel-caption">
                </div>
            </div>

            <div class="item">
                <img src="images/clothes.jpg" alt="Chania" width="1000" height="600">
                <div class="carousel-caption">
                </div>
            </div>

            <div class="item">
                <img src="images/electronics.jpg" alt="Flower" width="1000" height="600">
                <div class="carousel-caption">
                </div>
            </div>

            <div class="item">
                <img src="images/sports.jpg" alt="Flower" width="1000" height="600">
                <div class="carousel-caption">
                </div>
            </div>
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>

</div>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>