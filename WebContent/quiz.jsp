<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.kk.dao.*, com.kk.entity.*, org.apache.ibatis.session.*" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="com.kk.entity.Question" %>
<%@ page import="com.kk.entity.Option" %>

<%
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    List<Question> questions = sqlSession.selectList("com.kk.dao.QuizDao.getAllQuestionsWithOptions");
    sqlSession.close();
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>心理测试</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-br from-pink-200 to-indigo-300 min-h-screen p-8">
    <form action="quizResult.jsp" method="post" class="bg-white p-6 rounded-xl max-w-2xl mx-auto shadow-lg">
        <h1 class="text-3xl font-bold text-center text-purple-700 mb-6">心理健康测试</h1>
       <%
    for (Question q : questions) {
%>

    <div class="mb-6">
        <p class="font-semibold text-gray-800 mb-2"><%= q.getId() %>. <%= q.getQuestion() %></p>
        <%
            List<Option> opts = q.getOptions();
            if (opts != null) {
                for (Option o : opts) {
        %>
            <label class="block">
                <input type="radio" name="q<%= q.getId() %>" value="<%= o.getScore() %>" required>
                <%= o.getOptionText() %>
            </label>
        <%
                }
            } else {
        %>
            <p class="text-red-500 text-sm">选项加载失败，请联系管理员。</p>
        <%
            }
        %>
    </div>
<%
    }
%>

        <button type="submit" class="bg-purple-600 text-white px-6 py-2 rounded hover:bg-purple-700">提交</button>
    </form>
</body>
</html>
