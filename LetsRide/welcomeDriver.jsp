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
   <script>
   function getMoreFields() {
	  //alert('Clicked');
	  var d = document.getElementById("moreFields");
	  var newName1 = document.createElement("TH");
	  d.innerHTML="sdjbsdk";
	  
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
			  document.getElementById('error').innerHTML = "Password and Confirm password do not match";
	          return false;
		  }
	      else
	          return true;
		  }
  	</script>
	
	<script language="javascript">
var addid = 0;
var count = 0;
function addInput(id){
    var docstyle = document.getElementById('addlist').style.display;
    if(docstyle == 'none')
        document.getElementById('addlist').style.display = '';

    addid++;
    //count=addid;
    
    
    	
    //var text = "<br><br /><div id='additem_"+addid+"'><input type='text' size='100' value='' class='buckinput' name='items[]' style='padding:5px;' /> <a href='javascript:void(0);' onclick='addInput("+addid+")' id='addlink_"+addid+"'>add more</a></div><br>";
	//var text = "<br><br /><div id='additem_"+addid+"'><input type='text' size='10' value='' class='buckinput' name='additem_"+addid+"' style='padding:5px;' ><input type='text' size='10' value='' class='buckinput' name='srcDist_"+addid+"' style='padding:5px;' />";
	var text = "<br><br /><div id='additem_"+addid+"'><input type='text' size='10' value='' class='buckinput' name='additem_"+addid+"' style='padding:5px;' placeholder='pick-up point' ><input type='text' size='10' value='' class='buckinput' name='srcDist_"+addid+"' style='padding:5px;' placeholder='distance from source' />";
	
	if(addid<3){
    document.getElementById('addlist').innerHTML += text;}
}
</script>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   
 
<title>Post</title>

<style>
    img {
    max-width: 100%;
    
    width:200px;
    left: 0px;
    position: relative;
    }
    
    input[type=text], select {
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
    cursor: pointer;  }
    
    pb {
    font-family: "Times New Roman";
    font-style: italic;
    font-size: 40px;
    text-align: center;
} 

