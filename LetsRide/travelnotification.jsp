<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.domain.User" %>
    <%@page import="com.domain.Travel" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import="com.domain.Notification " %>
    <%@page import="com.domain.Action " %>
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

<% ArrayList<Notification> notif=new ArrayList<Notification>();
    notif=(ArrayList<Notification>)request.getAttribute("notifications");
    ArrayList<String> source=new ArrayList<String>();
    ArrayList<String> destination=new ArrayList<String>();
    ArrayList<String> driverNameList=new ArrayList<String>();
    source=(ArrayList<String>)request.getAttribute("source");
    destination=(ArrayList<String>)request.getAttribute("destination");
    driverNameList=(ArrayList<String>)request.getAttribute("drivernamelist");
    //notif.get(i).getDriverid()%>
    
    <table align="center" border="5" colspan=3>
<tr><td><b>Traveller Name</td><td>  | </td><td><b>Action</td><td><b>Source</td><td><b>Destination</td></tr><%
    
    for(int i=0;i<notif.size();i++)
    {
    	
%>

           
            <tr><td><%=driverNameList.get(i) %></td>
            <td>  | </td>
            <td align="right"><%=notif.get(i).getAction() %></td>
            <td align="right"><%=source.get(i) %></td>
            <td align="right"><%=destination.get(i) %></td></tr>
            


<%} %>

<%
for(int i=0;i<notif.size();i++)
    {
	  %><br /><%=(i+1)%><%
    	if(notif.get(i).getFromTable().equals("myrides"))
    	{
%>
        
       <b><%=notif.get(i).getAction() %></b> operation took place in the ride created by driver <b><%=driverNameList.get(i) %></b>
        in the ride from  <b><%=source.get(i) %></b> to <b><%=destination.get(i) %></b> 
           
            


<%}else{
	%>
	 
	Driver <b><%=driverNameList.get(i) %></b> has done <b><%=notif.get(i).getAction() %></b> operation <%
}
    	} %>

</body>
</html>