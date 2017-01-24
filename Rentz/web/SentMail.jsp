<%-- 
    Document   : SentMail
    Created on : Dec 2, 2016, 3:14:54 PM
    Author     : mannu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
							<li><a href="${pageContext.request.contextPath}/ControllerServlet?action=Logout">LogOff</a></li>
							<div class="clear"> </div>
						</ul>
					</div>
					<div class="clear"> </div>
					<!---End-top-nav---->
				</div>
			</div>
                                                        
                                                        
                                                        <h4 style="padding-left: 550px;padding-top: 30px"> <b>Sent Query List: </b></h4>
                                                        <br>
<br>
                                                        <div class="container">
                              <div class="form-group">
                                  <div class="col-xs-2"></div>
                                  <div class="col-xs-5">
<table>
            
            <tr>
                <th><b>Customer Name</b></th>
                <th><b>E-mail</b></th>
                <th><b>Phone</b></th>
                <th><b>Doubt</b></th>
                <th><b>Reply</b></th>
                
                
            </tr>
            <c:forEach items = "${sentlist}" var = "slist">
                            
            <tr>
                <td><c:out value="${slist.name}"/></td>
                <td><c:out value="${slist.email}"/></td>
                <td><c:out value="${slist.mobile}"/></td>
                <td><c:out value="${slist.doubt}"/></td>
                <td><c:out value="${slist.reply}"/></td>
            </tr>
            </c:forEach>
         <!-- Hint! Remember to code for the 'Edit' and 'Delete' links -->  
        </table>
                                      </div>
                              </div>
</div>
        </body>
</html>
