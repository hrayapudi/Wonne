<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.wonne.web.register.RegisterItem, com.wonne.web.util.WonneUtil" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Register || Wonne Web</title>

	<!-- responsive meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- master stylesheet -->
	<link rel="stylesheet" href="css/style.css">
	<!-- responsive stylesheet -->
	<link rel="stylesheet" href="css/responsive.css">

	<style>
	
	.registerForm{
		width: 40%;
		height: 50px;
		background: #2C353C;
		color: #C9C9C9;
		font-size: 13px;	
		margin-bottom: 10px;
		border: none;
		outline: none;
		padding: 0 20px;
		display: inline-block;		
	}
	
	.dropdown-content{
		width: 40%;
		height: 50px;
		background: #2C353C;
    	color: #ffffff;
    	font-size: 13px;
    	margin-bottom: 10px;
		border: none;
		outline: none;
		padding: 0 20px;
    	display: inline-block;    	
	}
	
	::placeholder{
		color: #ffffff;
		font-size: 13px;				
	}
	
	::option{
		color: #ffffff;
		font-size: 13px;				
	}
	
	.register-sec-padding{
		padding: 50px 0;
	}
	
			
	.registerSignupBtn{
		width: 40%;
		height: 50px;
		background: #4CAF50;
    	color: white;
    	font-size: 20px;	
		padding: 14px 20px;
    	margin: 8px 0;
    	border: none;
    	cursor: pointer;
    	float: left;    	
    	opacity: 0.9;    		
	}
		
	.registerSignupBtn:hover {
    	opacity:1;
	}
		
	.registerCancelBtn{
		width: 40%;
		height: 50px;
		background: #f44336;
    	color: white;
    	font-size: 20px;
    	padding: 14px 20px;
    	margin: 8px 0;
    	border: none;    		
    	cursor: pointer;
    	float: left;    	
    	opacity: 0.9;
	}
		
	.registerCancelBtn:hover {
    	opacity:1;
	}
		

	</style>
	
	<script>
		function popupwindow( url, title, w, h ){
		  var left = (screen.width/2)-(w/2);
		  var top = (screen.height/2)-(h/2);
		  return window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
		}		
	</script>
	
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
			<div class="navigation pull-left">
				<div class="nav-header">
					<ul>
                    	<li><a href="index.jsp">Home</a></li>
                        <li><a href="about.jsp">About Us</a></li>			
                        <li><a href="foundation.jsp">Wonne Foundation</a></li>
                        <li><a href="markets.jsp">Wonne Markets</a></li>
                        <li class="dropdown">
							<a href="#">Products</a>
							<ul class="submenu">
								<li><a href="service-details.jsp">Demo Page</a></li>
							</ul>
                        </li>
                        <li><a href="blog.jsp">Blog</a></li>	
                        <li><a href="faq.jsp">FAQ</a></li>                                                                                                                             
					</ul>
				</div>
				<div class="nav-footer">
					<button><i class="fa fa-bars"></i></button>
				</div>
			</div>
			<div class="search-box pull-right">
				<form action="#">
					<input type="text" placeholder="Search...">
					<button type="submit"><i class="fa fa-search"></i></button>
				</form>
			</div>
		</div>
	</nav> <!-- /.mainmenu-area -->



	<section class="register-sec-padding">
		
		<div class="container">
				<p><h1 style="color:black;">Register</h1></p>		
				
				<form action="RegisterServlet" method="POST">
						
							<input class="registerForm" type="text" 	name="${RegisterItem.FULL_NAME.getIName( )}" 	placeholder="${RegisterItem.FULL_NAME.getHolder()}" minlength="${RegisterItem.FULL_NAME.getMinLength()}" value="${param[RegisterItem.FULL_NAME.getIName( )]}" required >
							<input class="registerForm" type="email" 	name="${RegisterItem.EMAIL.getIName( )}" 		placeholder="${RegisterItem.EMAIL.getHolder()}" 	minlength="${RegisterItem.EMAIL.getMinLength()}" 	value="${param[RegisterItem.EMAIL.getIName( )]}" pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*$" required>
							<input class="registerForm" type="password" name="${RegisterItem.PASSWORD.getIName( )}" 	placeholder="${RegisterItem.PASSWORD.getHolder()}" 	minlength="${RegisterItem.PASSWORD.getMinLength()}" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must be at least 8 characters and must contain at least one number & one uppercase letter" required>
							<input class="registerForm" type="password" name="${RegisterItem.REPASSWORD.getIName( )}" 	placeholder="${RegisterItem.REPASSWORD.getHolder()}" minlength="${RegisterItem.REPASSWORD.getMinLength()}" required>
                           	<input class="registerForm" type="text" 	name="${RegisterItem.COMPANY.getIName( )}" 		placeholder="${RegisterItem.COMPANY.getHolder()}" 	minlength="${RegisterItem.COMPANY.getMinLength()}" value="${param[RegisterItem.COMPANY.getIName( )]}" required>
                           	<input class="registerForm" type="text" 	name="${RegisterItem.PHONE.getIName( )}" 		placeholder="${RegisterItem.PHONE.getHolder()}" 	minlength="${RegisterItem.PHONE.getMinLength()}" value="${param[RegisterItem.PHONE.getIName( )]}" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" title="xxx-xxx-xxxx" required>
                           	<input class="registerForm" type="text" 	name="${RegisterItem.ADDRESS.getIName( )}" 		placeholder="${RegisterItem.ADDRESS.getHolder()}" 	minlength="${RegisterItem.ADDRESS.getMinLength()}" value="${param[RegisterItem.ADDRESS.getIName( )]}" required>                            
                           	<input class="registerForm" type="text" 	name="${RegisterItem.CITY.getIName( )}" 		placeholder="${RegisterItem.CITY.getHolder()}" 		minlength="${RegisterItem.CITY.getMinLength()}" value="${param[RegisterItem.CITY.getIName( )]}" required>
                            
                            <select class="dropdown-content" name="${RegisterItem.STATE.getIName( )}" required>
  								<option value="" selected="selected">State</option>
  								<option value="AL" ${param[RegisterItem.STATE.getIName( )] == 'AL' ? 'selected' : ''}>Alabama</option>
  								<option value="AK" ${param[RegisterItem.STATE.getIName( )] == 'AK' ? 'selected' : ''}>Alaska</option>
  								<option value="AZ" ${param[RegisterItem.STATE.getIName( )] == 'AZ' ? 'selected' : ''}>Arizona</option>
  								<option value="AR" ${param[RegisterItem.STATE.getIName( )] == 'AR' ? 'selected' : ''}>Arkansas</option>
  								<option value="CA" ${param[RegisterItem.STATE.getIName( )] == 'CA' ? 'selected' : ''}>California</option>
  								<option value="CO" ${param[RegisterItem.STATE.getIName( )] == 'CO' ? 'selected' : ''}>Colorado</option>
  								<option value="CT" ${param[RegisterItem.STATE.getIName( )] == 'CT' ? 'selected' : ''}>Connecticut</option>
  								<option value="DE" ${param[RegisterItem.STATE.getIName( )] == 'DE' ? 'selected' : ''}>Delaware</option>
  								<option value="DC" ${param[RegisterItem.STATE.getIName( )] == 'DC' ? 'selected' : ''}>District Of Columbia</option>
  								<option value="FL" ${param[RegisterItem.STATE.getIName( )] == 'FL' ? 'selected' : ''}>Florida</option>
  								<option value="GA" ${param[RegisterItem.STATE.getIName( )] == 'GA' ? 'selected' : ''}>Georgia</option>
  								<option value="HI" ${param[RegisterItem.STATE.getIName( )] == 'HI' ? 'selected' : ''}> Hawaii</option>
  								<option value="ID" ${param[RegisterItem.STATE.getIName( )] == 'ID' ? 'selected' : ''}>Idaho</option>
  								<option value="IL" ${param[RegisterItem.STATE.getIName( )] == 'IL' ? 'selected' : ''}>Illinois</option>
  								<option value="IN" ${param[RegisterItem.STATE.getIName( )] == 'IN' ? 'selected' : ''}>Indiana</option>
  								<option value="IA" ${param[RegisterItem.STATE.getIName( )] == 'IA' ? 'selected' : ''}>Iowa</option>
  								<option value="KS" ${param[RegisterItem.STATE.getIName( )] == 'KS' ? 'selected' : ''}>Kansas</option>
  								<option value="KY" ${param[RegisterItem.STATE.getIName( )] == 'KY' ? 'selected' : ''}>Kentucky</option>
  								<option value="LA" ${param[RegisterItem.STATE.getIName( )] == 'LA' ? 'selected' : ''}>Louisiana</option>
  								<option value="ME" ${param[RegisterItem.STATE.getIName( )] == 'ME' ? 'selected' : ''}>Maine</option>
  								<option value="MD" ${param[RegisterItem.STATE.getIName( )] == 'MD' ? 'selected' : ''}>Maryland</option>
  								<option value="MA" ${param[RegisterItem.STATE.getIName( )] == 'MA' ? 'selected' : ''}>Massachusetts</option>
  								<option value="MI" ${param[RegisterItem.STATE.getIName( )] == 'MI' ? 'selected' : ''}>Michigan</option>
  								<option value="MN" ${param[RegisterItem.STATE.getIName( )] == 'MN' ? 'selected' : ''}>Minnesota</option>
  								<option value="MS" ${param[RegisterItem.STATE.getIName( )] == 'MS' ? 'selected' : ''}> Mississippi</option>
  								<option value="MO" ${param[RegisterItem.STATE.getIName( )] == 'MO' ? 'selected' : ''}>Missouri</option>
  								<option value="MT" ${param[RegisterItem.STATE.getIName( )] == 'MT' ? 'selected' : ''}>Montana</option>
  								<option value="NE" ${param[RegisterItem.STATE.getIName( )] == 'NE' ? 'selected' : ''}>Nebraska</option>
  								<option value="NV" ${param[RegisterItem.STATE.getIName( )] == 'NV' ? 'selected' : ''}>Nevada</option>
  								<option value="NH" ${param[RegisterItem.STATE.getIName( )] == 'NH' ? 'selected' : ''}>New Hampshire</option>
  								<option value="NJ" ${param[RegisterItem.STATE.getIName( )] == 'NJ' ? 'selected' : ''}>New Jersey</option>
  								<option value="NM" ${param[RegisterItem.STATE.getIName( )] == 'NM' ? 'selected' : ''}>New Mexico</option>
  								<option value="NY" ${param[RegisterItem.STATE.getIName( )] == 'NY' ? 'selected' : ''}>New York</option>
  								<option value="NC" ${param[RegisterItem.STATE.getIName( )] == 'NC' ? 'selected' : ''}>North Carolina</option>
  								<option value="ND" ${param[RegisterItem.STATE.getIName( )] == 'ND' ? 'selected' : ''}>North Dakota</option>
  								<option value="OH" ${param[RegisterItem.STATE.getIName( )] == 'OH' ? 'selected' : ''}>Ohio</option>
  								<option value="OK" ${param[RegisterItem.STATE.getIName( )] == 'OK' ? 'selected' : ''}>Oklahoma</option>
  								<option value="OR" ${param[RegisterItem.STATE.getIName( )] == 'OR' ? 'selected' : ''}>Oregon</option>
  								<option value="PA" ${param[RegisterItem.STATE.getIName( )] == 'PA' ? 'selected' : ''}>Pennsylvania</option>
  								<option value="RI" ${param[RegisterItem.STATE.getIName( )] == 'RI' ? 'selected' : ''}>Rhode Island</option>
  								<option value="SC" ${param[RegisterItem.STATE.getIName( )] == 'SC' ? 'selected' : ''}>South Carolina</option>
  								<option value="SD" ${param[RegisterItem.STATE.getIName( )] == 'SD' ? 'selected' : ''}>South Dakota</option>
  								<option value="TN" ${param[RegisterItem.STATE.getIName( )] == 'TN' ? 'selected' : ''}>Tennessee</option>
  								<option value="TX" ${param[RegisterItem.STATE.getIName( )] == 'TX' ? 'selected' : ''}>Texas</option>
  								<option value="UT" ${param[RegisterItem.STATE.getIName( )] == 'UT' ? 'selected' : ''}>Utah</option>
  								<option value="VT" ${param[RegisterItem.STATE.getIName( )] == 'VT' ? 'selected' : ''}>Vermont</option>
  								<option value="VA" ${param[RegisterItem.STATE.getIName( )] == 'VA' ? 'selected' : ''}>Virginia</option>
  								<option value="WA" ${param[RegisterItem.STATE.getIName( )] == 'WA' ? 'selected' : ''}>Washington</option>
  								<option value="WV" ${param[RegisterItem.STATE.getIName( )] == 'WV' ? 'selected' : ''}>West Virginia</option>
  								<option value="WI" ${param[RegisterItem.STATE.getIName( )] == 'WI' ? 'selected' : ''}>Wisconsin</option>
  								<option value="WY" ${param[RegisterItem.STATE.getIName( )] == 'WY' ? 'selected' : ''}>Wyoming</option>
							</select>
							
							
							<input class="registerForm" type="number" name="${RegisterItem.ZIPCODE.getIName( )}" placeholder="${RegisterItem.ZIPCODE.getHolder()}" value="${param[RegisterItem.ZIPCODE.getIName( )]}" minlength="${RegisterItem.ZIPCODE.getMinLength()}" pattern="[0-9]{5}" required>
							
							<select class="dropdown-content" name="${RegisterItem.ORGANIZATION.getIName( )}" required>
								<option value="" selected="selected">Select your organization</option>
                                <option value="Pharma Supplier"  ${param[RegisterItem.ORGANIZATION.getIName( )] == 'Pharma Supplier' ? 'selected' : ''}>Pharma Supplier</option>
								<option value="Pharma Client" ${param[RegisterItem.ORGANIZATION.getIName( )] == 'Pharma Client' ? 'selected' : ''}>Pharma Client</option>									
							</select>
							
							<select class="dropdown-content" name="${RegisterItem.ROLE.getIName( )}" required>
								<option value="" selected="selected">Select your role</option>
                                <option value="Patient Services Lead" ${param[RegisterItem.ROLE.getIName( )] == 'Patient Services Lead' ? 'selected' : ''} >Patient Services Lead</option>
								<option value="Market Access Lead" ${param[RegisterItem.ROLE.getIName( )] == 'Market Access Lead' ? 'selected' : ''} >Market Access Lead</option>									
							</select>
							<p></p>
							
												
							<c:if test="${requestScope[WonneUtil.REGISTER_STATUS_TAG] != null}">
        						<c:choose>
									<c:when test="${requestScope[WonneUtil.REGISTER_STATUS_TAG] == WonneUtil.SERVLET_SUCCESS}">
										<p style="color:green;"><strong>${requestScope[WonneUtil.REGISTER_MSG_TAG]}</strong></p>
									</c:when>
									<c:otherwise>
										<p style="color:red;"><strong>${requestScope[WonneUtil.REGISTER_MSG_TAG]}</strong></p> 
									</c:otherwise>
								</c:choose>									
    						</c:if>
												
							
                        <button type="submit" class="registerSignupBtn">Register</button>    
                        <button type="reset"  class="registerCancelBtn">Cancel</button>
                                                																					
					</form>				
					</div>
					
					<div class="container">
						<p style="color:black;">By registering, you are agreeing to our <a href="#" style="color:dodgerblue" onClick="popupwindow('terms.jsp','Terms & Conditions',600,700)">Terms & Conditions</a></p>
					</div>											
				
				</div>			
					
		</div>
	</section>			
	
	
    <footer class="footer sec-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-7">
					<div class="footer-widget about-widget">
                        <h3 class="title">Contact</h3>
						<ul class="contact">
							<li><i class="fa fa-map-marker"></i> <span>10 Sip Ave, Somerset NJ 07080</span></li>
							<li><i class="fa fa-phone"></i> <span>(1800) 456-0900</span></li>
							<li><i class="fa fa-envelope-o"></i> <span>contact@wonneweb.com</span></li>
						</ul>
						<ul class="social">
                                                    <li><a href="http://www.facebook.com"><i class="fa fa-facebook"></i></a></li>
                                                    <li><a href="http://www.twitter.com"><i class="fa fa-twitter"></i></a></li>
                                                    <li><a href="http://www.linkedin.com"><i class="fa fa-linkedin"></i></a></li>
                                                    <li><a href="http://www.youtube.com"><i class="fa fa-youtube"></i></a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-3 latest-post">
					<div class="footer-widget latest-post">
						<h3 class="title">Latest News</h3>
						<ul>
							<li>
								<span class="border"></span>
								<div class="content">
									<a href="blog-details.jsp">If you need a crown or lorem an implant you will pay it </a>
									<span>July 2, 2014</span>
								</div>
							</li>
							<li>
								<span class="border"></span>
								<div class="content">
									<a href="blog-details.jsp">If you need a crown or lorem an implant you will pay it </a>
									<span>July 2, 2014</span>
								</div>
							</li>
							<li>
								<span class="border"></span>
								<div class="content">
									<a href="blog-details.jsp">If you need a crown or lorem an implant you will pay it </a>
									<span>July 2, 2014</span>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</footer>
        
        


	<!-- main jQuery -->
	<script src="js/jquery-1.11.1.min.js"></script>
	<!-- bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- bx slider -->
	<script src="js/jquery.bxslider.min.js"></script>
	<!-- appear js -->
	<script src="js/jquery.appear.js"></script>
	<!-- count to -->
	<script src="js/jquery.countTo.js"></script>
	<!-- owl carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- validate -->
	<script src="js/validate.js"></script>
	<!-- mixit up -->
	<script src="js/jquery.mixitup.min.js"></script>
	<!-- fancybox -->
	<script src="js/jquery.fancybox.pack.js"></script>
	<!-- easing -->
	<script src="js/jquery.easing.min.js"></script>
	<!-- gmap helper -->
	<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<!-- gmap main script -->
	<script src="js/gmap.js"></script>

	<!-- isotope script -->
	<script src="js/isotope.pkgd.min.js"></script>
	<!-- jQuery ui js -->
	<script src="js/jquery-ui-1.11.4/jquery-ui.js"></script>
	
	<!-- revolution scripts -->

	<script src="revolution/js/jquery.themepunch.tools.min.js"></script>
	<script src="revolution/js/jquery.themepunch.revolution.min.js"></script>
	<script type="text/javascript" src="revolution/js/extensions/revolution.extension.actions.min.js"></script>
	<script type="text/javascript" src="revolution/js/extensions/revolution.extension.carousel.min.js"></script>
	<script type="text/javascript" src="revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
	<script type="text/javascript" src="revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
	<script type="text/javascript" src="revolution/js/extensions/revolution.extension.migration.min.js"></script>
	<script type="text/javascript" src="revolution/js/extensions/revolution.extension.navigation.min.js"></script>
	<script type="text/javascript" src="revolution/js/extensions/revolution.extension.parallax.min.js"></script>
	<script type="text/javascript" src="revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
	<script type="text/javascript" src="revolution/js/extensions/revolution.extension.video.min.js"></script>


	<!-- thm custom script -->
	<script src="js/custom.js"></script>



</body>
</html>