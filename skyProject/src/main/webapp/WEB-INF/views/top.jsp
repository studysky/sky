<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Home</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/top.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var successMessage;
		successMessage = $("#successMessage").val();
		if (successMessage != '' && successMessage != undefined) {
			alert(successMessage);
		}
	});
</script>
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
					href="${pageContext.request.contextPath}/goodscart?cartCount=1&goodsName=">Cart</a></li>
				<li><a href="login">Login</a></li>
			</ul>
		</div>
		<form action="goodsSearch" class="aq" method="get">
			<div class="search">
				<input type="text" class="search" placeholder="キーワードで検索"
					name="search">
				<div class="search_img">
					<input type="image" src="images/other/search.jpg" width="30px"
						height="30px">
				</div>
			</div>
		</form>
	</div>
</header>

<body>
	<div class="container">
		<img class="page_header" src="images/other/main.jpg">

		<h1>
			Main Home<br> ${serverTime}
		</h1>

		<div class="main_area">
			<div class="main_nav">
				<ul class="icon_box">
					<li class="main_nav_icon1">
						<div>
							<h4>ランキング</h4>
							<h5>
								売れ筋の人気アイテム！<br>
							</h5>
							<a href="#">今週の人気商品</a>
						</div>
					</li>
					<li class="main_nav_icon2">
						<div>
							<h4>新着情報</h4>
							<h5>
								新しい商品を楽しめる！<br>
							</h5>
							<a href="#">今週の新着商品</a>
						</div>
					</li>
					<li class="main_nav_icon3">
						<div>
							<h4>お知らせ</h4>
							<h5>
								お買い物を更に安く！<br>
							</h5>
							<a href="#">今週のイベント</a>
						</div>


					</li>
				</ul>
			</div>
		</div>

	</div>

	<div class="clearfix">
		<input type="hidden" id="successMessage" value="${successMessage}">
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