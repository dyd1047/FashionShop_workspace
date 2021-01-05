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
		input[type=text], input[type=password], select, textarea {
		  width: 100%;
		  padding: 12px;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
		  margin-top: 6px;
		  margin-bottom: 16px;
		  resize: vertical;
		}
		
		input[type=button] {
		  background-color: #4CAF50;
		  color: white;
		  padding: 12px 20px;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		}
		
		input[type=button]:hover {
		  background-color: #45a049;
		}
		
		.container {
		  border-radius: 5px;
		  padding: 20px;
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
		$(function(){
			//회원가입 처리
			$("input[type='button']").click(function(){
				regist();
			});
		});
		
		//요청이 완료되는 시점에 프로그래스바를 감춘다!!
		function regist(){
			//로딩바 시작
			$("#loader").addClass("loader"); //class 동적 적용
			document.getElementById("overlay").style.display = "block";
			
			//data의 키 값으로 form태그의 파라미터들을 전송할 수 있는 상태로 둬야 data 키 값에 form 자체를 넣을 수 있다.
			var formData = $("#member_form").serialize(); //전부 문자열화 시킨다!!
			
			$.ajax({
				url:"/shop/member/regist",
				type:"post",
				data:formData,
				success:function(responseData){
					//서버로부터 완료 응답을 받으면 로딩바 효과를 중단!!
					$("#loader").removeClass("loader"); //class 동적 제거
					document.getElementById("overlay").style.display = "none";
					var json = JSON.parse(responseData);
					if(json.result == 1){
						alert(json.msg);
						location.href="/"; //추후 로그인 페이지로 보낼예정
					}else{
						alert(json.msg);
					}
				}
			});
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
       	  
          <h3>SignUp</h3>
		  <form id="member_form">
			  <input type="text" name="user_id" placeholder="Your ID..">
			  <input type="text" name="name" placeholder="Your name..">
			  <input type="password" name="password" placeholder="Your password..">
			  <input type="text" name="email_id" placeholder="Your email ID..">
			  <select name="email_server">
				  <option value="gmail.com">gmail.com</option>
				  <option value="daum.net">daum.net</option>
				  <option value="naver.com">naver.com</option>
			  </select>
			  <input type="text" name="zipcode" placeholder="Your zipcode..">
			  <input type="text" name="addr" placeholder="Your address..">
			  <input type="button" value="SignUp">
		  </form>
		</div>

        <!-- ****** Footer Area Start ****** -->
        <%@ include file="../inc/footer.jsp" %>
        <!-- ****** Footer Area End ****** -->
    </div>
    <!-- /.wrapper end -->

</body>

</html>