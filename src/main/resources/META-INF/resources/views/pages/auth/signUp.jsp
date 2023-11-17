<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../../includes/head.jsp"/>
    <title>${title}</title>
</head>
<body>
<div class="flex items-center min-h-screen p-4 bg-gray-100 justify-center bg-zinc-100">
    <div class="bg-white rounded-2xl shadow-lg p-4 max-w-xl w-full space-y-2">
        <form action="/auth/save" method="post">
            <div class="space-y-12">
                <div class="border-b border-gray-900/10 pb-12">
                    <h2 class="text-lg font-semibold leading-7 text-gray-900">Tạo tài khoản</h2>
                    <p class="mt-1 text-sm leading-6 text-gray-600">We'll send you an email to verify your account, then
                        you're all set.</p>
                    <div class="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                        <div class="sm:col-span-3">
                            <label for="first-name" class="block text-sm font-medium leading-6 text-gray-900">First
                                name</label>
                            <div class="mt-2">
                                <input type="text" name="firstName" id="first-name" autocomplete="given-name"
                                       class="block w-full rounded-xl border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                            </div>
                        </div>

                        <div class="sm:col-span-3">
                            <label for="last-name" class="block text-sm font-medium leading-6 text-gray-900">Last
                                name</label>
                            <div class="mt-2">
                                <input type="text" name="lastName" id="last-name" autocomplete="family-name"
                                       class="block w-full rounded-xl border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                            </div>
                        </div>

                        <div class="sm:col-span-4">
                            <label for="email" class="block text-sm font-medium leading-6 text-gray-900">Email
                                address</label>
                            <div class="mt-2">
                                <input id="email" name="email" type="email" autocomplete="email"
                                       class="block w-full rounded-xl border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                            </div>
                        </div>

                        <div class="sm:col-span-2">
                            <label for="username"
                                   class="block text-sm font-medium leading-6 text-gray-900">Username</label>
                            <div class="mt-2">
                                <input id="username" name="username" type="text" autocomplete="username"
                                       class="block w-full rounded-xl border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                            </div>
                        </div>

                        <div class="col-span-full">
                            <label for="password" class="block text-sm font-medium leading-6 text-gray-900">Mật
                                khẩu</label>
                            <div class="mt-2">
                                <input type="password" name="password" id="password"
                                       autocomplete="password"
                                       class="block w-full rounded-xl border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                            </div>
                        </div>
                        <div class="col-span-full">
                            <label for="passwordComfirm" class="block text-sm font-medium leading-6 text-gray-900">Nhập
                                lại mật khẩu</label>
                            <div class="mt-2">
                                <input type="password" name="password" id="passwordComfirm"
                                       autocomplete="password"
                                       class="block w-full rounded-xl border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                            </div>
                        </div>
                        <script>
                            function checkPassword() {
                                let password = document.getElementById("password").value;
                                let passwordComfirm = document.getElementById("passwordComfirm").value;
                                if (password !== passwordComfirm) {
                                    document.getElementById("passwordComfirm").setCustomValidity("Mật khẩu không khớp");
                                } else {
                                    document.getElementById("passwordComfirm").setCustomValidity("");
                                }
                            }
                            document.getElementById("password").addEventListener("change", checkPassword);
                            document.getElementById("passwordComfirm").addEventListener("keyup", checkPassword);
                        </script>
                    </div>
                </div>
            </div>

            <div class="mt-6 flex items-center justify-between gap-x-6">

                <div class="flex items-center gap-x-4">
                    <p class="text-sm font-normal leading-6 text-gray-900">Đã có tài khoản?
                        <a href="/auth/signin" class="text-sm font-semibold leading-6 text-gray-900 hover:underline">Đăng
                            nhập</a>
                    </p>
                </div>

                <div class="flex items-center gap-x-6">
                    <a href="<c:url value="/"/>" class="text-sm font-semibold leading-6 text-gray-900">Thoát</a>
                    <button type="submit"
                            class="rounded-xl bg-sky-500 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-sky-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
                        Đăng ký tài khoản
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</body>
</html>