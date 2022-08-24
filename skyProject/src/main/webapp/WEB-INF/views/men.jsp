<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Men</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/men.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script language="javascript" type="text/javascript">
	
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
				<li><a href="shop">Q&A</a></li>
				<li><a href="${pageContext.request.contextPath}/goodscart?goodsName=">Cart</a></li>
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
		<img class="page_header" src="images/other/men_main.jpg">
	</div>


	<h1>Men Category</h1>


	<div class="container">
		<a href="${pageContext.request.contextPath}/dispGoods?goodsItem=1">
			<img src="images/men/outer_m.jpg"> <!--controller 에 값 보내기  -->
			<p>OUTER</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=2">
			<img src="images/men/jacket_m.jpg">
			<p>JACKET</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=3">
			<img src="images/men/tops_m.jpg">
			<p>TOPS</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=4">
			<img src="images/men/cutsewn_m.jpg">
			<p>TSHUTS</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=5">
			<img src="images/men/knitvest.jpg">
			<p>KNIT</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=6">
			<img src="images/men/pants_m.jpg">
			<p>PANTS</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=7"> <img src="images/men/jeans_m.jpg">
			<p>JEANS</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=8"> <img src="images/men/room-wear_m.jpg">
			<p>ROOM WEAR</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=9"> <img src="images/men/under-wear_m.jpg">
			<p>UNDER WEAR</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=10"> <img src="images/men/shoes_m.jpg">
			<p>SHOES</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=11"> <img src="images/men/goods_m.jpg">
			<p>GOODS</p>
		</a> <a href="${pageContext.request.contextPath}/dispGoods?goodsItem=12"> <img src="images/men/gu_active_m.jpg">
			<p>ACTIVE</p>

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