<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Cart</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" />
<style type="text/css">
.cart-form {
	padding-left: 115px;
	/* 	background-color: #EEEFF1; */
	margin-right: auto;
	margin-left: auto;
	margin-top: 50px;
	margin-bottom: 50px;
	padding: 20px;
}

.cart {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

.container {
	position: relative;
	max-width: 1280px;
	margin-left: auto;
	margin-right: auto;
	padding: 0px 60px;
	text-align: center;
}

.item-infor {
	float: left;
	width: 50%;
}

.left {
	float: left;
	position: relative;
	max-width: 1280px;
	margin-left: auto;
	margin-right: auto;
	padding: 0px 60px;
	position: relative;
}

.right {
	display: flex;
}

.btn1 {
	font-size: 14px;
	border: none;
	width: 60px;
	background: #18A8F1;
	margin-top: 10px;
	margin-bottom: 15px;
	color: white;
	cursor: pointer;
	box-shadow: .8rem .5rem 1.4rem #BEC5D0, -.3rem -.4rem .8rem #FBFBFB;
}

.btn1: active {
	box-shadow: inset -.3rem -.1rem 1.4rem #FBFBFB, inset .3rem .4rem .8rem
		#BEC5D0;
	cursor: pointer;
}
</style>


<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
		function delCart(cartNum) {
			var postUri = '${pageContext.request.contextPath}/cartDel'; 
			$('#cartNum').val(cartNum); 
			$('#cartDel').attr('action', postUri); 
			$('#cartDel').attr('method', 'post');
			$('#cartDel').submit();
		}
		
		window.onload = function(){
			var index = $("#select_box${goods.cartNum} option").index($("#select_box${goods.cartNum} option:selected"));
			  
			}
		
		
	
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
				<li><a
					href="${pageContext.request.contextPath}/goodscart?goodsName=">Cart</a></li>
				<li><a href="login">Login</a></li>
			</ul>
		</div>

	</div>
</header>




<body>

	<div class="cart">
		<h1>カート</h1>

	</div>
	<div class="container">
		<div class="cart-form" method="POST">
			<!-- <form action="/쇼핑몰/home.html">
			<input type="text" name="email" class="text-field" placeholder="ID">
			<input type="password" name="password" class="text-field"
				placeholder="パスワード"> <input type="submit" value="ログイン"
				class="submit-btn">
		</form> -->
			<form id="cartDel">
				<input type="hidden" name="cartNum" id="cartNum">
			</form>

			<c:forEach var="goods" items="${cartList}">
				<div class="left">

					<a
						href="${pageContext.request.contextPath}/goodsInfor?itemsDetail=${goods.goodPhoto}">
						<img src="images/men/${goods.goodPhoto}" width="300px"
						height="300px">
					</a>

					<!-- 						<div class="container"> -->
					<p>${goods.goodsName}</p>
					<input type="hidden" id="${goods.cartNum}"
						value="${goods.cartCount}">
					<p>
						<span id="goodsPrice">${goods.goodsPrice}</span> <select
							id="select_box${goods.cartNum}" class="select_box"
							name="cartCount">
							<c:forEach var="i" begin="1" end="10">
								<option value="${i}">${i}</option>

							</c:forEach>
						</select> <input type="button" value="削除" class="btn1" name="del"
							onclick="delCart(${goods.cartNum})">
					</p>
					<form id="myForm" name="myForm">
						<input type="hidden" name="sample" id="sample" value="sample" />

					</form>

				</div>
			</c:forEach>
		</div>
	</div>


</body>

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


</html>