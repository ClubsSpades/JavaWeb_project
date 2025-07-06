<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>乘法测试 - 第${questionNumber}题</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-br from-yellow-200 to-yellow-400 min-h-screen flex items-center justify-center">

<div class="bg-white p-8 rounded-xl shadow-md w-full max-w-md">
    <h2 class="text-2xl font-bold text-center text-gray-800 mb-4">乘法测试 - 第 ${questionNumber} 题</h2>
    
    <p class="text-xl text-center mb-6 font-medium text-purple-700">${num1} × ${num2} = ?</p>

    <form action="${questionNumber == 4 ? 'score' : 'test'}" method="post" class="space-y-4">
        <!-- 隐藏字段 -->
        <input type="hidden" name="questionNumber" value="${questionNumber}">
        <input type="hidden" name="num1" value="${num1}">
        <input type="hidden" name="num2" value="${num2}">
        <input type="hidden" name="answers" value="${answers}">
        <input type="hidden" name="correctAnswers" value="${correctAnswers}">

        <input type="text" name="answer" required
               class="w-full px-4 py-2 border border-gray-300 rounded-xl focus:ring-2 focus:ring-yellow-500 focus:outline-none text-center text-lg" 
               placeholder="请输入你的答案">

        <div class="text-center mt-6">
            <%
                int questionNumber = (Integer) request.getAttribute("questionNumber");
                if (questionNumber < 4) {
            %>
                <button type="submit" name="action" value="下一题"
                        class="bg-blue-500 text-white px-6 py-2 rounded-full hover:bg-blue-600 transition duration-200">
                    下一题
                </button>
            <% 
                } else {
            %>
                <button type="submit" name="action" value="交卷"
                        class="bg-green-500 text-white px-6 py-2 rounded-full hover:bg-green-600 transition duration-200">
                    交卷
                </button>
            <% 
                }
            %>
        </div>
    </form>
</div>

</body>
</html>
