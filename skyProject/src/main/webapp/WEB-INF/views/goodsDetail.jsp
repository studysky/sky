<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>GoodsDetail</title>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/goodsDetail.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script language="javascript" type="text/javascript">
	/* 	$(document).ready(function() {
	 $('#selectbox').on('change', function() {
	 (this.value);
	 });
	 }); */
	function itemOderBy(oderByVal) {
		var oderByVal = oderByVal;
		var goodsKind = $('#goodsKind').val();
		$
				.ajax({
					async : false,
					type : 'POST',
					dataType : 'json',
					data : {
						oderByVal : oderByVal,
						goodsKind : goodsKind
					},
					url : '${pageContext.request.contextPath}/itemOderby/', //controller で　itemOderby　を受け取る
					success : function(json) {
						// 				var itemList = JSON.parse(json);
						var itemList = json;
						var innerHtmlText = '';
						for ( var i in itemList) { //html 재구성해서 그 자리에 넣어줌
							innerHtmlText += '<a href="${pageContext.request.contextPath}/goodsInfor?itemsDetail='
									+ itemList[i].photo + '">';
							innerHtmlText += '<img src="images/men/'+itemList[i].photo+'"></a>';
							innerHtmlText += '<p> ' + itemList[i].goodsName
									+ '</p>';
							innerHtmlText += '<p>' + itemList[i].goodsPrice
									+ '</p>';
						}
						$('#itemDisp').html(innerHtmlText);
					},
					error : function(json) {
						alert('failed');
					}
				});
	}
</script>
</head>

<!-- ajax -> DB를 실제로 처리하기전에 화면에 처리한 것 처럼 보이게 하는 것 
$
.ajax({
async : false,
type : 'POST',
dataType : 'json',
data : {
aaa : aaa
},
url : '${pageContext.request.contextPath}/login/',
success : function(json) {
alert('成功')
},
error : function(json) {
alert('failed');
}
});-->

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


	<h1>${headerName}</h1>
<div class="btn-right">
	<button onclick="itemOderBy(1)">昇順</button>
	<button onclick="itemOderBy(2)">降順</button>
	</div>

	<div class="container">

		<span id="itemDisp"> <c:forEach var="goods"
				items="${goodsList}">
				<div class="wrapper">
					<!-- items -> Collection 객체, list 돌릴땐 foreach 추천 -->
					<!-- 					<div class="box1"> -->
					<a
						href="${pageContext.request.contextPath}/goodsInfor?itemsDetail=${goods.photo}">
						<img src="images/men/${goods.photo}">
					</a>
					<p>${goods.goodsName}</p>
					<p>${goods.goodsPrice}</p>
					<!-- 					</div> -->
				</div>
			</c:forEach>
		</span> <input type="hidden" id="goodsKind" value="${goodsKind}"></input>

	</div>

	<!-- 	<select id="selectbox"> --%> --%> --%> --%> --%>
			<option value="asc">昇順</option>
			<option value="desc">降順</option>
		</select> -->

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