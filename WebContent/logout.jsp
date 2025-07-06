<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 清除会话中的用户信息
    session.invalidate();
    // 3秒后跳转回首页
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>退出登录</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <meta http-equiv="refresh" content="3;URL=index.html">
</head>
<body class="bg-gradient-to-br from-red-400 to-pink-500 min-h-screen flex items-center justify-center">
    <div class="bg-white rounded-3xl shadow-xl p-10 max-w-md w-full text-center">
        <h1 class="text-3xl font-bold text-gray-800 mb-4">👋 您已成功退出登录</h1>
        <p class="text-gray-600 mb-6">感谢您的使用，我们期待您的再次访问！</p>
        <p class="text-sm text-gray-500">页面将在 <span class="font-semibold">3 秒</span> 后自动跳转到登录页面。</p>
        <a href="index.html" class="inline-block mt-6 bg-blue-500 text-white px-6 py-2 rounded-xl hover:bg-blue-600 transition">立即跳转</a>
    </div>
</body>
</html>
