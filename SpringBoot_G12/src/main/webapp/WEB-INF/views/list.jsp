<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
<tr align="center"><td>번호</td><td>작성자</td><td>제목</td><td>수정</td><td>삭제</td></tr>
<c:forEach items="${list }" var="dto">
<tr><td align="center">${dto.id }</td><td align="center">${dto.writer }</td> 
<td><a href="view?id=${dto.id }">${dto.title }</a></td>
<td align="center"><a href="updateForm?id=${dto.id }">수정</a></td>
<td align="center"><a href="delete?id=${dto.id }">x</a></td>
</tr>
</c:forEach>
</table>
<p><a href="writeForm">글작성</a></p>
</body>
</html>