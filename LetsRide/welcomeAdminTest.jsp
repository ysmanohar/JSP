 <!-- <%@page import="com.domain.User" %>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script>
   function getMoreFields() {
	  //alert('Clicked');
	  var d = document.getElementById("moreFields");
	  var newName1 = document.createElement("TH");
	  d.innerHTML="sdjbsdk";
  	</script>
	
	<script language="javascript">
var addid = 0;

function addInput(id){
    var docstyle = document.getElementById('addlist').style.display;
    if(docstyle == 'none')
        document.getElementById('addlist').style.display = '';

    addid++;
    
    //var text = "<br><br /><div id='additem_"+addid+"'><input type='text' size='100' value='' class='buckinput' name='items[]' style='padding:5px;' /> <a href='javascript:void(0);' onclick='addInput("+addid+")' id='addlink_"+addid+"'>add more</a></div><br>";
	var text = "<br><br /><div id='additem_"+addid+"'><input type='text' size='100' value='' class='buckinput' name='additem_"+addid+"' style='padding:5px;' />";

    document.getElementById('addlist').innerHTML += text;
}
</script>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

 
<title>Search</title>

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
               
      </style>
</head>
   
<body>  
<center><img src="letsride.png" align="middle" alt="Lets Ride" ><center>
<br>
<p>

    
    <h1 style="text-align:center";"font-size:200%";"font-family:Monotype Corsiva"><i> Share your travel details </i></h1>
  <div class="container-fluid">
   <div class="jumbotron">
      <form name="signup" action="/LetsRide/postiti" method="post" onsubmit="return validation();">  
        <fieldset style="width: 300px">  
            <legend>Please post your travel details</legend>  
            <table align="center">  
            <div class="form-group">
                <tr>  
                    <td>Source</td>  
                    <td><input type="text" name="source" required="required" /></td> 
                    <td><div id="addlist" class="alt1" style="padding:10px;">
    Add more pickup points
    <br /><br />
	<input type="button" onclick="addInput(addlist)" value="More Inputs">
</div></td>

                </tr>  
                </div>  
                 
 
        	
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Destination</td>  
                    <td><input type="text" name="destination" required="required" /></td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                  <tr>  
                    <td>Date</td>  
                    <td><input type=date step=7 name="day" required="required"> </td>  
                </tr> 
                </div>
                <tr><td><br></td></tr>
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
                </div>
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
                    <td><input type="text" name="price" required="required" /></td>  
                </tr> 
                </div>
           <tr><td><br></td></tr>
                <div class="form-group">
 
                <tr>  
                    <td>Distance</td>  
                    <td><input type="text" name="distance" required="required" /></td>  
                </tr>
                </div>
                <tr><td><br></td></tr>
                <div class="form-group">
                
                <tr>  
                    <td>Capacity</td>  
                    <td><input type="text" name="capacity" required="required" /></td>  
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
