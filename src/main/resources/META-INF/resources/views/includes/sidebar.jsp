<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>

<aside class="flex flex-col flex-shrink-0 space-y-1 py-2">
    <c:if test="${not empty user && user.role.id == 1}" >
        <a href="/admin/dashboard" class="flex items-center space-x-3 bg-zinc-200 py-3 px-4 rounded-xl">
            <img src="../../static/icons/home.svg" alt="Admin" class="w-5 h-5">
            <p class="text-sm font-semibold">Quản trị</p>
        </a>
    </c:if>
    <a href="#" class="flex items-center space-x-3 hover:bg-zinc-200 py-3 px-4 rounded-xl">
        <img src="../../static/icons/home.svg" alt="Commercial" class="w-5 h-5">
        <p class="text-sm font-semibold">Trang chủ</p>
    </a>
    <a href="#" class="flex items-center space-x-3 hover:bg-zinc-200 py-3 px-4 rounded-xl">
        <img src="../../static/icons/home.svg" alt="Commercial" class="w-5 h-5">
        <p class="text-sm font-semibold">Trang chủ</p>
    </a>
</aside>
