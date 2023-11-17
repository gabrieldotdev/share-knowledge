<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../../includes/head.jsp"/>
    <title>${title}</title>
</head>
<body>
<div class="flex items-center min-h-screen p-4 bg-gray-100 justify-center bg-zinc-100">
    <div class="max-w-3xl w-full">
        <%--        enctype="multipart/form-data"--%>
        <form action="/upload/save" method="post" enctype="multipart/form-data">
            <div class="space-y-12">
                <div class="border-b border-gray-900/10 pb-12">
                    <h2 class="text-base font-semibold leading-7 text-gray-900">Chia sẻ tài nguyên</h2>
                    <p class="mt-1 text-sm leading-6 text-gray-600">Hãy chung sức đưa kiến thức đến với cộng đồng, vì
                        một
                        thế giới học tập mở.</p>

                    <div class="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                        <div class="sm:col-span-4">
                            <label for="name" class="block text-sm font-medium leading-6 text-gray-900">Tiêu đề</label>
                            <div class="mt-2">
                                <input id="name" name="name" type="text" autocomplete="name"
                                       class="block w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                            </div>
                        </div>
                        <div class="col-span-full">
                            <label for="description" class="block text-sm font-medium leading-6 text-gray-900">Mô
                                tả</label>
                            <div class="mt-2">
                            <textarea id="description" name="description" rows="5"
                                      class="block w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"></textarea>
                            </div>
                            <p class="mt-3 text-sm leading-6 text-gray-600">Write a few sentences about yourself.</p>
                        </div>

                        <div class="col-span-full">
                            <label class="block text-sm font-medium leading-6 text-gray-900">Tải tài liệu lên</label>
                            <label for="file-upload"
                                   class="relative cursor-pointer">
                                <div class="mt-2 flex justify-center rounded-xl border border-dashed border-gray-900/25 px-6 py-8">
                                    <div class="text-center">
                                        <div class="mt-4 flex text-sm leading-6 text-gray-600">
                                            <span class="font-semibold text-indigo-600 hover:underline">Tải lên</span>
                                            <input id="file-upload" name="file" type="file" class="sr-only" accept=".doc,.docx,.xml,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document, application/pdf">
                                            <p class="pl-1">or drag and drop</p>
                                        </div>
                                        <p class="text-xs leading-5 text-gray-600">PNG, JPG, GIF up to 10MB</p>
                                    </div>
                                </div>
                            </label>
                            <p id="file-name" class="mt-3 text-sm font-semibold leading-6 text-gray-600">${fileName}</p>
                        </div>
                        <div class="sm:col-span-2">
                            <label for="file-type" class="block text-sm font-medium leading-6 text-gray-900">Loại tài
                                liệu</label>
                            <div class="mt-2">
                                <input id="file-type" name="fileType" type="text" autocomplete="fileType" readonly="true"
                                       class="block w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6" />
                            </div>
                        </div>

                        <script>
                            const fileInput = document.getElementById('file-upload');
                            const fileType = document.getElementById('file-type');
                            const fileName = document.getElementById('file-name');
                            const allowedFileExtensions = ['.docx', '.docs', '.pdf'];

                            fileInput.addEventListener('change', (e) => {
                                const file = e.target.files[0];
                                const fileExtension = file.name.substring(file.name.lastIndexOf('.'));
                                if (allowedFileExtensions.includes(fileExtension)) {
                                    fileType.value = fileExtension;
                                    fileName.innerText = file.name;
                                } else {
                                    alert('File không hợp lệ');
                                }
                            });
                        </script>

                        <div class="sm:col-span-4">
                            <label for="userId" class="block text-sm font-medium leading-6 text-gray-900">Người dùng
                                đăng</label>
                            <div class="mt-2">
                                <input id="userId" name="userId" type="number" autocomplete="userId" value="${user.id}" readonly="true"
                                       class="hidden w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                            </div>
                            <div class="mt-2">
                                <input id="displayName" name="displayName" type="text" value="@${user.username}" readonly="true"
                                       class="block w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="mt-6 flex items-center justify-end gap-x-6">
                <a href="<c:url value="/" />" class="text-sm font-semibold leading-6 text-gray-900">Thoát</a>
                <button type="submit"
                        class="rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
                    Chia sẻ tài nguyên
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>