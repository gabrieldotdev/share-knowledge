<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../../../includes/head.jsp"/>
    <title>${title}</title>
</head>
<body>
<p>FORM</p>
<%--<jsp:include page="../../../fragments/documentation/document_form.jsp" />--%>
<form action="#" method="post">
    <input type="text" name="name" required />
    <input type="text" name="description" required />
    <input type="text" name="file" required />
    <input type="text" name="fileType" required />
    <input type="number" name="countDownload" required />
    <input type="number" name="userId" required />
    <input type="submit" value="Submit" />
</form>
</body>
</html>