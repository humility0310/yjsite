<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>

<script type="text/javascript">
$(document).ready(function(){
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
            reader.onload = function (e) {
            	$("#blah").show();	
            //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
                $('#blah').attr('src', e.target.result);
                //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
                //(아래 코드에서 읽어들인 dataURL형식)
            }                   
            reader.readAsDataURL(input.files[0]);
            //File내용을 읽어 dataURL형식의 문자열로 저장
        }
    }//readURL()--

    //file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
    $("#imgInp").change(function(){
        //alert(this.value); //선택한 이미지 경로 표시
        readURL(this);
    });
 });
 
</script>

</head>
<body>
<form:form class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath }/modifyresult" enctype="multipart/form-data" modelAttribute="usersVo"> 
		<br><br>
					

		<label class="block-label" for="password">패스워드</label> 
		<!-- input id="password" name="password" type="password" value="" -->
		<form:input path="password" type="password"/>
			<p style="color:red">
				<form:errors path="password"/>
			</p>
		
		 <img id="blah" src="#" alt="" style="display: none; height: 200px;"/><br>
		<label class = "black-label" for="usersImage">프로필 사진 : </label>
		<input id="imgInp" name="usersImage1" type="file" value="upload">


		<br><br>
		
		<input type="submit" value="수정하기">

</form:form>
</body>
</html>