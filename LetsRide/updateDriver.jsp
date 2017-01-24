<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>

<%User user=new User();
   user=(User)request.getAttribute("user");
%>


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
    width: 90%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 2px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
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
 pb {
    font-family: "Times New Roman";
    font-style: italic;
    font-size: 40px;
    text-align: center;
} 
</style>
<script>
function validate() {

	  var f = document.forms["signup"]["firstname"].value;
	  var l = document.forms["signup"]["lastname"].value;
	  var e = document.forms["signup"]["email"].value;
	  var s = document.forms["signup"]["sex"].value;
	  var u = document.forms["signup"]["userpass"].value;
	  var cp = document.forms["signup"]["confirmpass"].value;
	  var p = document.forms["signup"]["phone"].value;
	  var a = document.forms["signup"]["age"].value;
	  var add = document.forms["signup"]["address"].value;
	  var c = document.forms["signup"]["city"].value;
	  var z = document.forms["signup"]["zip"].value;
	  var r = document.forms["signup"]["role"].value;
	  
	  if (f == "" ||l == "" ||e == "" ||s == "" ||u == "" ||cp == "" ||p == "" ||a == "" ||add == "" ||c == "" ||z == "" ||r == ""){
          document.getElementById('error').innerHTML = "all values are mandatory";
          return false;
      }
	  else if(u!=cp){
		  document.getElementById('error').innerHTML = "Passwords and Cofirm passwords should match";
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
							<li ><a href="welcome.jsp">Home</a></li>
							<li><a href="about.html">My Rides</a></li>
							<li class="active"><a href="/LetsRide/update?name=<%=user.getFirstname()%>">Update Profile</a></li>
							<li><a href="welcome.jsp">Logoff</a></li>
							<div class="clear"> </div>
						</ul>
					</div>
					<div class="clear"> </div>
					<!---End-top-nav---->
				</div>
			</div> 
<center><img src="carpool.png" align="middle" alt="Lets Ride" ><center>
<br>
<p>
		 <pre>
		 		  	<h3><pb>Update your profile</pb></h3>
		 		  	</pre>
		 <div class="content">
		 	<!---start-contact----->
		 	<div class="contact">
		 		<div class="wrap">
				<div class="section group">				
				<div class="col span_1_of_3">
					<div class="img-responsive">
					
			    	 	<a href="index.html"><img src="Friends.jpg"></a>
      				</div>
      			</div>	
      		<div class="text-center">
				<div class="col span_2_of_3">
				  <div class="Register-form">
  
       <form name="signup" action="update" method="post" onsubmit="return validate();">  
        <fieldset style="width: 300px">  
        <fieldset style="width: 300px">  
            <legend> Update your latest information </legend>  
            <table align="center"> 
              <div style="background:#F9EECF;" name="error" id="error"> 
    </div> 
    <div class="form-group">
                <tr>  
                    
                    <td><input type="hidden" value=<%=user.getId() %> name="id" "></td>  
                </tr>  
                </div>
            <div class="form-group">
                <tr>  
                    <td>Firstname</td>  
                    <td><input type="text" value=<%=user.getFirstname() %> name="firstname" disabled></td>  
                </tr>  
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Lastname</td>  
                    <td><input type="text" value=<%=user.getLastname() %> name="lastname" disabled/></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Email ID</td>  
                    <td><input type="text" value=<%=user.getEmail() %> name="email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required="required" placeholder="Enter E-mail" disabled/></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Sex</td>  
                    <td>               <select name="sex" disabled>
  											<option value="male">Male</option>
 											 <option value="female">Female</option>
										</select>
				 </td>  
                </tr>
                </div>
                
 
      
                <tr><td><br></td></tr>
                <div class="form-group">
                 <tr>  
                    <td>Phone</td>  
                    <td><input type="text" value=<%=user.getPhone() %> name="phone" maxlength=10 required="required" placeholder="Enter Age" /></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td>Age</td>  
                    <td><input type="text" value=<%=user.getAge() %> name="age" required="required" placeholder="Enter Age" disabled/></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td>Address</td>  
                    <td><input type="text" value=<%=user.getAddress() %> name="address" required="required" placeholder="Enter Address"  /></td>  
                </tr>
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td>City</td>  
                    <td><input type="text" value=<%=user.getCity() %> name="city" required="required" placeholder="Enter City"  /></td>  
                </tr>  
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td>Zip</td>  
                    <td><input type="text" value=<%=user.getZip() %> name="zip" required="required" placeholder="Enter Zip" /></td>  
                </tr>     
                </div>
                
                <tr><td><br></td></tr>
                <div class="form-group">
                <tr>  
                    <td colspan=2 align="center"><input type="submit" value="Update" /></td>  
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