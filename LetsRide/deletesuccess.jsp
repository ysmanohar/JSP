<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!!%></title> 
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
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
	    color : black;
	    font-style: italic;
	    font-size: 50px;
	      }
	    </style>

</head>  
<body>  
<body>  
			<!---start-header----->
			<div class="header"  id="top">
				<div class="wrap">
					<!---start-logo---->
					<div class="logo">
						<a href="index.html"><img src="projectpic.PNG" title="logo" /></a>
					</div>
					<!---End-logo---->
					<!---start-top-nav---->
					<div class="top-nav">
					</div>
					<div class="clear"> </div>
					<p>
					<br>
					<!---End-top-nav---->
				</div>
			</div>
			<!---End-header----->
			<p>
			<br>
  <center><img src="carpool.png" align="middle" alt="Lets Ride" ><center>
  <br>
  <br>
  <br>
  <pre>
    <pa>Your ride is deleted. Sit tight, we will notify the driver!!!!</pa>  
  </pre>    
<br>

<a href="welcome.jsp"><img src="back.jpg" title="login" height="50px" width="150px"></a>
        

     



        

</body>
</html>
</body>  
</html>  