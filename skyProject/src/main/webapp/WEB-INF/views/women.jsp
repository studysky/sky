<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Women</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/women.css"
	rel="stylesheet" />
</head>


<header>
	<div class="navbar">
		<div class="photo">
			<a class="logo" href="top"> <img
				src="images/footer_logo/SKY.png" height="80px">
			</a>
		</div>
		<div id="top_menu">

			<li><a href="men">MEN</a></li>
			<li><a href="women">WOMEN</a></li>
			<li><a href="baby">BABY・KIDS</a></li>


		</div>

		<div id="top_menu2">
			<ul>
				<li><a href="shop">Q&A</a></li>
				<li><a href="${pageContext.request.contextPath}/goodscart?cartCount=1&goodsName="">Cart</a></li>
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



	<div class="page_header">
		<img class="page_header" src="images/other/women_main.jpg">
	</div>
	<h1>Women Category</h1>
	<div class="container">
		<a href="#"> <img src="images//women/outer.jpg">
			<p>Outer</p>
		</a> <a href="#"> <img src="images//women/tops.jpg">
			<p>Tops</p>
		</a> <a href="#"> <img src="images//women/cutsewn.jpg">
			<p>Tshuts</p>
		</a> <a href="#"> <img src="images//women/pants.jpg">
			<p>Pants</p>
		</a> <a href="#"> <img src="images//women/skirt.jpg">
			<p>Skirt</p>
		</a> <a href="#"> <img src="images//women/one-piece.jpg">
			<p>One piece</p>
		</a> <a href="#"> <img src="images//women/under-wear.jpg">
			<p>Under wear</p>
		</a> <a href="#"> <img src="images//women/room-wear.jpg">
			<p>Room wear</p>
		</a> <a href="#"> <img src="images//women/bag.jpg">
			<p>Bag</p>
		</a> <a href="#"> <img src="images//women/shoes.jpg">
			<p>Shoes</p>
		</a> <a href="#"> <img src="images//women/goods.jpg">
			<p>Goods</p>
		</a> <a href="#"> <img src="images//women/gu-active.jpg">
			<p>Active</p>
		</a>
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