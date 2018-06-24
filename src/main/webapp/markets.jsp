<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.wonne.web.register.RegisterItem, com.wonne.web.util.WonneUtil" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Appointment || Wonne Web</title>

	<!-- responsive meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- master stylesheet -->
	<link rel="stylesheet" href="css/style.css">
	<!-- responsive stylesheet -->
	<link rel="stylesheet" href="css/responsive.css">



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
                        <li class="dropdown">
							<a href="#">Products</a>
							<ul class="submenu">
								<li><a href="service-details.jsp">Demo</a></li>								
							</ul>
                        </li>
                        <c:if test="${not sessionScope[WonneUtil.LOGIN_BEAN_TAG].isValid()}">
                        	<li><a href="register.jsp">Register</a></li>
                        </c:if>
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


        	<section class="sec-padding faq-home">
		<div class="container">
			<hr>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					
					<div class="accrodion-grp" data-grp-name="faq-accrodion">
						<div class="accrodion active">
							<div class="accrodion-title">
								<h2>
									<span class="decor">
										<span class="inner"></span>
									</span>
									<span class="text">Wonne Markets</span>
								</h2>
							</div>
							<div class="accrodion-content">
								<p>Lorem Ipsum is simply du my text of the pritin industry. Lorm Ipsum hasbeen the industry's standardsdummy text eversince the 1500s,  when an unknown printer</p>
								<p>took a galley of type and scramble it to make type specimen book. It has survived not only five centurie, but also the leap into</p>
							</div>
						</div>
						<div class="accrodion ">
							<div class="accrodion-title">
								<h4>
									<span class="decor">
										<span class="inner"></span>
									</span>
									<span class="text">Text 1</span>
								</h4>
							</div>
							<div class="accrodion-content">
								<p>Lorem Ipsum is simply du my text of the pritin industry. Lorm Ipsum hasbeen the industry's standardsdummy text eversince the 1500s,  when an unknown printer</p>
								<p>took a galley of type and scramble it to make type specimen book. It has survived not only five centurie, but also the leap into</p>
							</div>
						</div>
						<div class="accrodion ">
							<div class="accrodion-title">
								<h4>
									<span class="decor">
										<span class="inner"></span>
									</span>
									<span class="text">Text 2</span>
								</h4>
							</div>
							<div class="accrodion-content">
								<p>Lorem Ipsum is simply du my text of the pritin industry. Lorm Ipsum hasbeen the industry's standardsdummy text eversince the 1500s,  when an unknown printer</p>
								<p>took a galley of type and scramble it to make type specimen book. It has survived not only five centurie, but also the leap into</p>
							</div>
						</div>
						<div class="accrodion ">
							<div class="accrodion-title">
								<h4>
									<span class="decor">
										<span class="inner"></span>
									</span>
									<span class="text">Text 3</span>
								</h4>
							</div>
							<div class="accrodion-content">
								<p>Lorem Ipsum is simply du my text of the pritin industry. Lorm Ipsum hasbeen the industry's standardsdummy text eversince the 1500s,  when an unknown printer</p>
								<p>took a galley of type and scramble it to make type specimen book. It has survived not only five centurie, but also the leap into</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6 hidden-md">
					<div class="img-masonary">
						<div class="img-w1">
							<img src="img/faq/1.jpg" height="450" width="280" alt="">
						</div>
						<div class="img-w1 img-h1">
							<img src="img/faq/2.jpg" height="450" width="280" alt="">
						</div>
						<div class="img-w1 img-h1">
							<img src="img/faq/3.jpg" height="450" width="280" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="footer-call-to-action">		
	</section>

       	<section class="contact-content sec-padding">
            <div class="container">
                <div class="google-map" id="contact-page-google-map" data-icon-path="img/resources/map-marker.png" data-map-lat="-37.812802" data-map-lng="144.956981" data-map-zoom="10" data-map-title="Wonne HQ"></div>
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