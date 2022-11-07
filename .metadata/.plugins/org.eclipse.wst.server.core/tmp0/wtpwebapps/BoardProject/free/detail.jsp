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
	
	<h1>자유게시판 게시글 상세보기화면</h1>
	
	<div>
		<form method="GET" action="/BoardProject/modify.do">
			<div>
			<input type="hidden" name="freeNo" value="${free.freeNo}">
			게시글번호 ${free.freeNo}
			</div>
			<div>작성자 ${free.writer}</div>
			<div>작성IP ${free.ip}</div>
			<div>조회수 ${free.hit}</div>
			<div>제목 <input type="text" name="title" value="${free.title}"></div>
			<div><textarea name="content">${free.content}</textarea></div>
			<div>
				<button>수정</button>
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