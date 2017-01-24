<!DOCTYPE HTML>
<html>
	<head>
		<title>LETS RIDE Website </title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link href="css/slider.css" rel="stylesheet" type="text/css"  media="all" />
		  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		  <script type="text/javascript" src="js/jquery.easing.1.3.js"></script> 
		    <script type="text/javascript" src="js/camera.min.js"></script>
				<script type="text/javascript">
			   jQuery(function(){
				jQuery('#camera_wrap_1').camera({
					height: '500px',
					pagination: false,
				});
			});
		  </script>
		  <script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
				});
			});
		</script>
				
		<style>
	pa {
	    color : white;
	    font-style: italic;
	    font-size: 20px;
	    }
	    </style>
	    
	</head>
	<body>
		<!---start-wrap----->
		
			<!---start-header----->
			<div class="header"  id="top">
				<div class="wrap">
					<!---start-logo---->
					<div class="logo">
						<a href="Home.html"><img src="projectpic.PNG" title="logo" ></a>
					</div>
					<!---End-logo---->
					<!---start-top-nav---->
					<div class="top-nav">
						<ul>
							<li class="active"><a href="home.jsp">Home</a></li>
							<li><a href="contact.jsp">Contact</a></li>
							<li><a href="index.jsp">Login</a></li>
							<div class="clear"> </div>
						</ul>
					</div>
					<div class="clear"> </div>
					<!---End-top-nav---->
				</div>
			</div>
			<!---End-header----->
			<!--start-image-slider---->
			<div class="slider">					     
					<div class="camera_wrap camera_azure_skin" id="camera_wrap_1">									           
						<div data-src="slider3.jpg">  </div> 
						<div data-src="slider2.jpg">  </div>
						<div data-src="slider1.jpg">  </div>
						<div data-src="slider2.jpg">  </div>
					</div>
					<div class="clear"> </div>					       
			</div>					
		 <!--End-image-slider---->
		 <!---start-content---->
		 <div class="content">
		 	<div class="top-grids">
		 		<div class="wrap">
			 		<h3>THE LARGEST CARPOOLING NETWORK</h3>
			 		<h3>LETS SHARE YOUR RIDE</h3>
			 		<ul>
					<p> 
					<br>
			 		<!--	<li><a class="what" href="#">What we do?</a></li>   -->
			 			<li><a class="join" href="register.jsp">Join us</a></li>
			 			<div class="clear"> </div>
			 		</ul>
		 		</div>
		 	</div>
		 	<div class="mid-grids">
		 		<div class="wrap">
			 		<div class="col span_2_of_3">
			 			<a href="#"><img src="map.jpg" height="300%" width="80%"/></a>
			 			
			 		</div>
			 		<div class="col span_1_of_3">
			 		   <pre>
			 		   <br>
<pa> Over few years we have increased our sites
 of operation and currently we have over
 100 locations which are operated from Charlotte 
 as base center.
 
    - Thanks for your support</pa> 
			 		    </pre> 
			 			</div>
			 		
			 		<div class="clear"> </div>
		 		</div>
		 	</div>
		 	<div class="bottom-grids">
		 		<div class="wrap">
		 		<div class="mobile-no">
		 			 <span>+1 980-3459682</span>
		 		</div>
		 		<div class="footer-logo">
		 			<a href="index.html">LETS RIDE</a>
		 		</div>
		 		<div class="copy-right">
		 			<h3 style="font-family:courier;color:white;font-size:150%;"><b>Designed by Charishma </b></h3>
		 		</div>
		 		<div class="top-to-page">
						<a href="#top" class="scroll"> </a>
						<div class="clear"> </div>
					</div>
		 	</div>
		 	</div>
		 </div>
		 <!---End-contnet---->
		
		<!---End-wrap----->
	</body>
</html>