<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	pageContext.setAttribute("newline", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.servletContext.contextPath}/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<div id="content">
			<div id="guestbook">
				<form action="${pageContext.servletContext.contextPath}/guestbook"
					method="post">
					<input type="hidden" name="a" value="add">
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="contents" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<c:set var='count' value="${fn:length(list) }" scope="page"/>
					<c:forEach items='${list }' var='vo' varStatus="index">
						<li>
							<table>
								<tr>
									<td>[${count - index.index }]
									</td>
									<td>${vo.name }</td>
									<td>${vo.regDate }</td>
									<td><a
										href="${pageContext.servletContext.contextPath}/guestbook?a=deleteform&no=${vo.no }">삭제</a></td>
								</tr>
								<tr>
									<td colspan=4>
									${fn:replace(vo.contents,newline,'<br>') }
									</td>
								</tr>
							</table> <br>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp">
			<c:param name="menu" value='guestbook'></c:param>
		</c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>