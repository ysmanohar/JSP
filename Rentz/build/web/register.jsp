<!DOCTYPE HTML>
<html>
	<head>
		<title>Register</title>
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
input[type=text], select {
    width: 140%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 2px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
   }
   
   input[type=password], select {
    width: 140%;
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
    padding: 10px 0px 20px 15px;
    margin: 2px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
 }
 pb {
    font-family: "Times New Roman";
    font-style: italic;
    font-size: 40px;
    text-align: center;
} 
</style>
<script>
function validate(){

	  var f = document.forms["signup"]["firstname"].value;
          window.alert("Hi");
	  var l = document.forms["signup"]["lastname"].value;
	  var e = document.forms["signup"]["email"].value;
	  var s = document.forms["signup"]["sex"].value;
	  var u = document.forms["signup"]["userpass"].value;
	  var cp = document.forms["signup"]["confirmpass"].value;
	  var p = document.forms["signup"]["phone"].value;
	  var a = document.forms["signup"]["age"].value;
	  var c = document.forms["signup"]["city"].value;
	  var z = document.forms["signup"]["zip"].value;
	  
	  
	  if (f == "" ||l == "" ||e == "" ||s == "" ||u == "" ||cp == "" ||p == "" ||a == "" ||c == "" ||z == ""){
          document.getElementById('error').innerHTML = "all values are mandatory";
          return false;
      }
	  else if(u!=cp){
		  document.getElementById('error').innerHTML = "Password and Confirm password do not match";
          return false;
	  }
      else
          return true;
	  }
</script>
<head>
</head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lets Ride</title>
</head>
 
<body>
		<!---start-wrap----->
		
			<!---start-header----->
			<div class="header"  id="top">
				<div class="wrap">
					<!---start-logo---->
					<div class="logo">
						<a href="index.html"><img src="images/mainlogo.PNG" title="logo" /></a>
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
		 <!---start-content---->
		 
		 		  	<h3 style="text-align: center"><pb>                                       Please create your Account</pb></h3>
		 		  	
		 <div class="content">
		 	<!---start-contact----->
		 	<div class="contact">
		 		<div class="wrap">
				<div class="section group">				
				<div class="col span_1_of_3">
					<div class="img-responsive">
					
			    	 	
      				</div>
      			</div>	
      		<div class="text-center">
				<div class="col span_2_of_3">
				  <div class="Register-form">
  
       <form action="ControllerServlet" method="post" onsubmit="return validate()" >  
        <fieldset style="width: 300px">  
        <fieldset style="width: 300px">  
            
            <table align="center"> 
              <div style="background:#F9EECF;" name="error" id="error">
                  <p><i>${message}</i></p>
    </div> 
            <div class="form-group">
                <tr>  
                    <td>Firstname</td>  
                    <td width="70%"><input type="text" name="firstname" id="firstname" required="required" placeholder="Enter First Name"></td>  
                </tr>  
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Lastname</td>  
                    <td><input type="text" name="lastname" required="required" placeholder="Enter Last Name"  /></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Email ID</td>  
                    <td><input type="text" name="email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required="required" placeholder="Enter E-mail" /></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Sex</td>  
                    <td>               <select name="sex">
  					<option value="male">Male</option>
 					 <option value="female">Female</option>
					</select>
				 </td>  
                </tr>
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
 
                <tr>  
                    <td>Password</td>  
                    <td><input type="password" name="userpass" required="required" placeholder="Enter Password" /></td>  
                </tr>
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td>Confirm Password</td>  
                    <td><input type="password" name="confirmpass" required="required" placeholder="Re-Enter Password"  /></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                 <tr>  
                    <td>Phone</td>  
                    <td><input type="text" name="phone" maxlength=10 required="required" placeholder="Enter Phone no." /></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td>Age</td>  
                    <td><input type="text" name="age" required="required" placeholder="Enter Age" /></td>  
                </tr> 
                </div>
                
                
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td width="50%">Driving License Id</td>  
                    <td><input type="text" name="license" required="required" placeholder="Enter License no."  /></td>  
                </tr>  
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td>Zip</td>  
                    <td><input type="text" name="zip" required="required" placeholder="Enter Zip" /></td>  
                </tr>     
                </div>
                <tr><td><br></td></tr>
                     
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td colspan=4 align="center">
                       <input type="submit" value="Sign Up" >  
                         <input type="hidden" name="action" value="register">   
                    </td>  
                </tr>  
                </div>
                        
        </fieldset>  
    </form> 

				    </div>
  				</div>				
			  </div>
			  </div>
			</div>
			</div>
			</div>
		 	<!---End-contact----->
	
		
		 
	</body>
</html>