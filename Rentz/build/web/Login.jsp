
<!DOCTYPE HTML>
<html>
	<head>
		<title>LETS RIDE Website Template | Home :: W3layouts</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link href="css/slider.css" rel="stylesheet" type="text/css"  media="all" />
		  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		  <script type="text/javascript" src="js/jquery.easing.1.3.js"></script> 
                  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                  <script src="https://apis.google.com/js/platform.js" async defer></script>
		    <script type="text/javascript" src="js/camera.min.js"></script>
     <!--               <meta name="google-signin-client_id" content="449330624610-167kjq3iqn975274rjuf4or8hpa7t7ta.apps.googleusercontent.com">  -->  
				<script type="text/javascript">
			   jQuery(function(){
				jQuery('#camera_wrap_1').camera({
					height: '500px',
					pagination: false,
				});
			});
                        
                        function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
                              var profile = googleUser.getBasicProfile();
                              console.log("ID: " + profile.getId()); // Don't send this directly to your server!
                              console.log('Full Name: ' + profile.getName());
                              console.log('Given Name: ' + profile.getGivenName());
                              console.log('Family Name: ' + profile.getFamilyName());
                              console.log("Image URL: " + profile.getImageUrl());
                              console.log("Email: " + profile.getEmail());
                                // The ID token you need to pass to your backend:
                                var id_token = googleUser.getAuthResponse().id_token;
                                console.log("ID Token: " + id_token);
                               window.location.assign("http://localhost:8080/Rentz/SelectCar.jsp?name=profile.getName()&email=profile.getEmail()")
                              };
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
input[type=text], select {
    width: 90%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 2px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
   }
   
   img {
    max-width: 100%;
    
    width:200px;
    left: 0px;
    position: relative;
    }


input[type=password], select {
    width: 90%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 2px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    
}

input[type=submit] {
    width: 45%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    
}

pa {
	    color : black;
	    font-style: italic;
	    font-size: 35px;
	      }
	      
input[type=submit]:hover {
    background-color: #45a049;
}

div.relative {
    position: relative;
    border: 3px; 
    width: 30%;  
    background-color: #f2f2f2;
    padding: 30px;
    margin: auto;}

   
    
    




input[type=text], select {
    width: 90%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 2px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
   }
   
   img {
    max-width: 100%;
    
    width:200px;
    left: 0px;
    position: relative;
    }


input[type=password], select {
    width: 90%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 2px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    
}

input[type=submit] {
    width: 45%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    
}

input[type=submit]:hover {
    background-color: #45a049;
}

div.relative {
    position: relative;
    border: 3px; 
    width: 30%;  
    background-color: #f2f2f2;
    padding: 30px;
    margin: auto;}

    </style>
	</head>
	<body>
		<!---strat-wrap----->
		
			<!---start-header----->
			<div class="header"  id="top">
				<div class="wrap">
					<!---start-logo---->
					<div class="logo">
						<a href="index.html"><img src="images/mainlogo.PNG" title="logo" height="50" width="150"></a>
					</div>
					<!---End-logo---->
					<!---start-top-nav---->
					<div class="top-nav">
						<ul>
							<li><a href="index.html">Home</a></li>
							<li><a href="contact.jsp">Contact</a></li>
							<li class="active"><a href="Login.jsp">Login</a></li>
							<div class="clear"> </div>
						</ul>
					</div>
					<div class="clear"> </div>
					<!---End-top-nav---->
				</div>
			</div>
			<!---End-header----->
			<!--start-image-slider---->
                        <h3 style="text-align: center"><pb> Login with your Credentials </pb></h3>
                        <br>
                        <p style="text-align: center;color:red"><pb>${message}</pb></p>
                          <br>
			<div class="container-fluid">
                          <div class="relative">
                                <div>
                                  <form action="ControllerServlet" method="post" onsubmit="return myFunction()">
                                    <label for="fname"><b> E-mail</b></label> <br>
                                    <input type="text" id="fname" name="username" required="required" placeholder="Enter Name">
                                    <br> 
                                    <p>
                                    <label for="lname"><b>Password</b></label>  <br>
                                    <input type="password" id="lname" name="userpass" required="required" placeholder="Enter Password">
                                    <br>
                                        <input type="submit" value="Sign In">
                                        <input type="hidden" name="action" value="login">
                                        <div class="g-signin2" data-onsuccess="onSignIn"></div>
                                        <br>
                                  </form>
                                    <a href=register.jsp>New User? Sign Up</a>
                                    <br>
                                    <br>
                                    <a href ="ForgotPass.jsp">Forgot Password? </a>
                                </div>
                                </div>
                                </div>
                          


                                  
	</body>
</html>

