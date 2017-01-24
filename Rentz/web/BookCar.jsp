<%-- 
    Document   : BookCar
    Created on : Nov 15, 2016, 11:41:53 PM
    Author     : mannu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>

	<head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Book a Car</title>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/css/bootstrap-select.min.css">
                
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/js/bootstrap-select.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    
    
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
    
    
    
    
    
                     <script type="text/javascript">
                        $('.clockpicker').clockpicker();
                        </script>
                        
                       <script>
                         $(document).ready(function(){
                        $("#dropoff").hide();
                         });
                         </script>


                    <script>
                        $(function () {
                            $("#datepicker").datepicker({minDate: 0, maxDate: "+555000D"});
                            $("#datepicker").datepicker("setDate", new Date());
                            $("#datepicker").datepicker("option", "dateFormat", "dd/mm/yy");
                        });

                        $(function () {
                            $("#startdate").datepicker({minDate: 0, maxDate: "+555000D"});
                            $("#startdate").datepicker("setDate", new Date());
                            $("#startdate").datepicker("option", "dateFormat", "dd/mm/yy");
                        });
                        
                        $(function () {
                            $("#enddate").datepicker({minDate: 0, maxDate: "+555000D"});
                            $("#enddate").datepicker("setDate", new Date());
                            $("#enddate").datepicker("option", "dateFormat", "dd/mm/yy");
                        });
                    </script>
    
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
                
                <script>
