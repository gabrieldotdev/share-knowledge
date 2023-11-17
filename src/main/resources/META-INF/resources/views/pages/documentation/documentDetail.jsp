<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../../includes/head.jsp"/>
    <title>${title}</title>
</head>
<body>
<p>Trang Tài liệu Chi tiết</p>
<h1>COMMENT LIST</h1>
<jsp:include page="../../fragments/comments/comment.jsp" />
<jsp:include page="../../fragments/comments/reply.jsp" />
</body>
</html>