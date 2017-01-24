<%-- 
    Document   : Mybooking
    Created on : Nov 27, 2016, 3:04:28 AM
    Author     : mannu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

<style>
            table {
    border: 1px solid black;
    border-collapse: collapse;
    width: 50em;
}
th, td {
    border: 1px solid black;
    text-align: left;
    padding: .5em;
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
						<a href="index.html"><img src="images/mainlogo.PNG" title="logo" /></a>
					</div>
					<!---End-logo---->
					<!---start-top-nav---->
					<div class="top-nav">
                                            <ul>
							<li><a href="index.html">Home</a></li>
							<li><a href="${pageContext.request.contextPath}/ControllerServlet?action=Logout">Logout</a></li>
						</ul>
					</div>
					<div class="clear"> </div>
					<p>
					
					<!---End-top-nav---->
				</div>
			</div>
<h3 style="text-align: center"><pb> My Bookings: </pb></h3>
<p style="text-align: center;color:red"><pb>${message}</pb></p>
<br>
<div class="container">
                              <div class="form-group">
                                  <div class="col-xs-2"></div>
                                  <div class="col-xs-5">
<table>
            
            <tr>
                <th>Model</th>
                <th>Pick-Up Date</th>
                <th>Pick-Up Time</th>
                <th>Drop-Off Date</th>
                <th>Drop-Off Time</th>
                <th>Location</th>
                <th>Final Amount</th>
                <th></th>
                
            </tr>
            <c:forEach items = "${bookinglist}" var = "booking">
                            
            <tr>
                <td><c:out value="${booking.model}"/></td>
                <td><c:out value="${booking.indate}"/></td>
                <td><c:out value="${booking.intime}:00"/></td>
                <td><c:out value="${booking.outdate}"/></td>
                <td><c:out value="${booking.outtime}:00"/></td>
                <td><c:out value="${booking.location}"/></td>
                <td><c:out value="$${booking.amount}"/></td>
                <td><a href="ControllerServlet?action=delete&indate=${booking.indate}&intime=${booking.intime}">Cancel Booking</a></td>
            </tr>
            </c:forEach>
         <!-- Hint! Remember to code for the 'Edit' and 'Delete' links -->  
        </table>
                                      </div>
                              </div>
</div>
</body>
</html>
