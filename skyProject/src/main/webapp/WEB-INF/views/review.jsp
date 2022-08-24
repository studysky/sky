<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Review</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/review.css"
	rel="stylesheet" />


<style type="text/css">
.infor {
	text-align: center;
	float: left;
	width: 50%;
}

.commnet {
	float: left;
	width: 50%;
}

.red {
	color: red;
	font-size: 12px;
}

.star {
	padding: 30px;
}

.input1 {
	text-align: center;
	width: 300px;
	height: 32px;
	font-size: 15px;
	border: 0;
	border-radius: 6px;
	outline: none;
	padding-left: 10px;
	background-color: rgb(233, 233, 233);
}

.input2 {
	width: 480px;
	height: 240px;
	font-size: 15px;
	border: 0;
	border-radius: 6px;
	outline: none;
	padding-left: 10px;
	background-color: rgb(233, 233, 233);
}

.btn {
	font-size: 14px;
	border: none;
	padding: 10px;
	width: 260px;
	background: #18A8F1;
	border-radius: 16px;
	margin-top: 20px;
	margin-bottom: 30px;
	color: white;
}

.siro {
	width: 100%;
	height: 500px;
}

.iii {
	width: 400px;
	height: 400px;
}
</style>


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
				<li><a
					href="${pageContext.request.contextPath}/goodscart?goodsName=">Cart</a></li>
				<li><a href="login">Login</a></li>
			</ul>
		</div>

	</div>
</header>
<body>
	<div class="cart">
		<h1>レビュー</h1>

		<!-- <form action="/쇼핑몰/home.html">
			<input type="text" name="email" class="text-field" placeholder="ID">
			<input type="password" name="password" class="text-field"
				placeholder="パスワード"> <input type="submit" value="ログイン"
				class="submit-btn">
		</form> -->
		<div class="infor">
			<table>
				<%-- 				<c:forEach var="review" items="${reviewList}"> --%>

				<tr>
					<td><img class="iii" src="images/men/${reviewDto.photo}"></td>
				</tr>
				<tr>
					<td><div class="a">${reviewDto.goodsName}</div></td>
				</tr>
				<%-- 				</c:forEach> --%>
			</table>
		</div>


		<div class="commnet">
			コメント入力 <span class="red">※必須項目</span>
			<div class="star">評価</div>
			<div>
				<h2>タイトル</h2>
			</div>

			<!--reivew 機能はログインした人のみ  -->
			<form action="review">
				<input type="text" class="input1" id="tittle" name="tittle"
					value="${goodsName}" maxlength="20" placeholder="タイトルを入力してください。">
				<div>
					<h5 class="h5">コメント内容</h5>
				</div>

				<input type="text" class="input2" id="review" name="review"
					maxlength="50" placeholder="コメント内容を入力してください。">
				<button type="submit" class="btn">登録</button>
			</form>
		</div>

		<div class="siro">
			<div>
				コメント欄

				<c:forEach var="review" items="${reviewList}">

					<p>${review.userId}</p>
					<p>${review.tittle}</p>
					<p>${review.review}</p>
				</c:forEach>


			</div>
			<div>作っていく</div>


		</div>
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