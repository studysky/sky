<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Login</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet" />


<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script language="javascript" type="text/javascript">
	//나중에 jquery로 바꿀것 (이것도 공부)


	function signup(){   //onclick에서 받아올 값 함수
		 //var userId = document.querySelector('#userid'); //쿼리셀렉터룰 사용하면 값을 가지고 올 수 있다
		 
		 var userId = document.sign.userId;  /*form 에서 받아올 값 */  
		 var useridStr = userId.value;
		 var useridLen = useridStr.length;
		 
		 var userPw = document.sign.userPw;
		 var userPw2 = document.sign.userPw2;

		 var userpwStr = userPw.value;
		 var userpw2Str = userPw2.value;
		 
		 var userpwLen = userpwStr.length;
		 var userpw2Len = userpw2Str.length;
		 
		  var userName = document.sign.userName
		 var userNameStr = userName.value; 
		 
		 var strEmail = email.value;
		 
		 if(useridStr ==''){
			 alert('IDを入力してください');
			 return;
			 }else if(useridLen <=3 || useridLen >=13) {
				 alert('IDには4~10文字を入力してください')
				 return;
			 }
		 if(userpwStr ==''){
			 alert('PWを入力してください');
			 return;
			 }else if(userpwLen <= 7 || userpwLen >=17) {
				 alert('PWには8~16文字を入力してください')
			 return;
			 }

		 if(userpw2Str ==''){
			 alert('PW確認を入力してください');
			 return;
			 }else if(userpw2Len <= 7 || userpw2Len >=17) {
				 alert('PWには8~16文字を入力してください')
			 return;
			 }else if(userpwStr != userpw2Str){
				 alert('PWが一致していません。')
			 return;
			 }

		 var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		 if(regex.test(strEmail) === false) {
		 alert("間違ったメール形式です。");
		 return false;
		 } else {
				// 값 받아오기 (jquery)
			  var postUri = '${pageContext.request.contextPath}/signupOk';  //url signupOk 으로 값을 받음
			  $('#signForm').attr('action', postUri);   //#signForm  form의id로 값 받아옴 
			  $('#signForm').attr('method', 'post');
			  $('#signForm').submit();
//	 		  location.href = 'top';
	 }}
	
	$(document).ready(function() {
		var loginError;
		loginError = $("#loginError").val();

		if (loginError != '' && loginError != undefined) {
			alert(loginError);
		}
	});
	
</script>
<style type="text/css">
.submit-btn {
	font-size: 14px;
	border: none;
	padding: 10px;
	width: 260px;
	background: #18A8F1;
	border-radius: 16px;
	margin-top: 20px;
	margin-bottom: 30px;
	color: white;
	cursor: pointer;
	cursor: pointer;
	box-shadow: .8rem .5rem 1.4rem #BEC5D0, -.3rem -.4rem .8rem #FBFBFB;
}
</style>
</head>

<header>
	<div class="navbar">
		<div class="photo">  
			<a class="logo" href="top"> <img src="images/footer_logo/SKY.png"
				height="80px">
			</a>
<!-- loginError -->
		</div>
	</div>
</header>

<body>

	<div class="login-form">
		<form action="doLogin" method="POST">
			<input type="hidden" id="loginError" value="${loginError}"> <input
				type="text" name="userId" class="text-field" placeholder="ID">
			<input type="password" name="userPw" class="text-field"
				placeholder="パスワード"> <input type="submit" value="ログイン"
				class="submit-btn" onclick="signup()">
		</form>

		<div class="links">
			<a href="#">パスワード忘れた方</a>
		</div>
		<div class="links">
			<a href="signup">新規会員登録</a>
		</div>
	</div>

	<div class="footer">
		<a href="https://ko-kr.facebook.com/"><img
			src="images/footer_logo/facebook.jpg"></a> <a
			href="https://www.instagram.com/"><img
			src="images/footer_logo/instar.jpg"></a> <a
			href="https://twitter.com/?lang=jp"><img
			src="images/footer_logo/tw.jpg"></a>
	</div>
</body>

</html>