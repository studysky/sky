<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Cart</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/basket.css"
	rel="stylesheet" />
<style type="text/css">
.infor {
	text-align: center;
	float: left;
	width: 50%;
}

.commnet {
	float: left;
	width: 30%;
	position: relative;
	text-align: right;
}
</style>


<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var errorMessage;
	errorMessage =  $("#errorMessage").val();
	
	if(errorMessage !='' && errorMessage != undefined){
		alert(errorMessage);
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
	</div>
</header>

<body>
	<div class="cart">
		<h1>Cart</h1>
		<form action="basket" name="sign" id="errorMessage">
			<!-- 	<span>ID</span> -->
			<p>
				<span class="login_it"> <input type="hidden"
					id="errorMessage" value="${errorMessage}">
				</span>
			</p>
		</form>
		<div class="infor">商品情報</div>
		<div class="commnet">合計情報</div>
	</div>
</body>


</html>