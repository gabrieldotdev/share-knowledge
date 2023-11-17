<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="flex items-center justify-between p-4 ring-1 ring-gray-200/80 font-sans leading-normal tracking-normal">
    <%--| LEFT |--%>
    <div class="flex items-center sm:space-x-8 space-x-0">
        <%--| LOGO + MENU ICON |--%>
        <div class="flex items-center gap-x-2">
            <img src="../../static/icons/menu-vertical.svg" alt="" class="w-5 h-5 block lg:hidden">
            <h2 class="text-3xl items-center flex font-bold text-sky-500">添加学生信息</h2>
        </div>
        <%--| URL |--%>
        <div class="md:flex items-center hidden lg:gap-x-8 gap-x-4">
            <img src="../../static/icons/left-arrow.svg" alt="" class="w-3 h-3">
            <div class="flex items-center lg:gap-x-4 gap-x-2">
                <a href="<c:url value="/"/>" class="text-zinc-400 font-semibold">Knowledge</a>
                <img src="../../static/icons/next.svg" alt="" class="w-3 h-3">
                <a href="<c:url value="/"/>" class="text-zinc-600 font-semibold">Trang chủ</a>
            </div>
        </div>
    </div>
    <%--| RIGHT |--%>
    <div class="flex items-center">
        <%--| SEARCH + NAV |--%>
        <nav class="lg:flex items-center hidden pr-2 mr-2 border-r border-zinc-400">
            <ul class="flex items-center space-x-4">
                <li class="flex items-center gap-x-2">
                    <div class="relative">
                        <form class="w-64 hidden xl:block">
                            <label for="search"></label>
                            <input id="search" name="keyword" value="${param.keyword}" type="text"
                                   placeholder="Tìm kiếm..."
                                   autocomplete="off"
                                   onclick="toggleResults()"
                                   class="block w-full rounded-xl border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 outline-none sm:text-sm sm:leading-6">
                        </form>
                        <div id="searchResults"
                             class="absolute z-20 top-full left-0 mt-2 bg-white border rounded-xl shadow-lg p-4 hidden">
                            <div class="flex flex-col items-start justify-center gap-x-2">
                                <span class="text-gray-400">Kết quả:<c:if
                                        test="${not empty param.keyword}"> ${param.keyword}</c:if></span>
                                <c:if test="${not empty param.keyword}">
                                    <c:forEach var="item" items="${searchDocument}">
                                        <a href="#"
                                           class="flex flex-col items-start justify-center gap-x-2 bg-zinc-100 mt-2 py-1 px-3 rounded-xl">
                                            <span class="text-gray-900 font-semibold">${item.name}</span>
                                            <span class="text-gray-400 text-xs">${item.file}</span>
                                        </a>
                                    </c:forEach>
                                    <c:if test="${empty searchDocument}">
                                        <p class="text-gray-400">Không tìm thấy kết quả</p>
                                    </c:if>
                                </c:if>
                            </div>

                        </div>
                    </div>

                    <script>
                        function toggleResults() {
                            var resultsDiv = document.getElementById('searchResults');
                            resultsDiv.classList.toggle('hidden');
                        }
                    </script>
                    <a href="#">
                        <img src="../../static/icons/search.svg" alt="" class="w-4 h-4">
                    </a>
                <li>
                    <a href="#" class="text-zinc-600 font-semibold hover:text-sky-500 transition duration-300">Giới
                        thiệu</a>
                </li>
                <li>
                    <a href="/document"
                       class="text-zinc-600 font-semibold hover:text-sky-500 transition duration-300">Tài liệu</a>
                </li>
                <li>
                    <a href="#"
                       class="text-zinc-600 font-semibold hover:text-sky-500 transition duration-300">Bộ sưu tập</a>
                </li>
            </ul>
        </nav>
        <%--| USER + NOTIFICATION |--%>
        <div class="flex items-center gap-x-4">
            <img src="../../static/icons/commercial.svg" alt="" class="w-4 h-4">
            <a href="/upload/uploadFile/new" title="Upload">
                <img src="../../static/icons/upload.svg" alt="" class="w-4 h-4">
            </a>
            <div class="flex items-center gap-x-2">
                <p class="text-zinc-600 font-semibold">管理员</p>
                <img src="../../static/icons/prev.svg" alt="" class="w-3 h-3">
                <a href="/auth/signin" title="Sign In">
                    <img src="../../static/icons/person.svg" alt="" class="w-4 h-4">
                </a>
            </div>
        </div>
    </div>
</header>