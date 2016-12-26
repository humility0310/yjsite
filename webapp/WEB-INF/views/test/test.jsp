<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function() {
	$("#11").click(
			function() {
				console.log("JSON받음");
				$.ajax({
					url : "${pageContext.request.contextPath }/test2",
					type : "POST",
					dataType : "json",
					success : function(response) {
						if (response.result != "success") {
							console.error(response.message);
							return;
						}
						alert("id = " + response.data.id + "\npassword = "
								+ response.data.password + "\nimage = "
								+ response.data.usersImage);
					},
					error : function(jqXHR, status, e) {
						alert(status + " : " + e);
					}
				});
			});
});
	
$(function() {
	$("#22").click(
			function() {
				console.log("JSON보냄");
				$.ajax({
					url : "${pageContext.request.contextPath }/test1",
					type : "POST",
					dataType : "json",
					result : "success",
					data : "id=" + "111" + 
						   "&password=" + "111" + 
						   "&usersImage=" + "111",
					success : function(response) {
						if (response.result != "success") {
							console.error(response.message);
							return;
						}
					},
					error : function(jqXHR, status, e) {
						alert(status + " : " + e);
					}
				});
			});
});
</script>
<title>Insert title here</title>
</head>
<body>
	<p></p>
	<button id="11">JSON받음 (id='11')</button>
	<button id="22">JSON보냄('111/111/111')</button>
</body>
</html>