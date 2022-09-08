<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>GoodsInfor</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/goodInfor.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script language="javascript" type="text/javascript">
	$(document).ready(function() {
		var errorMessage;
		errorMessage = $("basketForm").val();

		if (errorMessage != '' && errorMessage != undefined) {
			alert(errorMessage);
		}
	});

	var postUri = '${pageContext.request.contextrPath}/basket';
	$('#basketForm').attr('action', postUri);
	$('#basketForm').attr('method', 'post');
	$('#basketForm').submit();
	// location.href = 'top';
</script>
<style type="text/css">
.btn {
	/*   font-size: 17px; */
	border: none;
	padding: 15px 50px;
	background: #18A8F1;
	border-radius: 16px;
	margin-top: 12px;
	margin-bottom: 30px;
	color: #fff;
	text-decoration: none;
	cursor: pointer;
}

.btn1 {
	/*   font-size: 17px; */
	display: inline;
	border: none;
	padding: 15px 50px;
	background: #000;
	border-radius: 16px;
	margin-top: 12px;
	margin-bottom: 30px;
	color: #fff;
	text-decoration: none;
	cursor: pointer;
}

.select_box {
	width: 80px;
	border: 1px solid;
	box-sizing: border-box;
	padding: 10px;
	font-family: 'Roboto';
	font-style: normal;
	font-weight: 400;
	font-size: 14px;
	line-height: 10px;
	font-family: 'Roboto';
}

.select_box:focus {
	border: 1px solid #18A8F1;
	box-sizing: border-box;
	border-radius: 10px;
	outline: #18A8F1;
}

.btn2 {
	display: inline;
	border: none;
	padding: 15px 50px;
	background: red;
	border-radius: 16px;
	margin-top: 12px;
	margin-bottom: 30px;
	color: #fff;
	text-decoration: none;
	cursor: pointer;
}
</style>

<script type="text/javascript">
	// function onSelect(){
	// var select_box = document.getElementById('select_box');
</script>
</head>

<body>
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

		<ul>
			<li><a href="qna">Q&A</a></li>
			<li><a
				href="${pageContext.request.contextPath}/goodscart?cartCount=1&goodsName=">Cart</a></li>
			<li><a href="login">Login</a></li>
		</ul>
	</div>
	<!-- 		<form action="#" class="aq" method="get"> -->
	<!-- 			<div class="search"> -->
	<!-- 				<input type="text" class="search" placeholder="キーワードで検索"> -->
	<!-- 				<div class="search_img"> -->
	<!-- 					<input type="image" src="images/other/search.jpg" width="30px" -->
	<!-- 						height="30px"> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</form> -->


	<h1></h1>
	<div class="container">
		<c:forEach var="goods" items="${goodsInfor}">
			<!-- items -> Collection 객체, list 돌릴땐 foreach 추천 -->

			<img src="images/men/${goods.photo}">
			<div class="container">
				<p>${goods.goodsName}</p>
				<p>${goods.goodsPrice}</p>
				<p>${goods.goodsContent}</p>
			</div>
		</c:forEach>




		<form action="goodscart" name="count">
			<div>
				<select id="select_box" class="select_box" name="cartCount">
					<c:forEach var="i" begin="1" end="10">
						<option value="${i}">${i}</option>

					</c:forEach>
				</select>
			</div>
			<!-- 			<input type="hidden" value="cartInfor" name="cartInfor"> -->
			<input type="hidden" value="${goodsName}" name="goodsName"
				id="goodsName"> <input type="submit" class="btn"
				value="add to cart">
		</form>

		<form action="reviewItem" id="reviewForm">
			<input type="hidden" value="${goodsName}" name="reviewItem">
			<input type="hidden" value="" name="reviewNum"> <input
				type="submit" class="btn1" value="add to review">
		</form>

		<form action="basket" id="basket">
			<input type="hidden" value="${goodsName}" name="basketItem">
			<input type="hidden" value="" name="basketNum"> <input
				type="submit" class="btn2" value="add to basket">
		</form>
	</div>

	<form action="basket" name="sign" id="basketForm">
		<!-- 	<span>ID</span> -->
		<p>
			<span class="login_it"> <input type="hidden" id="errorMessage"
				value="${errorMessage}">
			</span>
		</p>
	</form>

	<div class="clearfix"></div>
</body>
<footer>
	<div class="footer">
		<a href="https://ko-kr.facebook.com/"><img
			src="images/footer_logo/facebook.jpg"></a> <a
			href="https://www.instagram.com/"><img
			src="images/footer_logo/instar.jpg"></a> <a
			href="https://twitter.com/?lang=jp"><img
			src="images/footer_logo/tw.jpg"></a>
	</div>
</footer>
</html>