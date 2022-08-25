<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Login</title>

<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/signup.css"
	rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script language="javascript" type="text/javascript"> //나중에 jquery로 바꿀것 (이것도 공부)

$(document).ready(function(){
	var errorMessage;
	errorMessage =  $("#errorMessage").val();
	
	if(errorMessage !='' && errorMessage != undefined){
		alert(errorMessage);
	}
	});

 function signup(){   //onclick에서 받아올 값 함수
	 //var userId = document.querySelector('#userid'); //쿼리셀렉터룰 사용하면 값을 가지고 올 수 있다
	 
	 var userId = document.sign.userId;  /*form 에서 받아올 값 */  
	 var userPw = document.sign.userPw;
	 var userPw2 = document.sign.userPw2;
	 var userName = document.sign.userName 
	 
	 var useridStr = userId.value;
	 var userpwStr = userPw.value;
	 var userpw2Str = userPw2.value;
	 var userNameStr = userName.value; 
	 
	 var useridLen = useridStr.length;
	 var userpwLen = userpwStr.length;
	 var userpw2Len = userpw2Str.length;
	 var userNameLen = userNameStr.length;
	 
	 
	 var strEmail = email.value;
	 
	 if(useridStr ==''){
		 alert('ID欄は必須項目です。4～10文字を入力してください。');
		 return;
		 }else if(useridLen <=3 || useridLen >=13) {
			 alert('IDには4～10文字を入力してください。')
			 return;
		 }
	 if(userpwStr ==''){
		 alert('パスワード欄は必須項目です。8～16文字を入力してください。');
		 return;
		 }else if(userpwLen <= 7 || userpwLen >=17) {
			 alert('PWには8～16文字を入力してください。')
		 return;
		 }

	 if(userpw2Str ==''){
		 alert('パスワード確認欄は必須項目です。8～16文字を入力してください。');
		 return;
		 }else if(userpw2Len <= 7 || userpw2Len >=17) {
			 alert('パスワード確認には8～16文字を入力してください。')
		 return;
		 }else if(userpwStr != userpw2Str){
			 alert('パスワードが一致していません。')
		 return;
		 }
	 
	 if(userNameStr ==''){
		 alert('お名前欄は必須項目です。4～10文字を入力してください');
		 return;
		 }else if(userNameLen <= 3 || userNameLen >=11) {
			 alert('お名前は4～10文字を入力してください')
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
// 		  location.href = 'top';
 }}
</script>
</head>

<header>
	<div class="navbar">
		<div class="photo">
			<a class="logo" href="top"> <img src="images/footer_logo/SKY.png"
				height="80px">
			</a>
		</div>
	</div>
</header>


<body>
	<div id="login">
		<div id="login_form">
			<!-- 로그인 폼 -->

			<h3 class="login" style="letter-spacing: -1px;">会員登録</h3>
			<hr>
			<form action="signupOk" name="sign" id="signForm">
				<!-- 	<span>ID</span> -->
				<p>
					ID <span class="login_it">※ <input type="hidden"
						id="errorMessage" value="${errorMessage}">
					</span>
				</p>
				<input type="text" placeholder="IDを入力してください。" class="size"
					id="userId" name="userId">
				<p></p>
				<!-- 아이디 -->

				<!-- 	<label> <span>PW</span> -->
				<p>
					パスワード <span class="login_it">※</span>
				</p>
				<input type="password" placeholder="パスワードを入力してください。" class="size"
					id="userPw" name="userPw">
				<!-- 비밀번호 -->

				<label>
					<p>
						<!-- 공간확보용 -->
					</p> <input type="password" placeholder="パスワードをもう一度入力してください。"
					class="size" name="userPw2">
				</label>
				<!-- 비밀번호 확인


					<label> <span>PW</span> -->

				<p>
					お名前 <span class="login_it">※</span>
				</p>
				<input type="text" maxlength="10" placeholder="お名前を入力してください。"
					class="size" id="userNmae" name="userName">

				<p>
					性別 <span class="login_it">※</span>
				</p>
				<div class="select">

					<input type="radio" name="sex" value="1" id="male"> <label
						class="sex">男性</label> <input type="radio" name="sex" value="2"
						id="female"> <label class="sex">女性</label>
				</div>


				<p>
					E-mail <span class="login_it">※</span>
				</p>
				<input type="text" maxlength="50" placeholder="メールアドレスを入力してください。"
					class="size" id="email" name="email"> <br>
				<p>
					<input type="button" value="確認画面へ" class="btn" id="login.form"
						onclick="signup()">

				</p>
			</form>

			<hr>
			<p class="find">
				<span><a href="login">ログイン画面</a></span>
			</p>
		</div>
		<div></div>
</body>




</html>