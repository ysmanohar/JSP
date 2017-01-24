<%@page import="java.util.Iterator"%>
<%@ page import="java.util.*" %>
<%@ page import="com.domain.Travel" %>
<%@ page import="com.domain.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.domain.User" %>
<!DOCTYPE HTML>
<html>
	<head>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
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
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">		  
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  
 
  
		  <script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
				});
			});
		
<script>
function validateSearch() {

	  var s = document.forms["frm"]["pid"].value;
	  var d = document.forms["frm"]["destination"].value;
	  
	  if (s == ""){ // == is comparison... = is assignment
          document.getElementById('error').innerHTML = "Please enter both the values";
          return false;
      }
	  else if(s==d){
		  document.getElementById('error').innerHTML = "Source and Destination cannot be the same";
          return false;
	  }
      else
          return true;
	  }
</script>

<style>
    img {
    max-width: 100%;
    
    width:200px;
    left: 0px;
    position: relative;
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

</head>

  <%
    User user =(User) session.getAttribute("name");
    String name=user.getFirstname();
	%>    
<title>Welcome <%=user.getFirstname()%></title>  
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
							<li class="active"><a href="welcome.jsp">Home</a></li>
							<li><a href="/LetsRide/update?name=<%=user.getFirstname()%>">Update Profile</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logoff</a></li>
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
<!-- <form class="form-horizontal"  action="${pageContext.request.contextPath}/logout" method="post">
        <div class="row">
            <div class="col-xs-1">
            <p> </p></div>
            <div class="col-xs-2">
               
                 </div>
             <div class="col-xs-6">
                <p> </p></div>
             <div class="col-xs-1">
            <p> </p></div>
            <div class="col-xs-2">
            <button type="submit" class="btn btn-danger">Logoff</button> 
               <p> </p></div>  
                                           
           </div>
    </form>   --!-->
     <p>
    <br>
    <br>

<% Travel travel=new Travel();
//Date date = new Date();
travel=(Travel)request.getAttribute("bookTravel");
user=(User)request.getAttribute("user");
//date=travel.getDate();
%>
Here are your choice of travel details:
<br /><br /><b> Drivername:<%=user.getFirstname() %>
<br /><br /><b>  Source:<%=travel.getSource() %>
<br /><br /><b> Destination:<%=travel.getDestination() %>
<br /><br /><b>  Price(per mile):<%=travel.getPrice() %>
<br /><br /><b>  Contact:<%=user.getPhone() %>
<br /><br /><b>  Email:<%=user.getEmail() %>



</body>
</html>