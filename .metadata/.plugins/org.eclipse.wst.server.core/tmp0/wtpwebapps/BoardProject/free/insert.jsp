<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>자유게시판 게시글 작성화면</h1>
	
	<div>
		<form action="/BoardProject/add.do" method="GET">
			<div>
				<input type="text" name="writer" placeholder="작성자">
			</div>
			<div>
				<input type="text" name="title" placeholder="제목">
			</div>
			<div>
				<textarea name="content" placeholder="내용"></textarea>
			</div>
			<div>
				<button>작성완료</button>
				<input type="reset" value="다시작성">
				<input type="button" id="btn_list" value="목록">
				<script>
					document.getElementById("btn_list").onclick = function (event) {
						location.href = '/BoardProject/list.do';
					  };
				</script>
			</div>
		</form>
	</div>
	
</body>
</html>