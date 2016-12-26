<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath }/loginresult">
		<label>아이디</label>
		<input id="id" name="id" type="text" value="">
		<br>
		
		<label>비밀번호</label>
		<input id="password" name="password" type="password" value="">
		<br>
		<c:if test="${'fail' == param.result }">
			<p>
				로그인이 실패 했습니다.
			</p>
		</c:if>
		<input type="submit" value="로그인">
	</form>
</body>
</html>