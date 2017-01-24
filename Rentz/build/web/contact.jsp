<%-- 
    Document   : contact
    Created on : Nov 27, 2016, 3:08:42 PM
    Author     : mannu
--%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>CITY TAXI Website Template | Contact :: W3layouts</title>
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
        
        
	</head>
	<body>
		<!---strat-wrap----->
		
			<!---strat-header----->
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
							<li class="active"><a href="contact.html">Contact</a></li>
							<li><a href="Login.jsp">Login</a></li>
							 </div>
						</ul>
					</div>
					<div class="clear"> </div>
					<!---End-top-nav---->
				</div>
			</div>
		
                        <!---End-header----->
		 <!---start-contnet---->
		 <div class="content">
		 	<!---start-contact----->
		 	<div class="contact">
		 		<div class="wrap">
				<div class="section group">				
				<div class="col span_1_of_3">
					<div class="contact_info">
			    	 	<h3>Find Us Here</h3>
			    	 		<div class="map">
					   			<iframe width="100%" height="175" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe><br><small><a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265" style="color:#666;text-align:left;font-size:12px">View Larger Map</a></small>
					   		</div>
      				</div>
      			<div class="company_address">
				     	<h3>Company Information :</h3>
						    	<p>9505 University Terrace Dr.</p>
						   		<p>Charlotte, NC</p>
                                                                <p>Phone:7049538355</p>
				 	 	<p>Email: <span>mannu610@gmail.com</span></p>
				   		
				   </div>
				</div>				
				<div class="col span_2_of_3">
				  <div class="contact-form">
				  	<h3>Contact Us</h3>
                                        <p style="text-align: center;color:red"><pb>${message}</pb></p>
                                  <br>
					    <form action="ControllerServlet" method="post">
					    	<div>
						    	<span><label>NAME</label></span>
						    	<span><input name="userName" type="text" class="textbox" required></span>
						    </div>
						    <div>
						    	<span><label>E-MAIL</label></span>
						    	<span><input name="userEmail" type="text" class="textbox" required></span>
						    </div>
						    <div>
						     	<span><label>MOBILE</label></span>
						    	<span><input name="userPhone" type="text" class="textbox" required></span>
						    </div>
						    <div>
						    	<span><label>SUBJECT</label></span>
						    	<span><textarea name="userMsg" required> </textarea></span>
						    </div>
						   <div>
						   		<input type="submit" value="Submit">
                                                                <input type="hidden" name="action" value="doubt">
                                                                
						  </div>
					    </form>

				    </div>
  				</div>				
			  </div>
			</div>
			</div>
		 	<!---End-contact----->
		 	
		 </div>
		 <!---End-contnet---->
		</div>
		<!---End-wrap----->
	</body>
</html>