.button {
     width: 150%;
    background-color: #4CAF50;
    color: white;
    padding: 7px 0px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
.button2 {background-color: #008CBA;} 
               
      </style>
</head>
  <%
    User user =(User) session.getAttribute("name");
	%>    
  
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
							<li class="active"><a href="welcomeDriver.jsp">Home</a></li>
							<li><a href="notification?name=<%=user.getFirstname()%>">Notifications</a></li>
							<li><a href="update?name=<%=user.getFirstname()%>">Update Profile</a></li>
							<li><a href="${pageContext.request.contextPath}/logout">Logoff</a></li>
							<div class="clear"> </div>
						</ul>
					</div>
					<div class="clear"> </div>
					<!---End-top-nav---->
				</div>
			</div> 
			<p>
			<br>
<center><img src="carpool.png" align="middle" alt="Lets Ride" ><center>
<br>
<p> 

  <!--   <pre>
    <p style="font-family:trajanpro;font-size:250%;">       Welcome <%=session.getAttribute("name")%> <p>
    </pre>   -->
    <p>
    
    <p>
<form class="form-horizontal"  action="${pageContext.request.contextPath}/logout" method="post">
        <div class="row">
            <div class="col-xs-1">
            <p> </p></div>
            <div class="col-xs-2">
               <h3  for="usr" align="center"><b>Welcome <%=user.getFirstname()%>!</b></h3>
                 </div>
             
    </form>
  <!--   <pre>
    <p style="font-family:trajanpro;font-size:250%; align="center">       Welcome <%=session.getAttribute("name")%> <p>
    </pre>   -->
    <p>
    <br>
    <br>

<pb><i>Please post your travel details!!</i></pb>  



<!-- <p>
<br>
 <form method="post" name="frm" action="Search" class="form-horizontal">
 
      
       <div class="row">
            <div class="col-xs-1">
            <p> </p></div>
            <div class="col-xs-1">
               <label for="pid">Source</label>
                 </div>
        <div class="col-xs-3">
         <input  type="text" class="form-control" name="pid" id="pid">
         
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
    </form> ---!-->
    
    
  <div class="container-fluid">
   <div class="jumbotron">
      <form name="signup" action="postiti" method="post" onsubmit="return validation();">  
        <fieldset style="width: 300px">  
             
            <table align="center"> 
            <div style="background:#F9EECF;" name="error" id="error"></div> 
            <div class="form-group">
                <tr>  
                    <td>Source</td>  
                    <td><input type="text" name="source" required="required" placeholder="Source"/></td>
                    <tr><td><div id="addlist" class="alt1" style="padding:10px;">
    
	<input type="button" onclick="addInput(addlist)" value="More Inputs">
</div></td></tr>
        </div>  
                </tr>  
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Destination</td>  
                    <td><input type="text" name="destination" required="required" placeholder="destination"/></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Date</td>  
                    <td><input type=date name="day" required="required" placeholder="Date"> </td>  
                </tr> 
                </div>
         <!--        <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Month</td>  
                    <td><select name="month">
  											<option value="01">Jan</option>
 											<option value="02">Feb</option>
 											<option value="03">Mar</option>
 											<option value="04">Apr</option>
 											<option value="05">May</option>
 											<option value="06">Jun</option>
 											<option value="07">Jul</option>
 											<option value="08">Aug</option>
 											<option value="09">Sept</option>
 											<option value="10">Oct</option>
 											<option value="11">Nov</option>
 											<option value="12">Dec</option>
 											
										</select> </td>  
                </tr> 
                </div>
                
                <div class="form-group">
                  <tr>  
                    <td>Day</td>  
                    <td><select name="day">
  											<option value="6">6</option>
 											<option value="7">7</option>
 											<option value="8">8</option>
 											<option value="9">9</option>
 											<option value="10">10</option>
 											<option value="11">11</option>
 											<option value="12">12</option>
 											<option value="13">13</option>
 											<option value="14">14</option>
 											<option value="15">15</option>
 											<option value="16">16</option>
 											<option value="17">17</option>
 											<option value="18">18</option>
 											<option value="19">19</option>
 											<option value="20">20</option>
 											<option value="21">21</option>
 											<option value="22">22</option>
 											<option value="23">23</option>
 											<option value="24">24</option>
 											<option value="1">1</option>
 											<option value="2">2</option>
 											<option value="3">3</option>
 											<option value="4">4</option>
 											<option value="5">5</option>
										</select> </td>  
                </tr> 
                </div>
                   <div class="form-group">
                  <tr>  
                    <td>Year</td>  
                    <td><select name="year">
  											<option value="2016">2016</option>
 									
										</select></td>  
                </tr> 
                </div>  --!-->
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Hour-</td>  
                    <td> <select name="hour">
  											<option value="6">6</option>
 											<option value="7">7</option>
 											<option value="8">8</option>
 											<option value="9">9</option>
 											<option value="10">10</option>
 											<option value="11">11</option>
 											<option value="12">12</option>
 											<option value="13">13</option>
 											<option value="14">14</option>
 											<option value="15">15</option>
 											<option value="16">16</option>
 											<option value="17">17</option>
 											<option value="18">18</option>
 											<option value="19">19</option>
 											<option value="20">20</option>
 											<option value="21">21</option>
 											<option value="22">22</option>
 											<option value="23">23</option>
 											<option value="24">24</option>
 											<option value="1">1</option>
 											<option value="2">2</option>
 											<option value="3">3</option>
 											<option value="4">4</option>
 											<option value="5">5</option>
										</select> </td>  
                </tr> 
                </div>
                 
                <div class="form-group">
                  <tr>  
                    <td>Minute-</td>  
                    <td> <select name="minute">
  											<option value="20">20</option>
 											<option value="30">30</option>
 											<option value="40">40</option>
 											<option value="50">50</option>
 											<option value="10">10</option>
 										
										</select> </td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>            

                <div class="form-group">
                  <tr>  
                    <td>Price</td>  
                    <td><input type="text" name="price" required="required" placeholder="Price"/></td>  
                </tr> 
                </div>
           <tr><td><br></td></tr>
                <div class="form-group">
 
                <tr>  
                    <td>Distance</td>  
                    <td><input type="text" name="distance" required="required" placeholder="total distance covered" /></td>  
                </tr>
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                
                <tr>  
                    <td>Capacity</td>  
                    <td><input type="text" name="capacity" required="required" placeholder="capacity"/></td>  
                </tr> 
                </div>
                 <div class="form-group">
                <tr>  
                    <td><input type="hidden" value="<%=user.getFirstname()%>" name="sessionId"/></td>  
                </tr>  
                </div>
                <tr><td><br></td></tr>
                
                <p>                
                  
                <tr><td colspan=2 align="center"><button type="submit" class="btn btn-success">Post</button> </td></tr>
               
            
              
            </table>  
        </fieldset>  
    </form>  
    <br>
    <br>
    <a href="#p">@Copyright: A Mustangs Prd.. All Rights Reserved@2016</a>
</body>
</html>
</body>  
</html>  