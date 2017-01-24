<%@page import="com.domain.User" %>
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
 
  <%
    User user =(User) session.getAttribute("name");
    //int count=(Integer)request.getAttribute("count");
    String name=user.getFirstname();
    System.out.println("name"+name);
	%>    
<title>Welcome <%=name%></title>  
</head>  
<body> 
			<!---start-header----->
			<div class="header"  id="top">
				<div class="wrap">
					<!---start-logo---->
					<div class="logo">
						<a href="home.jsp"><img src="projectpic.PNG" title="logo" ></a>
					</div>
					<!---End-logo---->
					<!---start-top-nav---->
					<div class="top-nav">
						<ul>
							<li class="active"><a href="welcome.jsp">Home</a></li>
							<li><a href="travelnotification?name=<%=user.getFirstname()%>">Notifications()</a></li>
							<li><a href="update?name=<%=user.getFirstname()%>">Update Profile</a></li>
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

<h1 class="text-center"> Lets share a Ride! </h1>
<p>
<br>
 <div style="background:#F9EECF;" name="error" id="error"> 
    </div>
<br>
       <form name="frm" action="Search" method="post" onsubmit="return validateSearch()">  
        
      
       <div class="row">
            <div class="col-xs-1">
            <p> </p></div>
            <div class="col-xs-1">
               <label for="pid">Source</label>
                 </div>
        <div class="col-xs-3">
         <input  type="text" class="form-control" name="pid" id="pid">
        </div>
           <div class="col-xs-1">
            <p> </p></div>
            <div class="col-xs-1">
               <label for="destination">Destination</label>
                 </div>
                 <div class="col-xs-3">
         <input  type="text" class="form-control" name="destination" id="destination">
                </div>
               <div class="col-lg-2">
                <button type="submit" class="btn btn-success">Search</button> 
               
            </div>
        </div>
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