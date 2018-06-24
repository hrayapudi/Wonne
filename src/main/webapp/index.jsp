<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.wonne.web.register.RegisterItem, com.wonne.web.util.WonneUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Wonne Web</title>

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
                    	<li><a href="about.jsp">About Us</a></li>			
                        <li><a href="foundation.jsp">Wonne Foundation</a></li>
                        <li><a href="markets.jsp">Wonne Markets</a></li>
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


	<section class="rev_slider_wrapper">
		
		<div id="slider1" class="rev_slider" data-version="5.0">
			
			<ul>
            	<li data-transition="parallaxvertical">
                <img src="img/slides/yoga1.png"  alt="" width="1920" height="705" data-bgposition="top center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="1" >
                <div class="tp-caption sfr tp-resizeme thm-banner-h1 heavy" 
				        data-x="left" data-hoffset="0" 
				        data-y="top" data-voffset="75" 
				        data-whitespace="nowrap"
				        data-transform_idle="o:1;" 
				        data-transform_in="o:0" 
				        data-transform_out="o:0" 
				        data-start="500">
						Wonne Markets
				 </div>
                                    
                 <div class="tp-caption sfl tp-resizeme thm-banner-h1" 
				        data-x="left" data-hoffset="0" 
				        data-y="top" data-voffset="130" 
				        data-whitespace="nowrap"
				        data-transform_idle="o:1;" 
				        data-transform_in="o:0" 
				        data-transform_out="o:0" 
				        data-start="1000">
                        Making Medicines accessible to everyone
				 </div>
				
                 <div class="tp-caption sfb tp-resizeme thm-banner-h3" 
				        data-x="left" data-hoffset="0" 
				        data-y="top" data-voffset="203" 
				        data-whitespace="nowrap"
				        data-transform_idle="o:1;" 
				        data-transform_in="o:0" 
				        data-transform_out="o:0" 
				        data-start="1500">
						An Insightful Marketplace bringing together Pharma Buyers and Leading Suppliers
				    </div>					
                                                                  
				</li>				
			
				<li data-transition="parallaxvertical">
					<img src="img/slides/yoga2.png"  alt="" width="1920" height="705" data-bgposition="top center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="2" >
					<div class="tp-caption sfr tp-resizeme thm-banner-h1 heavy" 
				        data-x="left" data-hoffset="0" 
				        data-y="top" data-voffset="75" 
				        data-whitespace="nowrap"
				        data-transform_idle="o:1;" 
				        data-transform_in="o:0" 
				        data-transform_out="o:0" 
				        data-start="500">
						Wonne Markets
				    </div>
					<div class="tp-caption sfl tp-resizeme thm-banner-h1" 
				        data-x="left" data-hoffset="0" 
				        data-y="top" data-voffset="130" 
				        data-whitespace="nowrap"
				        data-transform_idle="o:1;" 
				        data-transform_in="o:0" 
				        data-transform_out="o:0" 
				        data-start="1000">
                                                Making Medicines accessible to everyone
				    </div>
					<div class="tp-caption sfb tp-resizeme thm-banner-h3" 
				        data-x="left" data-hoffset="0" 
				        data-y="top" data-voffset="203" 
				        data-whitespace="nowrap"
				        data-transform_idle="o:1;" 
				        data-transform_in="o:0" 
				        data-transform_out="o:0" 
				        data-start="1500">
						An Insightful Marketplace bringing together Pharma Buyers and Leading Suppliers
				    </div>					
                                                                  
				</li>			
				
				<li data-transition="parallaxvertical">
					<img src="img/slides/yoga3.png"  alt="" width="1920" height="705" data-bgposition="top center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="3" >
					<div class="tp-caption sfr tp-resizeme thm-banner-h1 heavy" 
				        data-x="left" data-hoffset="0" 
				        data-y="top" data-voffset="75" 
				        data-whitespace="nowrap"
				        data-transform_idle="o:1;" 
				        data-transform_in="o:0" 
				        data-transform_out="o:0" 
				        data-start="500">
						Wonne Markets
				    </div>
					<div class="tp-caption sfl tp-resizeme thm-banner-h1" 
				        data-x="left" data-hoffset="0" 
				        data-y="top" data-voffset="130" 
				        data-whitespace="nowrap"
				        data-transform_idle="o:1;" 
				        data-transform_in="o:0" 
				        data-transform_out="o:0" 
				        data-start="1000">
                                                Making Medicines accessible to everyone
				    </div>
					<div class="tp-caption sfb tp-resizeme thm-banner-h3" 
				        data-x="left" data-hoffset="0" 
				        data-y="top" data-voffset="203" 
				        data-whitespace="nowrap"
				        data-transform_idle="o:1;" 
				        data-transform_in="o:0" 
				        data-transform_out="o:0" 
				        data-start="1500">
						An Insightful Marketplace bringing together Pharma Buyers and Leading Suppliers
				    </div>	                                                                
				</li>					
			</ul>
		</div>
	</section>

	
	<section class="home-appointment-form">
		<div class="container">
                      
            <c:choose>
            	<c:when test="${sessionScope[WonneUtil.LOGIN_BEAN_TAG].isValid()}">
    				<div class="heading">
						<h3>${sessionScope[WonneUtil.LOGIN_BEAN_TAG].getFullName()}<h3>		
            		</div>
            	
					<div class="form-grp clearfix">            
						<form class="clearfix" id="appointment-form" action="LogoutServlet" method="POST">
							<div class="single-form">
								<h3>Welcome back, thank you for being a part of our story.<h3>						
							</div>
							<div class="single-form">
								<h3><h3>						
							</div>
							<div class="single-form">
								<button type="submit">Logout</button>
							</div>
						</form>			
					</div>
    			</c:when>
				<c:otherwise>
        			<div class="heading">
						<h3>Login<h3>		
            		</div>
            		
            		<div class="form-grp clearfix">            
						<form class="clearfix" id="appointment-form" action="LoginServlet" method="POST">
							<div class="single-form">
								<input type="email" name="${RegisterItem.EMAIL.getIName( )}" 		placeholder="${RegisterItem.EMAIL.getHolder()}" required>
							</div>
                    		<div class="single-form">
								<input type="password" name="${RegisterItem.PASSWORD.getIName( )}" 	placeholder="${RegisterItem.PASSWORD.getHolder()}" required>
							</div>
							<div class="single-form">
								<button name="login" value="login" type="submit">Login</button>
							</div>
                    		<div class="single-form">
								<button name="forgot" onclick="location.href='forgot.jsp';">Forgot Password?</button>
							</div>
						</form>
						<p></p>	
						<p style="color:red;"><strong>${requestScope[WonneUtil.LOGIN_BEAN_TAG].getMessage()}</strong></p>	
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</section>       
        
        
        <section class="fact-counter-wrapper sec-padding">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-4">
					<h2>Launched in <b>2018</b> <br>we are bringing together suppliers and customers<br></h2>					
				</div>
				<div class="col-lg-6 col-md-8">
					<div class="single-fact">
						<div class="icon-box">
                        	<span class="timer" data-from="0" data-to="15" data-speed="5000" data-refresh-interval="50">15</span>
						</div>						
						<p>Initiatives Funded</p>
					</div>
					<div class="single-fact">
						<div class="icon-box">
							<span class="timer" data-from="0" data-to="60" data-speed="5000" data-refresh-interval="50">60</span>
						</div>
						<p>Patients Supported</p>
					</div>
					<div class="single-fact">
						<div class="icon-box">
							<span class="timer" data-from="0" data-to="7" data-speed="5000" data-refresh-interval="50">7</span>
						</div>
						<p>Countries Served</p>
					</div>
				</div>
			</div>
		</div>
	</section>
        
        
        <section class="call-to-action boxed">
		<div class="container">
                        <h2 style="color:black">Latest News</h2>
			<div class="sec-title text-left">
				<span class="decor"><span class="inner"></span></span>
			</div>
			
                        <div class="clearfix">
                            <div class="team-carousel owl-carousel owl-theme">
                                
                                 <div class="item">
                                    <div class="single-blog-post">
					<div class="img-box">
                                        	<img src="img/blog/1.jpg" alt="">
                                                	<div class="overlay">
								<div class="box">
									<div class="content">
										<ul>
											<li><a href="#"><i class="fa fa-link"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="content-box">
							<div class="date-box">
								<div class="inner">
									<div class="date">
										<b>24</b>
										june
									</div>
									<div class="comment">
										<i class="flaticon-interface-1"></i> 8
									</div>
								</div>
							</div>
							<div class="content">
								<a href="#"><h3>Blog post for June</h3></a>
								<p>Synopsis of the blog ... </p>
								<span>Tag: <a href="#">doctor, medicine</a></span>
							</div>
						</div>
					</div>
				</div>
				
                           
                                <div class="item">
                                    <div class="single-blog-post">
					<div class="img-box">
                                        	<img src="img/blog/1.jpg" alt="">
                                                	<div class="overlay">
								<div class="box">
									<div class="content">
										<ul>
											<li><a href="#"><i class="fa fa-link"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="content-box">
							<div class="date-box">
								<div class="inner">
									<div class="date">
										<b>24</b>
										june
									</div>
									<div class="comment">
										<i class="flaticon-interface-1"></i> 8
									</div>
								</div>
							</div>
							<div class="content">
								<a href="#"><h3>Blog post for June</h3></a>
								<p>Synopsis of the blog ... </p>
								<span>Tag: <a href="#">doctor, medicine</a></span>
							</div>
						</div>
					</div>
				</div>
                                
                                
                                                    <div class="item">
                                    <div class="single-blog-post">
					<div class="img-box">
                                        	<img src="img/blog/1.jpg" alt="">
                                                	<div class="overlay">
								<div class="box">
									<div class="content">
										<ul>
											<li><a href="#"><i class="fa fa-link"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="content-box">
							<div class="date-box">
								<div class="inner">
									<div class="date">
										<b>24</b>
										june
									</div>
									<div class="comment">
										<i class="flaticon-interface-1"></i> 8
									</div>
								</div>
							</div>
							<div class="content">
								<a href="#"><h3>Blog post for June</h3></a>
								<p>Synopsis of the blog ... </p>
								<span>Tag: <a href="#">doctor, medicine</a></span>
							</div>
						</div>
					</div>
				</div>
                                
                                
                                                    <div class="item">
                                    <div class="single-blog-post">
					<div class="img-box">
                                        	<img src="img/blog/1.jpg" alt="">
                                                	<div class="overlay">
								<div class="box">
									<div class="content">
										<ul>
											<li><a href="#"><i class="fa fa-link"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="content-box">
							<div class="date-box">
								<div class="inner">
									<div class="date">
										<b>24</b>
										june
									</div>
									<div class="comment">
										<i class="flaticon-interface-1"></i> 8
									</div>
								</div>
							</div>
							<div class="content">
								<a href="#"><h3>Blog post for June</h3></a>
								<p>Synopsis of the blog ... </p>
								<span>Tag: <a href="#">doctor, medicine</a></span>
							</div>
						</div>
					</div>
				</div>
                                
                                
                                
                                                    <div class="item">
                                    <div class="single-blog-post">
					<div class="img-box">
                                        	<img src="img/blog/1.jpg" alt="">
                                                	<div class="overlay">
								<div class="box">
									<div class="content">
										<ul>
											<li><a href="#"><i class="fa fa-link"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="content-box">
							<div class="date-box">
								<div class="inner">
									<div class="date">
										<b>24</b>
										june
									</div>
									<div class="comment">
										<i class="flaticon-interface-1"></i> 8
									</div>
								</div>
							</div>
							<div class="content">
								<a href="#"><h3>Blog post for June</h3></a>
								<p>Synopsis of the blog ... </p>
								<span>Tag: <a href="#">doctor, medicine</a></span>
							</div>
						</div>
					</div>
				</div>
                                
				</div>
			</div>
		</div>
	</section>
      

	<section class="footer-call-to-action">
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