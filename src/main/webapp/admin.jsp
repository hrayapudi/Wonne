<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.wonne.web.register.RegisterItem, com.wonne.web.util.WonneUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Admin</title>

	<!-- responsive meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- master stylesheet -->
	<link rel="stylesheet" href="css/style.css">
	<!-- responsive stylesheet -->
	<link rel="stylesheet" href="css/responsive.css">
	
	<style type="text/css">
		
	.register-sec-padding{
		padding: 200px 0;
	}
	</style>
</head>

<body>

	<section class="top-bar">

    	<div class="container">
			<div class="left-text pull-left">
            	<p>
                	<a href="index.jsp">
                        <img src="img/resources/logo.png" alt="Wonne Logo"/>
                    </a>
                </p>
			</div> <!-- /.left-text -->
			<div class="social-icons pull-right">
        		<ul>
            		<li><a href="http://www.facebook.com"><i class="fa fa-facebook"></i></a></li>
                	<li><a href="http://www.twitter.com"><i class="fa fa-twitter"></i></a></li>
                	<li><a href="http://www.linkedin.com"><i class="fa fa-linkedin"></i></a></li>
                	<li><a href="http://www.youtube.com"><i class="fa fa-youtube"></i></a></li>
            	</ul>
        	</div> <!-- /.social-icons -->
        </div>
	
	</section> <!-- /.top-bar -->

	<nav class="mainmenu-area stricky">
		<div class="container">
		</div>
	</nav>
	
		
	<section class="register-sec-padding">
		<div class="home-appointment-form">
			<div class="container">
        		<div class="form-grp clearfix">            
					<form class="clearfix" action="AdminServlet" method="POST">
						<div class="single-form">
							<button name="users" type="submit">All Users</button>
						</div>
                    	<div class="single-form">
							<button name="loggedIn" type="submit">Logged-In</button>
						</div>
					</form>
					<p></p>						
				</div>
			</div>
		</div>	
	</section>
	
	
	<div class="service_table">
		<table class="table">
            <c:forEach var="msg" items="${requestScope.adminDataList}">
                <tr>
                    <td>${msg[0]}</td>
                    <td>${msg[1]}</td>
                </tr>
            </c:forEach>    
        </table>     
	
	</div>
	
	</body>
</html>