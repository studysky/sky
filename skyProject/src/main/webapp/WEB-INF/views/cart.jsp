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
	float: left;
	width: 40%;
	/* 	background-color: #EEEFF1; */
	margin-right: auto;
	margin-left: auto;
	margin-top: 50px;
	margin-bottom: 50px;
	padding: 20px;
	float: left;
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
</style>


<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
	function del() {

		var postUri = '${pageContext.request.contextPath}/cartDel'; //url signupOk 으로 값을 받음
		$('#del').attr('action', postUri); //#signForm  form의id로 값 받아옴 
		$('#del').attr('method', 'post');
		$('#del').submit();
		// location.href = 'top';
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
	<div class="container">
		<div class="cart">
			<h1>カート</h1>

		</div>
		<div class="cart-form" method="POST">
			<!-- <form action="/쇼핑몰/home.html">
			<input type="text" name="email" class="text-field" placeholder="ID">
			<input type="password" name="password" class="text-field"
				placeholder="パスワード"> <input type="submit" value="ログイン"
				class="submit-btn">
		</form> -->
			<div class="left">


				<c:forEach var="goods" items="${cartList}" begin="1" end="10">
					<form action="cartDel" name="del" id="del">
						<img src="images/men/${goods.goodPhoto}" width="300px"
							height="300px">
						<!-- 						<div class="container"> -->
						<p>${goods.goodsName}</p>
						<p>${goods.goodsPrice}</p>
						<select id="select_box" class="select_box" name="cartCount">
							<c:forEach var="i" begin="1" end="10">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select> <input type="button" value="削除" class="btn" onclick="del()">
					</form>
				</c:forEach>

				<div>
					<div class="right"></div>
				</div>
				<%-- 			<div> <c:forEach var="goods" --%>
				<%-- 				items="${goodsList}"> --%>
				<!-- 				<div class="wrapper"> -->
				<!-- 					items -> Collection 객체, list 돌릴땐 foreach 추천 -->
				<!-- 										<div class="box1"> -->
				<!-- 					<a -->
				<%-- 						href="${pageContext.request.contextPath}/reji?itemsDetail=${goods.photo}"> --%>
				<!-- 					</a> -->
				<%-- 					<p>${goods.goodsPrice} </p> --%>
				<!-- 										</div> -->
				<!-- 				</div> -->
				<%-- 			</c:forEach></div> --%>

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