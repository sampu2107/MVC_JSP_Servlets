<%-- 
    Document   : main
    Created on : Apr 27, 2017, 9:17:56 PM
    Author     : Sampath Kumar Gunasekaran
--%>

<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to go back to Main page  --%>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Code to display the user profile  --%>
<div class="row" style="height:inherit;">
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >

        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">${sessionScope.theUser.getUserName()}</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="images/user.png" class="img-circle img-responsive"> </div>
                    <div class=" col-md-9 col-lg-9 "> 
                        <table class="table table-user-information">
                            <tbody>
                                <tr>
                                    <td>First Name</td>
                                    <td>${sessionScope.theUser.getName()}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="mailto:info@support.com">${sessionScope.theUser.getEmail()}</a></td>
                                </tr>
                                <tr>
                                    <td>Phone Number</td>
                                    <td>704-906-6315</td>
                                </tr>
                                <tr>
                                    <td>Credits</td>
                                    <td>${sessionScope.theUser.getNumCredits()}</td>
                                </tr>
                                <tr>
                                    <td>Offers</td>
                                    <td>${sessionScope.theUser.getNumOffers()}</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>