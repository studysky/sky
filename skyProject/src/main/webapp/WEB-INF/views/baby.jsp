<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Baby</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/men.css"
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
				<li><a href="qna">Q&A</a></li>
				<li><a href="cart">Cart</a></li>
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
		<img class="page_header" src="images/other/baby_main.jpg">
	</div>
	<h1>Men Category</h1>
	<div class="container">
			<a href="#"> <img src="images/baby/tops_k.jpg">
			<p>Tops</p>
		</a> <a href="#"> <img src="images/baby/pants_k.jpg">
			<p>Pants</p>
		</a> <a href="#"> <img src="images/baby/skirt_k.jpg">
			<p>Skirt</p>
		</a> <a href="#"> <img src="images/baby/onepiece_k.jpg">
			<p>One piece</p>
		</a> <a href="#"> <img src="images/baby/room-wear_k.jpg">
			<p>Skirt</p>
		</a> <a href="#"> <img src="images/baby/under-wear_k.jpg">
			<p>Under wear</p>
		</a> <a href="#"> <img src="images/baby/innertops_k.jpg">
			<p>Inner Tops</p>
		</a> <a href="#"> <img src="images/baby/goods_k.jpg">
			<p>Swimsuit</p>
		</a> <a href="#"> <img src="images/baby/babynewborn_k.jpg">
			<p>NewBorn Baby</p>
		</a> <a href="#"> <img src="images/baby/babytoddler_k.jpg">
			<p>BabyToddler Tops</p>
		</a> <a href="#"> <img src="images/baby/taperedpants_k.jpg">
			<p>BabyToddler Pants</p>
		</a> <a href="#"> <img src="images/baby/gu_active_k.jpg">
			<p>Kids</p>
		</a>
		<div class="clearfix"></div>
	</div>


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