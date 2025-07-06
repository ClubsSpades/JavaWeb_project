<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>多功能小世界</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-br from-blue-400 to-purple-500 min-h-screen flex items-center justify-center">
    <%
    com.kk.entity.User user = (com.kk.entity.User)session.getAttribute("currentUser");
        if(user == null) {
            response.sendRedirect("index.html");
            return;
        }
    %>

    <div class="bg-white rounded-3xl shadow-xl p-10 max-w-xl w-full text-center">
        <h1 class="text-4xl font-bold text-gray-800 mb-4">🎉 欢迎来到--多功能小世界</h1>
        <h2 class="text-2xl text-purple-600 font-semibold mb-6">用户：<%= user.getUsername() %></h2>
        <p class="text-gray-600 mb-8">请选择一个功能开始使用：</p>

        <div class="grid grid-cols-2 gap-4 mb-6">
            <a href="test" class="bg-blue-500 text-white py-3 rounded-xl hover:bg-blue-600 transition">乘法答题</a>
            <a href="quiz.jsp" class="bg-green-500 text-white py-3 rounded-xl hover:bg-green-600 transition">心理测试</a>
            <a href="guess.jsp" class="bg-yellow-500 text-white py-3 rounded-xl hover:bg-yellow-600 transition">猜数字游戏</a>
            <a href="logout.jsp" class="bg-red-500 text-white py-3 rounded-xl hover:bg-red-600 transition">退出登录</a>
        </div>
    </div>
</body>
</html>
