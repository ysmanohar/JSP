<%-- 
    Document   : SelectCar
    Created on : Nov 11, 2016, 6:46:40 PM
    Author     : mannu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.Users" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Choose Car</title>
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
<head>
</head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
 
<body>
    <%
  /*  String name = request.getParameter("name");
    String email= request.getParameter("email");
    Users user = new Users();
    user.setFirstname(name);
    user.setEmail(email);
    HttpSession currentsession = request.getSession();
    currentsession.setAttribute("user", user);    */
	%>
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
                                            <ul>
							<li><a href="index.html">Home</a></li>
							<li><a href="ControllerServlet?action=checksession">My Booking</a></li>
						</ul>
					</div>
					<div class="clear"> </div>
					<p>
					
					<!---End-top-nav---->
				</div>
			</div>
                        <br>
                        <h2 style="text-align: center"> Select a Car & Enjoy your Ride </h2>
                        <p style="text-align: center;color:red"><pb>${message}</pb></p>
                        <br>
                        <div class="wrap">
			 		<div class="col span_2_of_3">
			 			<a href="#"><img src="images/nano.jpg" height="300%" width="80%"/></a>
			 			
			 		</div>
			 		<div class="col span_1_of_3">
                                               <h3> Model Details </h3>
                                               <ul>
                                                   <li> Model : Tata Nano </li>
                                                   <li> category : Economy </li>
                                                   <li> Max. Speed : 65mph </li>
                                                   <li> Cost/day : $21 *</li>
                                               </ul>
                                               <br>
                                          <a href="ControllerServlet?action=checkUser&amp;carCode=nano" class="btn btn-success" role="button">Book-A-Car</a> 
			 		     
			 			</div>
			 		
			 		<div class="clear"> </div>
                                        <br>
                                        <div class="col span_2_of_3">
			 			<a href="#"><img src="images/nissan.jpg" height="300%" width="80%"/></a>
			 			
			 		</div>
			 		<div class="col span_1_of_3">
                                               <h3> Model Details </h3>
                                               <ul>
                                                   <li> Model : Nissan Verna </li>
                                                   <li> category : Compact </li>
                                                   <li> Max. Speed : 80mph </li>
                                                   <li> Cost/day : $25 *</li>
                                               </ul>
                                               <br>
                                          <a href="ControllerServlet?action=checkUser&amp;carCode=nissan" class="btn btn-success" role="button">Book-A-Car</a> 
			 		     
			 			</div>
                                        
                                        <div class="col span_2_of_3">
			 			<a href="#"><img src="images/elantra.jpg" height="300%" width="80%"/></a>
			 			
			 		</div>
			 		<div class="col span_1_of_3">
                                               <h3> Model Details </h3>
                                               <ul>
                                                   <li> Model : Hyundai Elantra </li>
                                                   <li> category : Intermediate </li>
                                                   <li> Max. Speed : 90mph </li>
                                                   <li> Cost/day : $28 *</li>
                                               </ul>
                                               <br>
                                          <a href="ControllerServlet?action=checkUser&amp;carCode=elantra" class="btn btn-success" role="button">Book-A-Car</a> 
			 		     
			 			</div>
			 		
			 		<div class="clear"> </div>
                                        <div class="col span_2_of_3">
			 			<a href="#"><img src="images/chrysler.PNG" height="300%" width="80%"/></a>
			 			
			 		</div>
			 		<div class="col span_1_of_3">
                                               <h3> Model Details </h3>
                                               <ul>
                                                   <li> Model : Chrysler 300 </li>
                                                   <li> category : Standard </li>
                                                   <li> Max. Speed : 105mph </li>
                                                   <li> Cost/day : $33 *</li>
                                               </ul>
                                               <br>
                                          <a href="ControllerServlet?action=checkUser&amp;carCode=chrysler" class="btn btn-success" role="button">Book-A-Car</a> 
			 		     			 			</div>
		 	<div class="clear"> </div>
                                        <div class="col span_2_of_3">
			 			<a href="#"><img src="images/bmw_1.jpg" height="300%" width="80%"/></a>
			 			
			 		</div>
			 		<div class="col span_1_of_3">
                                               <h3> Model Details </h3>
                                               <ul>
                                                   <li> Model : BMW </li>
                                                   <li> category : Premiem </li>
                                                   <li> Max. Speed : 120mph </li>
                                                   <li> Cost/day : $38 *</li>
                                               </ul>
                                               <br>
                                          <a href="ControllerServlet?action=checkUser&amp;carCode=bmw" class="btn btn-success" role="button">Book-A-Car</a> 
			 		     
			 			</div>	
                        </div>
</body>
</html>
