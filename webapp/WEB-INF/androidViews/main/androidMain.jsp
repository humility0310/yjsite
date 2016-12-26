<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
<!-- 
$(function(){
	$("button").click(function(){
		$.ajax({
			url : "{pageContext.request.contextPath }/test",
			type:"post",
			dataType: "json",
			data:"name=" + name + "&password=" + password,
			success: function( response ) {
				if( response.result != "success" ) {
					console.error( response.message );
					return;
				}
			},
			error: function( jqXHR, status, e ) {
				console.error( status + ":" + e );
			}
		});
	});
});
-->
$( function() {
    alert(  $( "#p1" ).text()  ); 
} );  

</script>
<title>Insert title here</title>
</head>
<body>
<p id="p1">안녕하세요.</p>
</body>
</html>