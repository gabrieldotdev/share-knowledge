<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../../includes/head.jsp"/>
    <title>${title}</title>
</head>
<body>
<h3 class="text-lg font-semibold text-sky-500">
    ${document.user.email}
</h3>


<h1>COMMENT LIST</h1>
<jsp:include page="../../fragments/comments/comment.jsp"/>
<jsp:include page="../../fragments/comments/reply.jsp"/>
</body>
</html>