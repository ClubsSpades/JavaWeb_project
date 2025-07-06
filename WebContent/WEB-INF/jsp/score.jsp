<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>测试结果</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-br from-green-200 to-teal-300 min-h-screen flex flex-col items-center justify-center p-6">

    <div class="bg-white p-8 rounded-2xl shadow-xl w-full max-w-md text-center mb-10">
        <h2 class="text-3xl font-bold text-gray-800 mb-4">🎉 测试完成！</h2>
        <p class="text-xl text-gray-700">你的得分是：<span class="text-green-600 font-semibold">${score}</span></p>
        <a href="welcome.jsp" class="inline-block mt-6 bg-blue-500 text-white px-4 py-2 rounded-full hover:bg-blue-600 transition duration-200">
            返回主页
        </a>
    </div>

    <div class="bg-white p-6 rounded-2xl shadow-md w-full max-w-4xl">
        <h3 class="text-xl font-semibold text-center text-gray-800 mb-4">📚 九九乘法表</h3>
        <table class="table-auto mx-auto text-sm text-center border-collapse">
            <tbody>
            <%
                for (int i = 1; i <= 9; i++) {
            %>
                <tr>
                    <%
                        for (int j = 1; j <= i; j++) {
                    %>
                        <td class="border px-3 py-2"><%= j %> × <%= i %> = <%= i * j %></td>
                    <%
                        }
                    %>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

</body>
</html>
