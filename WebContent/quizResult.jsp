<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.kk.dao.*, org.apache.ibatis.session.*, org.apache.ibatis.io.Resources" %>
<%@ page import="java.io.InputStream" %>

<%
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    int totalScore = 0;
    for (String param : request.getParameterMap().keySet()) {
        totalScore += Integer.parseInt(request.getParameter(param));
    }

    Map<String, Object> map = new HashMap<>();
    map.put("score", totalScore);
    String result = sqlSession.selectOne("com.kk.dao.QuizDao.getResultByScore", map);
    sqlSession.close();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>测试结果</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex items-center justify-center min-h-screen bg-gradient-to-br from-green-200 to-blue-200">
    <div class="bg-white p-10 rounded-xl shadow-md text-center max-w-xl">
        <h2 class="text-2xl font-bold text-gray-800 mb-4">🧠 心理测试结果</h2>
        <p class="text-lg text-gray-700 mb-4">您的总得分为：<strong><%= totalScore %></strong></p>
        <p class="text-purple-700 text-xl font-semibold"><%= result %></p>
        <a href="welcome.jsp" class="mt-6 inline-block bg-blue-500 text-white px-6 py-2 rounded hover:bg-blue-600">返回主页</a>
    </div>
</body>
</html>
