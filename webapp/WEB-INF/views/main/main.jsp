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
	<c:choose>
		<c:when test="${empty authUser }">
			<li><a href="${pageContext.request.contextPath }/login">로그인</a></li>
			<li><a href="${pageContext.request.contextPath }/join">회원가입</a></li>
		</c:when>
		<c:otherwise>
			<li>
				<div class="result-images">
					<img src="${pageContext.request.contextPath }/gallery/assets/${authUser.usersImage }" style="width:200px"><br>
				</div>
			</li>
			<li><a href="${pageContext.request.contextPath }/logout">로그아웃</a></li>
			<li><a
				href="${pageContext.request.contextPath }/modifyform">정보 수정</a></li>
			<li>${authUser.id }님안녕하세요^^;</li>

		</c:otherwise>
	</c:choose>
</body>
</html>