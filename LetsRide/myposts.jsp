<%@page import="java.util.Iterator"%>
<%@ page import="java.util.*" %>
<%@ page import="com.domain.Travel" %>
<%@ page import="com.domain.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
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
		
</script>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<%
    ArrayList<Travel> travel=new ArrayList<Travel>();
    travel=(ArrayList<Travel>)request.getAttribute("travel");
    
	%>  
<title>My Posts</title>  
</head>  
<body>  <!---start-header----->
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
							<li class="active"><a href="frommyposts.jsp">Home</a></li>
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
     


        <table width="900px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=6 align="center"
                    style="background-color:aqua;">
                    <b>User Record</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                
                <td><b>Driver Id</b></td>
                <td><b>Destination</b></td>
                <td><b>Source</b></td>
                <td><b>Price</b></td>
                <td><b>Distance</b></td>
                <td><b></b></td>
               
            </tr>
    <%for(int i=1;i<travel.size();i++){ %>
         <!--    <form action="${pageContext.request.contextPath}/booking" method=GET> -->
            <tr style="background-color:""blue">
               
               
               <td><%=travel.get(i).getUserid()%></td>
               <td><%=travel.get(i).getDestination()%></td>
               <td><%=travel.get(i).getSource()%></td>
                <td><%=travel.get(i).getPrice()%></td>
                <td><%=travel.get(i).getDistance()%></td>
                <td><form name="submitForm" method=post action="/LetsRide/deleteride">
                        <input type="hidden" name="travelid" value="<%=travel.get(i).getId()%>">
                        <input type=submit value="delete"></form></td>
                            
                
             </input>
            </tr>
            
            <%
                   	  
    }
                
                  
                	   
            %>
           
            </form>
           <!--  <tr>
                <td colspan=5 align="center"
                    style="background-color:#eeffee"><b>No records found</b></td>
            </tr> ---!-->
            <%           // }
            %>
        </table>
        
          <br>
    <br>
    <a href="#p">@Copyright: A Mustangs Prd.. All Rights Reserved@2016</a>
    </body>
</html>