<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Login</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/review.css"
	rel="stylesheet" />
</head>


<header>
	<div class="navbar">
		<div class="photo">
			<a class="logo" href="top"> <img src="images/footer_logo/SKY.png"
				height="80px">
			</a>
		</div>
		<div id="top_menu">

			<li><a href="men">MEN</a></li>
			<li><a href="women">WOMEN</a></li>
			<li><a href="baby">BABY・KIDS</a></li>


		</div>

		<div id="top_menu2">
			<ul>
				<li><a href="qna">Q&A</a></li>
				<li><a href="${pageContext.request.contextPath}/goodscart?goodsName=">Cart</a></li>
				<li><a href="login">Login</a></li>
			</ul>
		</div>

	</div>
</header>
<div class="cart">
	<h1>review</h1>

	<c:forEach var="review" items="${ReviewList}">
		<!-- 		items -> Collection 객체, list 돌릴땐 foreach 추천 -->

		<img src="images/men/${review.photo}">
		<div class="container">
			<p>${review.goodsName}</p>
			<%-- 			<p>${review.userId}</p> --%>
		</div>
		<div class="boxxx">i am here</div>
	</c:forEach>

</div>



<body>

	<div class="login-form" method="POST">
		<!-- <form action="/쇼핑몰/home.html">
			<input type="text" name="email" class="text-field" placeholder="ID">
			<input type="password" name="password" class="text-field"
				placeholder="パスワード"> <input type="submit" value="ログイン"
				class="submit-btn">
		</form> -->



	</div>


	<!-- 	<div class="links">
			<a href="#">パスワード忘れた方</a>
		</div>
		<div class="links">
			<a href="#">新規会員登録</a>
		</div>
	</div>

	<div class="footer">
		<a href="https://ko-kr.facebook.com/"><img
			src="resources/images/footer_logo/facebook.jpg"></a> <a
			href="https://www.instagram.com/"><img
			src="resources/images/footer_logo/instar.jpg"></a> <a
			href="https://twitter.com/?lang=jp"><img
			src="resources/images/footer_logo/tw.jpg"></a>
	</div> -->
</body>

</html>