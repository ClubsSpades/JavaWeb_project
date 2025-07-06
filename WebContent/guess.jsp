<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    com.kk.entity.User user = (com.kk.entity.User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("index.html");
        return;
    }

    Integer answer = (Integer) session.getAttribute("guessAnswer");
    if (answer == null) {
        answer = new Random().nextInt(100) + 1;
        session.setAttribute("guessAnswer", answer);
    }

    String message = "";
    String guessStr = request.getParameter("guess");

    if (guessStr != null) {
        try {
            int guess = Integer.parseInt(guessStr);
            if (guess > answer) {
                message = "太大了！再试试~";
            } else if (guess < answer) {
                message = "太小了！再试试~";
            } else {
                message = "🎉 恭喜你猜中了！我重新给你出一个数字~";
                session.setAttribute("guessAnswer", new Random().nextInt(100) + 1);
            }
        } catch (NumberFormatException e) {
            message = "请输入有效数字！";
        }
    }
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>猜数字游戏</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-yellow-100 min-h-screen flex items-center justify-center">
    <div class="bg-white p-10 rounded-3xl shadow-xl w-full max-w-md text-center">
        <h1 class="text-3xl font-bold mb-6 text-yellow-600">🎲 猜数字游戏</h1>
        <p class="mb-4 text-gray-600">我想了一个 1 到 100 之间的数字，你能猜中吗？</p>
        <form method="get">
            <input type="number" name="guess" placeholder="输入你的猜测"
                   class="border rounded-lg p-2 w-1/2 mb-4">
            <br>
            <button type="submit"
                    class="bg-yellow-500 text-white px-4 py-2 rounded-lg hover:bg-yellow-600 transition">
                提交
            </button>
        </form>
        <% if (!message.isEmpty()) { %>
            <p class="mt-4 text-lg text-gray-700"><%= message %></p>
        <% } %>
        <a href="welcome.jsp" class="block mt-6 text-blue-500 hover:underline">返回欢迎页</a>
    </div>
</body>
</html>
