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
	float: left;
	margin-right: auto;
	margin-bottom: 50px;
	padding: 20px;
}

.cart {
	padding-left: 105px;
	margin-left: auto;
	margin-right: auto;
	margin-left: auto;
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
		#BEC5D0 cursor: pointer;
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

.list-table th {
	border-bottom: 1px solid #CCC;
}

.img {
	padding-top: 20px;
}

.table-box {
	float: left;
	width: 650px;
	height: 300px;
}

.cartsum {
	background-color: #f4f4f4;
	display: inline-block;
}

.sum {
	text-align: left;
	padding: 30px 15px;
}

.sum1 {
	text-align: right;
	padding-left: 15px;
}

.page {
	background: #fff;
}

.btn2 {
	font-size: 14px;
	border: none;
	width: 250px;
	background: #1b1b1b;;
	margin-top: 40px;
	margin-bottom: 20px;
	color: white;
	cursor: pointer;
	text-align: center;
	border-radius: 0;
	padding: 10px 20px;
}

.btn3 {
	font-size: 14px;
	border: none;
	width: 250px;
	background: #fff;
	margin-top: 20px;
	margin-bottom: 15px;
	color: #000;
	border: 1px solid #1b1b1b;;
	cursor: pointer;
	text-align: center;
	border-radius: 0;
	padding: 10px 20px;
}

.user{

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
				<li><a href="qna">Q&A</a></li>
				<li><a
					href="${pageContext.request.contextPath}/goodscart?cartCount=1&goodsName=">Cart</a></li>
				<li><a href="login">Login</a></li>
			</ul>
		</div>

	</div>
</header>

<body>

	<div class="cart">
		<h1>カート</h1>
		<p class="user">${userId}様 ようこそ</p>
	</div>
	<div class="container">
		<div class="cart-form" method="POST">
			<!-- <form action="/쇼핑몰/home.html">
			<input type="text" name="email" class="text-field" placeholder="ID">
			<input type="password" name="password" class="text-field"
				placeholder="パスワード"> <input type="submit" value="ログイン"
				class="submit-btn">
		</form> -->
			<div class="table-box">
			
				<c:forEach var="goods" items="${cartList}">
					<table class="list-table ">

						<div class="left">
							<input type="hidden" id="${goods.cartNum}"
								value="${goods.cartCount}">

							<form id="myForm" name="myForm">
								<input type="hidden" name="sample" id="sample" value="sample" />
							</form>
						</div>
						<thead>
							<tr>
								<th width="150"></th>
								<th width="150"></th>
								<th width="150"></th>
								<th width="150"></th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td width="200">
									<div>
										<div>
											<a
												href="${pageContext.request.contextPath}/goodsInfor?itemsDetail=${goods.goodPhoto}">
												<img class="img" src="images/men/${goods.goodPhoto}"
												width="150px" height="170px">
											</a>
										</div>
										<div>
											<input type="button" value="削除" class="btn1" name="del"
												onclick="delCart(${goods.cartNum})">

										</div>
									</div>
								</td>
								<td width="150"><span id="goodsPrice">${goods.goodsName}</span>
								</td>
								<td width="150">${goods.goodsPrice}</td>
								<td width="100"><select id="select_box${goods.cartNum}"
									class="select_box" name="cartCount">
										<c:forEach var="i" begin="1" end="10">
											<option value="${i}">${i}</option>

										</c:forEach>
								</select></td>
							</tr>
						</tbody>

					</table>
				</c:forEach>
			</div>

			<form id="cartDel">
				<input type="hidden" name="cartNum" id="cartNum">
			</form>

		</div>
		<div class="cartsum">
			<table class="sum">
				<tr>
					<th class="sum">注文内容</th>
					<th class="sum1">${cartSum.cartCount}件</th>
				</tr>
				<tr>
					<td class="sum">合計金額</td>
					<td class="sum1">\ ${cartPrice.cartCount}</td>
				</tr>
			</table>
			<div class="page">
				<input type="button" value="購入手続きへ" class="btn2" name="buy"
					onclick="location.href='http://localhost:8080/sky/shopclear'">
			</div>
			<div class="page">
				<input type="button" value="買い物を続ける" class="btn3" name="shopping"
					onclick="location.href='http://localhost:8080/sky/top'">
			</div>
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