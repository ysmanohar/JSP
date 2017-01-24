<%-- 
    Document   : ConfirmBooking
    Created on : Nov 20, 2016, 7:19:07 PM
    Author     : mannu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		    <script type="text/javascript" src="js/camera.min.js"></script>
				<script type="text/javascript">
			   jQuery(function(){
				jQuery('#camera_wrap_1').camera({
					height: '500px',
					pagination: false,
				});
			});
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
							<li><a href="contact.html">Contact</a></li>
							<li><a href="${pageContext.request.contextPath}/ControllerServlet?action=Logout">LogOut</a></li>
							<div class="clear"> </div>
						</ul>
					</div>
					<div class="clear"> </div>
					<!---End-top-nav---->
				</div>
			</div>
			<!---End-header----->
			<!--start-image-slider---->
                        <h3 style="text-align: center"><pb> Please verify and confirm your booking details </pb></h3>
                        
                        <div class="container">
                            <form>
                              <div class="form-group">
                                <div class="col-xs-5">
                                    <h3 style="text-align: center"> Personal Details</h3>
                                    <br>
                                    <p><b> First name : </b> <c:out value="${user.firstname}"/> </p>
                                    <p> <b> Last name :  </b><c:out value="${user.lastname}"/> </p>
                                    <p> <b> E-mail : </b> <c:out value="${user.email} "/></p>
                                    <p> <b> Sex : </b> <c:out value="${user.sex}"/> </p>
                                    <p>  <b>Phone : </b> <c:out value="${user.phone}"/> </p>
                                    <p> <b> Age : </b> <c:out value=" ${user.age}"/> </p>
                                    <p> <b> License ID : </b><c:out value=" ${user.licenseId}"/> </p>
                                    <p> <b> Zip : </b> <c:out value="${user.zip}"/> </p>
                                    <br>
                                    <a href="EditProfile.jsp" class="btn btn-info" role="button">Edit Personal Info</a> 
                                </div>
                                <div class="col-xs-2">
                                  </div>
                                  <div class="col-xs-5">
                                   <h3 style="text-align: center"><pb> Booking details </pb></h3>  
                                   <br>
                                   <p><b> Car Model : </b>${carCode}  </p>
                                   <p><b> Car Category : </b> ${cardata.category} </p>
                                   <p><b> Pick-Up Date :  </b>${car.indate}  </p>
                                   <p><b> Pick-Up Time :  </b>${car.intime}:00  </p>
                                   <p><b> Pick-Up Location :  </b>${car.location} </p>
                                   <p><b> Drop-Off Date :  </b>${car.outdate}  </p>
                                   <p><b> Drop-Off Time :  </b>${car.outtime}:00  </p>
                                   <p><b> Return Car to Different Location :  </b>${car.returnloc}   </p>
                                   <p><b> Add liability Protection:  </b>${car.liablePro}   </p>
                                   <p><b> Add Full Protection:  </b>${car.fullPro}   </p>
                                        
                                   
                </div>
                                        
                                  
                                   
                                  </div>
                            </form>
                              </div>
                              
                          <div class="container">
                            
                              <div class="form-group">
                                  <div class="col-xs-3"></div>
                                  <div class="col-xs-6">
                                      <br>
                                      <h3 style="text-align: center"> Final Amount </h3>
                                      <br>
                                      <p><b> No. of days booked :</b><c:out value=" ${cost.days} days"   /> </p>
                                      <p><b> Cost of Booking : </b><c:out value=" $${cost.carcost}"  /> </p>
                                      <p><b> Additional cost for different Drop-off Location : </b><c:out value="$${cost.retlocation} "/>   </p>
                                      <p><b> Additional cost for Liability Protection :</b><c:out value=" $${cost.liability} "/>  </p>
                                      <p><b> Additional cost for Full Protection :</b> <c:out value="$${cost.full} "/>  </p>
                                      <p><b> Tax(5% of Total) : </b><c:out value="$${cost.tax} "/>  </p>
                                      <p><b> Final Amount : </b><c:out value="$${cost.finalcost} "/>  </p>
                                      <div class="col-sm-4"></div
                                      <div class="col-sm-4">
                                          <form>
                                              
                                          <input type="submit" value="Confirm Booking">
                                           <input type="hidden" name="action" value="ConfirmBooking">
                                      </form>
                                      </div>
                                      <div class="col-sm-4"></div>
                                      
                                  </div>
                                  <div class="col-xs-3"></div>
                              </div>
                          </div>
                                  
	</body>
</html>


