<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../includes/head.jsp"/>
    <title>${title}</title>
</head>
<body>
<div class="flex h-screen w-full flex-col">
    <div class="relative isolate flex h-screen w-full flex-col overflow-hidden">
        <div
                class="absolute inset-x-0 -top-40 -z-10 transform-gpu overflow-hidden blur-3xl sm:-top-80"
                aria-hidden="true"
        >
            <div class="relative left-[calc(50%-11rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 rotate-[30deg] bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-10 sm:left-[calc(50%-30rem)] sm:w-[72.1875rem]"></div>
        </div>
        <jsp:include flush="true" page="../includes/header.jsp"/>
        <div class="flex flex-1 overflow-hidden">
            <aside class="hidden flex-col justify-between overflow-y-auto px-4 py-2 lg:flex w-60 border-r border-gray-200">
                <jsp:include flush="true" page="../includes/sidebar.jsp"/>
                <jsp:include flush="false" page="../includes/footer.jsp"/>
            </aside>
            <main class="flex flex-1 overflow-y-auto px-10 md:px-12">
                <div id="content" class="w-full">
                    <jsp:include page="../includes/category.jsp"/>
                    <c:choose>
                        <c:when test="${not empty documents}">
                            <div class="columns-3xs gap-4 py-6">
                                <jsp:include page="../fragments/documentation/document.jsp"/>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="flex flex-col items-center justify-center h-[calc(100%-4rem)]">
                                <h3 class="text-xl font-semibold text-zinc-800">Không có dữ liệu để hiển thị</h3>
                                <a href="upload/uploadFile/new">
                                    Hãy chia sẻ kiến thức của bạn với cộng đồng: <span
                                        class="text-sky-500 font-medium hover:underline">Tải lên!</span>
                                </a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </main>
        </div>

        <div
                class="absolute inset-x-0 top-[calc(100%-13rem)] -z-10 transform-gpu overflow-hidden blur-3xl sm:top-[calc(100%-30rem)]"
                aria-hidden="true"
        >
            <div class="relative left-[calc(50%+3rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-10 sm:left-[calc(50%+36rem)] sm:w-[72.1875rem]"></div>
        </div>
    </div>
</div>
</body>
</html>