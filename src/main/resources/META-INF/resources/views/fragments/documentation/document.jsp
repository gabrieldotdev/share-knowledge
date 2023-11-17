<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${documents}" var="item">
    <figure v-for="image in images" class="py-2 [break-inside:avoid]">
        <div class="hover:bg-active/10 group relative flex flex-col gap-y-2 rounded-2xl bg-white/80 p-4 drop-shadow-[0_0px_15px_rgba(0,0,0,0.04)] transition duration-200">
            <!-- Name -->
            <p class="text-md font-bold text-gray-700 line-clamp-2">${item.name}</p>
            <!-- Description -->
            <p class="text-md font-medium text-gray-700 line-clamp-5 px-2">${item.description}</p>
            <!-- Edit/Delete -->
            <div class="flex gap-x-2">
                <span class="flex flex-shrink-0 cursor-pointer items-center bg-sky-500/40 py-1 px-2 rounded-2xl drop-shadow-xs">
                    <p class="text-xs font-semibold">${item.fileType}</p>
                </span>
                <a href="#" class="flex flex-shrink-0 items-center bg-red-500/40 hover:bg-red-500/70 py-1 px-2 rounded-2xl duration-300 transition-colors drop-shadow-xs">
                    <p class="text-xs font-semibold">Chỉnh sửa</p>
                </a>
                <a href="/delete/${item.id}" class="flex flex-shrink-0 items-center bg-green-500/40 hover:bg-green-500/70 py-1 px-2 rounded-2xl duration-300 transition-colors drop-shadow-xs">
                    <p class="text-xs font-semibold">Xoá</p>
                </a>
            </div>
            <!-- File -->
            <div class="relative">
                <a href="#" download=""
                   class="absolute right-0 top-0 bg-white rounded-full w-6 h-6 flex items-center justify-center drop-shadow-lg hover:bg-zinc-100">
                    <img src="../../static/icons/download.svg" class="w-3 h-3" alt="">
                </a>
                <div class="mt-2 cursor-pointer flex justify-start rounded-lg border border-dashed border-gray-900/25 px-2 py-3 line-clamp-2">
                        ${item.file}
                </div>
            </div>
            <!-- User -->
            <a href="#" class="flex items-center gap-x-2">
                <img class="inline-block h-7 w-7 rounded-full ring-2 ring-white"
                     src="https://images.unsplash.com/photo-1700076823924-a87fca414724?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyOXx8fGVufDB8fHx8fA%3D%3D"
                     alt="">
                <div class="flex flex-col gap-y-0.5">
                    <span class="text-sm cursor-pointer font-semibold text-gray-700 hover:underline">${item.user.lastName} ${item.user.firstName}</span>
                    <p class="text-xs font-medium text-zinc-400">${item.publishedOn}</p>
                </div>
            </a>
        </div>
    </figure>
</c:forEach>
