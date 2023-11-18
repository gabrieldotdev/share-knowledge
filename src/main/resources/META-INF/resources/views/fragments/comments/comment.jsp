<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="comment" items="${comments}">
    <c:if test="${comment.document.id == document.id}">
        <div class="flex items-start justify-start gap-x-2 mt-4">
            <img class="inline-block h-7 w-7 rounded-full ring-2 ring-white mt-2"
                 src="https://images.unsplash.com/photo-1700076823924-a87fca414724?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyOXx8fGVufDB8fHx8fA%3D%3D"
                 alt="">
            <div class="group flex items-center gap-0.5">
                <div class="flex flex-col gap-y-1 px-3 py-1 rounded-xl bg-zinc-100">
                    <!--| USER |-->
                    <div class="flex flex-col -gap-y-0.5">
                        <span class="text-sm cursor-pointer font-semibold text-gray-700 hover:underline">${comment.user.lastName} ${comment.user.firstName}</span>
                        <p class="text-xs font-medium text-zinc-400">${comment.publishedOn}</p>
                    </div>
                    <!--| CONTENT |-->
                    <div class="flex flex-col gap-y-0.5">
                        <p class="text-sm font-medium text-gray-700">${comment.content}</p>
                    </div>
                </div>
                <c:if test="${comment.user.id == user.id}">
                    <div class="group-hover:flex hidden flex-col border-l border-zinc-200 pl-2 gap-y-1">
                        <button class="text-xs font-medium text-zinc-400 hover:underline">Chỉnh sửa</button>
                        <form action="/document/delete-comment/${comment.id}" method="post"
                              class="text-xs font-medium text-zinc-400">
                            <input type="hidden" name="documentId" value="${document.id}">
                            <button type="submit" class="hover:underline">Xoá</button>
                        </form>
                        <!-- Add this modal HTML structure at the end of your HTML body -->
                        <div id="editModal"
                             class="fixed inset-0 flex items-center justify-center backdrop-blur hidden">
                            <div class="bg-white p-8 w-96 rounded-xl drop-shadow-lg">
                                <span class="absolute top-2 right-2 text-gray-600 cursor-pointer text-lg"
                                      id="closeModal">&times;</span>
                                <!-- Your edit form or content goes here -->
                                <form action="/document/save-comment" method="post">
                                    <input type="hidden" name="commentId" value="${comment.id}">
                                    <input type="hidden" name="documentId" value="${document.id}">
                                    <input type="hidden" name="userId" value="${user.id}">
                                    <div class="border-b border-gray-900/10 pb-4">
                                        <div class="col-span-full">
                                            <label for="comment"
                                                   class="block text-sm font-medium leading-6 text-gray-900">Chỉnh sửa
                                                bình luận</label>
                                            <div class="mt-2">
                                                <input type="text" name="content" id="comment"
                                                       value="${comment.content}"
                                                       placeholder="Nhập bình luận của bạn"
                                                       autocomplete="off"
                                                       class="block w-full rounded-xl border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit"
                                            class="rounded-xl bg-sky-500 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-sky-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
                                        Lưu
                                    </button>
                                </form>
                            </div>
                        </div>
                        <script>
                            // Add this JavaScript to toggle the modal visibility
                            document.addEventListener('DOMContentLoaded', function () {
                                const editModal = document.getElementById('editModal');
                                const editButton = document.querySelector('.group-hover\\:flex .text-xs.font-medium.text-zinc-400');
                                const closeModalBtn = document.getElementById('closeModal');

                                editButton.addEventListener('click', function () {
                                    editModal.classList.remove('hidden');
                                });

                                // Close the modal when the close button is clicked
                                closeModalBtn.addEventListener('click', function () {
                                    editModal.classList.add('hidden');
                                });

                                // Close the modal when clicking outside of it
                                window.addEventListener('click', function (event) {
                                    if (event.target === editModal) {
                                        editModal.classList.add('hidden');
                                    }
                                });
                            });

                        </script>
                    </div>
                </c:if>
            </div>
        </div>
    </c:if>
</c:forEach>
