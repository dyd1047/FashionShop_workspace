<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Karl - Fashion Ecommerce Template | Home</title>

    <%@ include file="../inc/header.jsp" %>
	<style>
		* {
		  box-sizing: border-box;
		}
		
		/* style the container */
		.container {
		  position: relative;
		  border-radius: 5px;
		  padding: 20px 0 30px 0;
		} 
		
		/* style inputs and link buttons */
		input,
		.btn {
		  width: 100%;
		  padding: 12px;
		  border: none;
		  border-radius: 4px;
		  margin: 5px 0;
		  opacity: 0.85;
		  display: inline-block;
		  font-size: 17px;
		  line-height: 20px;
		  text-decoration: none; /* remove underline from anchors */
		}
		
		input:hover,
		.btn:hover {
		  opacity: 1;
		}
		
		/* add appropriate colors to fb, twitter and google buttons */
		.fb {
		  background-color: #3B5998;
		  color: white;
		}
		
		.twitter {
		  background-color: #55ACEE;
		  color: white;
		}
		
		.google {
		  background-color: #dd4b39;
		  color: white;
		}
		
		/* style the submit button */
		input[type=button] {
		  background-color: #4CAF50;
		  color: white;
		  cursor: pointer;
		}
		
		input[type=button]:hover {
		  background-color: #45a049;
		}
		
		/* Two-column layout */
		.col {
		  float: left;
		  width: 50%;
		  margin: auto;
		  padding: 0 50px;
		  margin-top: 6px;
		}
		
		/* Clear floats after the columns */
		.row:after {
		  content: "";
		  display: table;
		  clear: both;
		}
		
		/* vertical line */
		.vl {
		  position: absolute;
		  left: 50%;
		  transform: translate(-50%);
		  border: 2px solid #ddd;
		  height: 175px;
		}
		
		/* text inside the vertical line */
		.vl-innertext {
		  position: absolute;
		  top: 50%;
		  transform: translate(-50%, -50%);
		  background-color: #f1f1f1;
		  border: 1px solid #ccc;
		  border-radius: 50%;
		  padding: 8px 10px;
		}
		
		/* hide some text on medium and large screens */
		.hide-md-lg {
		  display: none;
		}
		
		/* bottom container */
		.bottom-container {
		  text-align: center;
		  background-color: #666;
		  border-radius: 0px 0px 4px 4px;
		}
		
		/* Responsive layout - when the screen is less than 650px wide, make the two columns stack on top of each other instead of next to each other */
		@media screen and (max-width: 650px) {
		  .col {
		    width: 100%;
		    margin-top: 0;
		  }
		  /* hide the vertical line */
		  .vl {
		    display: none;
		  }
		  /* show the hidden text on small screens */
		  .hide-md-lg {
		    display: block;
		    text-align: center;
		  }
		}
		
		.loader {
		  border: 16px solid #f3f3f3;
		  border-radius: 50%;
		  border-top: 16px solid red;
		  border-bottom: 16px solid black;
		  border-left: 16px solid black;
		  border-right: 16px solid black;
		  width: 120px;
		  height: 120px;
		  -webkit-animation: spin 2s linear infinite; /* Safari */
		  animation: spin 2s linear infinite;
		  position: absolute;
		  left: 50%;
		  top: 50%;
		  margin-left:-60px;
		  margin-top:-60px;
		}
		
		/* Safari */
		@-webkit-keyframes spin {
		  0% { -webkit-transform: rotate(0deg); }
		  100% { -webkit-transform: rotate(360deg); }
		}
		
		@keyframes spin {
		  0% { transform: rotate(0deg); }
		  100% { transform: rotate(360deg); }
		}
		
		#overlay {
		  position: fixed; /* Sit on top of the page content */
		  display: none; /* Hidden by default */
		  width: 100%; /* Full width (cover the whole page) */
		  height: 100%; /* Full height (cover the whole page) */
		  top: 0;
		  left: 0;
		  right: 0;
		  bottom: 0;
		  background-color: rgba(0,0,0,0.5); /* Black background with opacity */
		  z-index: 2; /* Specify a stack order in case you're using a different order for other elements */
		  cursor: pointer; /* Add a pointer on hover */
		}
	</style>
	<script type="text/javascript">
		function login(){
			$("#loginForm").attr({
				action:"/shop/member/login",
				method:"post"
			});
			$("#loginForm").submit();
		}
	</script>
</head>

<body>
    	<%@ include file="../inc/top.jsp" %>
        <!-- ****** Top Discount Area End ****** -->
        <div class="container">
        	<div id="overlay">
       	  		<div id="loader"></div>
       	  	</div>
       	  
			<form id="loginForm" style="margin:50px 50px;">
				<div class="row">
					<div class="vl">
						<span class="vl-innertext">or</span>
					</div>
					
					<div class="col">
						<a href="#" class="fb btn">
							<i class="fa fa-facebook fa-fw"></i> Login with Facebook
						</a>
						<a href="#" class="twitter btn">
							<i class="fa fa-twitter fa-fw"></i> Login with Twitter
						</a>
						<a href="#" class="google btn"><i class="fa fa-google fa-fw">
							</i> Login with Google+
						</a>
					</div>
					
					<div class="col">
						<div class="hide-md-lg">
							<p>Or sign in manually:</p>
						</div>
					
						<input type="text" name="user_id" placeholder="Username" required>
						<input type="password" name="password" placeholder="Password" required>
						<input type="button" value="Login" onclick="login()">
					</div>
				    
				</div>
			</form>
		</div>

        <!-- ****** Footer Area Start ****** -->
        <%@ include file="../inc/footer.jsp" %>
        <!-- ****** Footer Area End ****** -->
    </div>
    <!-- /.wrapper end -->

</body>

</html>