$(document).ready(function(){
    $("#return").click(function(){
        $("#dropoff").toggle();
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

p.padding {
    padding-left: 2cm;
    font-size: 200%;
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
							<li class="active"><a href="index.html">Home</a></li>
							<li><a href="EditProfile.jsp">Edit Profile</a></li>
							<li><a href="contact.jsp">Contact</a></li>
							<li><a href="${pageContext.request.contextPath}/ControllerServlet?action=Logout">LogOut</a></li>
							<div class="clear"> </div>
						</ul>
					</div>
					<div class="clear"> </div>
					<!---End-top-nav---->
                                        
				</div>
                                                        
			</div>
                                                        <br>
                                                        
                                                        <p class="padding">                     Welcome ${user.firstname} </p>    
			<!---End-header----->
			<!--start-image-slider---->
                        
                        <c:choose>
                            <c:when test="${carCode == 'nano'}">
                                <a href="#"><img src="images/nano.jpg" style="height:400px;width:800px;margin-left: auto;margin-right: auto;display: block;"></a>
                            </c:when>
                                <c:when test="${carCode == 'nissan'}">
                                <a href="#"><img src="images/nissan.jpg" style="height:400px;width:700px;margin-left: auto;margin-right: auto;display: block;"></a>
                            </c:when>
                                <c:when test="${carCode == 'elantra'}">
                                <a href="#"><img src="images/elantra.jpg" style="height:400px;width:800px;margin-left: auto;margin-right: auto;display: block;"></a>
                            </c:when>
                                <c:when test="${carCode == 'chrysler'}">
                                <a href="#"><img src="images/chrysler.PNG" style="height:400px;width:700px;margin-left: auto;margin-right: auto;display: block;"></a>
                            </c:when>
                                <c:when test="${carCode == 'bmw'}">
                                <a href="#"><img src="images/bmw_1.jpg" style="height:400px;width:700px;margin-left: auto;margin-right: auto;display: block;"></a>
                            </c:when>
                         </c:choose>
                                <br>  
                                <h3 style="text-align: center;font-size: 200%"><b> Please Fill your Booking Details </b></h3>
                                <br>
                                <p style="text-align: center;color:red"><pb>${message}</pb></p>
<br>
                         <div class="container">
                            <form>
                              <div class="form-group">
                                <div class="col-xs-4">
                                  <label for="ex1">Choose Pick-Up Location</label>
                                  <select name="location">
  					<option value="uncc">UNC Charlotte</option>
 					 <option value="UT">UT Drive</option>
                                         <option value="Ashford">Ashford</option>
                                         <option value="UTN">UT North</option>
                                         </select>
                                  <div class="checkbox" id="return">
                                     <label><input type="checkbox" value="" name="return" style="font-size:200%">Return Car to different Location (*Additional charges may apply)</label>
                                      </div>
                                  <div id="dropoff">
                                     <label for="ex1">Choose Drop-Off Location</label>
                                  <select name="retlocation">
  					<option value="uncc">UNC Charlotte</option>
 					 <option value="UT">UT Drive</option>
                                         <option value="Ashford">Ashford</option>
                                         <option value="UTN">UT North</option>
                                         </select> 
                                  </div>
                                  <div class="checkbox">
                                     <label><input type="checkbox" value="" name="liable" style="font-size:200%">Add Liable Protection ($10/day)</label>
                                        </div>
                                            <div class="checkbox">
                                     <label><input type="checkbox" value="" name="fullpro" style="font-size:200%">Add Full Protection ($15/day)</label>
                                        </div>
                                </div>
                                <div class="col-xs-2">
                                  </div>
                                  <div class="col-xs-6">
                                   <label for="Pick-Up">Enter Pick-Up Date and Time</label>  
                                   <br>
                                      <div class="col-sm-4">
                                        <input type="text" class="form-control" id="startdate" name="startdate">
                                     </div>  
                                   <div class="col-sm-5">
                                       <select name="starttime">
  					<option value="0">12 A.M</option>
 					 <option value="1">1 A.M</option>
                                         <option value="2">2 A.M</option>
                                         <option value="3">3 A.M</option>
                                         <option value="4">4 A.M</option>
 					 <option value="5">5 A.M</option>
                                         <option value="6">6 A.M</option>
                                         <option value="7">7 A.M</option>
                                         <option value="8">8 A.M</option>
 					 <option value="9">9 A.M</option>
                                         <option value="10">10 A.M</option>
                                         <option value="11">11 A.M</option>
                                         <option value="12">12 P.M</option>
 					 <option value="13">1 P.M</option>
                                         <option value="14">2 P.M</option>
                                         <option value="15">3 P.M</option>
                                         <option value="15">4 P.M</option>
                                         <option value="16">5 P.M</option>
                                         <option value="17">6 P.M</option>
                                         <option value="18">7 P.M</option>
                                         <option value="19">8 P.M</option>
                                         <option value="20">9 P.M</option>
                                         <option value="21">10 P.M</option>
                                         <option value="22">11 P.M</option>
                                         <option value="23">12 P.M</option>
                                         </select>
                                       </div>
                </div>
                                        
                                  
                             <div class="col-xs-2">
                                  </div>    
                                  
                            <div class="col-xs-6">
                                   <br> 
                                   <label for="Drop-Off">Enter Drop-Off Date and Time</label>  
                                   <br>
                                      <div class="col-sm-4">
                                        <input type="text" class="form-control" id="enddate" name="enddate">
                                     </div>  
                                   <div class="col-sm-5">
                                       <select name="endtime">
  					<option value="0">12 A.M</option>
 					 <option value="1">1 A.M</option>
                                         <option value="2">2 A.M</option>
                                         <option value="3">3 A.M</option>
                                         <option value="4">4 A.M</option>
 					 <option value="5">5 A.M</option>
                                         <option value="6">6 A.M</option>
                                         <option value="7">7 A.M</option>
                                         <option value="8">8 A.M</option>
 					 <option value="9">9 A.M</option>
                                         <option value="10">10 A.M</option>
                                         <option value="11">11 A.M</option>
                                         <option value="12">12 P.M</option>
 					 <option value="13">1 P.M</option>
                                         <option value="14">2 P.M</option>
                                         <option value="15">3 P.M</option>
                                         <option value="15">4 P.M</option>
                                         <option value="16">5 P.M</option>
                                         <option value="17">6 P.M</option>
                                         <option value="18">7 P.M</option>
                                         <option value="19">8 P.M</option>
                                         <option value="20">9 P.M</option>
                                         <option value="21">10 P.M</option>
                                         <option value="22">11 P.M</option>
                                         <option value="23">12 P.M</option>
                                         </select>
                                      
</div>
                </div>      
                                  </div>
                              </div>
                                
                                <div class="form-group">
                                    <div class="col-xs-5">
                                         </div>
                                    <div class="col-xs-4">
                                        <br>
                                            
                                        
                                           <input type="submit" value="Proceed for Booking" >  
                                             <input type="hidden" name="action" value="booking"> 
                                             </div>
                                    </div>
                            </form>
                          </div>

                                
                                
                                
          </body>
          </html>
          
                        
	



