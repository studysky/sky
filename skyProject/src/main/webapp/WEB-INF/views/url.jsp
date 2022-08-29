<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<html>
<head>
<script type="text/javascript">
			$(document).ready(function() {
				url =  '${pageContext.request.contextPath}/signupOk'
				$.ajax({
					type : "POST",
					url : url,
					data : $("#myForm").serialize(),
					success : function(data) {
					},
					error : function(request, status, msg) {
					}
				});
	         	});
		</script>
</head>
<body oncontextmenu="return false" onselectstart="return false"
	ondragstart="return false"
	style="overflow-x: auto; overflow-y: auto; position: relative;">

</body>
</html>
