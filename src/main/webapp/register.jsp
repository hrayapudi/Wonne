<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		function popupwindow(url, title, w, h) {
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
                      <a href="index.html">
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
                    	<li><a href="index.html">Home</a></li>
                        <li><a href="about.html">About Us</a></li>			
                        <li><a href="foundation.html">Wonne Foundation</a></li>
                        <li><a href="markets.html">Wonne Markets</a></li>
                        <li class="dropdown">
							<a href="services.html">Products</a>
							<ul class="submenu">
								<li><a href="health-care.html">Primary Halth Care</a></li>
								<li><a href="heart-treatment.html">Heart Treatment</a></li>
								<li><a href="neuro.html">Neurology Treatment</a></li>
								<li><a href="eye.html">Eye Treatment</a></li>
								<li><a href="kidney.html">Kidney Treatment</a></li>
								<li><a href="bone.html">Bone Treatment</a></li>
								<li><a href="dental.html">Dental Treatment</a></li>
								<li><a href="service-details.html">single tabbed version</a></li>
							</ul>
                        </li>
                        <li><a href="blog.html">Blog</a></li>	
                        <li><a href="faq.html">FAQ</a></li>                                                                                                                             
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
						
							<input class="registerForm" type="text" name="fullname" placeholder="Full Name" minlength="3" required>
							<input class="registerForm" type="email" name="email" placeholder="Email" pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*$" required>
							<input class="registerForm" type="password" name="password" placeholder="Password" minlength="8" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must be at least 8 characters and must contain at least one number & one uppercase letter" required>
							<input class="registerForm" type="password" name="repassword" placeholder="Retype Password" required>
                           	<input class="registerForm" type="text" name="company" placeholder="Company Name" minlength="3" required>
                           	<input class="registerForm" type="text" name="phone" placeholder="Phone" placeholder="xxx-xxx-xxxx" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" title="xxx-xxx-xxxx"required>
                           	<input class="registerForm" type="text" name="address" placeholder="Address" minlength="5" required>                            
                           	<input class="registerForm" type="text" name="city" placeholder="City" required>
                            
                            <select class="dropdown-content" name="state" id="state" required>
  								<option value="" selected="selected">State</option>
  								<option value="AL">Alabama</option>
  								<option value="AK">Alaska</option>
  								<option value="AZ">Arizona</option>
  								<option value="AR">Arkansas</option>
  								<option value="CA">California</option>
  								<option value="CO">Colorado</option>
  								<option value="CT">Connecticut</option>
  								<option value="DE">Delaware</option>
  								<option value="DC">District Of Columbia</option>
  								<option value="FL">Florida</option>
  								<option value="GA">Georgia</option>
  								<option value="HI">Hawaii</option>
  								<option value="ID">Idaho</option>
  								<option value="IL">Illinois</option>
  								<option value="IN">Indiana</option>
  								<option value="IA">Iowa</option>
  								<option value="KS">Kansas</option>
  								<option value="KY">Kentucky</option>
  								<option value="LA">Louisiana</option>
  								<option value="ME">Maine</option>
  								<option value="MD">Maryland</option>
  								<option value="MA">Massachusetts</option>
  								<option value="MI">Michigan</option>
  								<option value="MN">Minnesota</option>
  								<option value="MS">Mississippi</option>
  								<option value="MO">Missouri</option>
  								<option value="MT">Montana</option>
  								<option value="NE">Nebraska</option>
  								<option value="NV">Nevada</option>
  								<option value="NH">New Hampshire</option>
  								<option value="NJ">New Jersey</option>
  								<option value="NM">New Mexico</option>
  								<option value="NY">New York</option>
  								<option value="NC">North Carolina</option>
  								<option value="ND">North Dakota</option>
  								<option value="OH">Ohio</option>
  								<option value="OK">Oklahoma</option>
  								<option value="OR">Oregon</option>
  								<option value="PA">Pennsylvania</option>
  								<option value="RI">Rhode Island</option>
  								<option value="SC">South Carolina</option>
  								<option value="SD">South Dakota</option>
  								<option value="TN">Tennessee</option>
  								<option value="TX">Texas</option>
  								<option value="UT">Utah</option>
  								<option value="VT">Vermont</option>
  								<option value="VA">Virginia</option>
  								<option value="WA">Washington</option>
  								<option value="WV">West Virginia</option>
  								<option value="WI">Wisconsin</option>
  								<option value="WY">Wyoming</option>
							</select>
							
							
							<input class="registerForm" type="number" name="zip" placeholder="Zipcode" pattern="[0-9]{5}" required>
							
							<select class="dropdown-content" name="organization">
								<option value="" selected="selected">Select your organization</option>
                                <option value="Pharma Supplier" >Pharma Supplier</option>
								<option value="Pharma Client">Pharma Client</option>									
							</select>
							
							<select class="dropdown-content" name="role">
								<option value="" selected="selected">Select your role</option>
                                <option value="Patient Services Lead" >Patient Services Lead</option>
								<option value="Market Access Lead">Market Access Lead</option>									
							</select>
							<p></p>
		
						<p style="color:black;">By registering, you are agreeing to our <a href="#" style="color:dodgerblue" onClick="popupwindow('terms.html','Terms & Conditions',600,700)">Terms & Conditions</a></p>
                        <button type="submit" class="registerSignupBtn">Register</button>    
                        <button type="reset"  class="registerCancelBtn">Cancel</button>
                        																							
					</form>				
						   	
				   	<%
    				if( null != request.getAttribute("errorMessage") ){
        				out.println( request.getAttribute("errorMessage") );
    				}
					%>	
					
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
									<a href="blog-details.html">If you need a crown or lorem an implant you will pay it </a>
									<span>July 2, 2014</span>
								</div>
							</li>
							<li>
								<span class="border"></span>
								<div class="content">
									<a href="blog-details.html">If you need a crown or lorem an implant you will pay it </a>
									<span>July 2, 2014</span>
								</div>
							</li>
							<li>
								<span class="border"></span>
								<div class="content">
									<a href="blog-details.html">If you need a crown or lorem an implant you will pay it </a>
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