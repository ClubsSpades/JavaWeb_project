<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>乘法口诀表</title>
<style>
	body {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    h3 {
        margin-bottom: 20px;
    }
    table {
        margin-bottom: 20px;
    }
</style>
</head>
<body>
<h3>欢迎您, ${sessionScope.user}</h3>
<br>
<table border='2'>
<%
for (int i = 1; i <= 9; i++) {
    out.println("<tr>");
    for (int j = 1; j <= i; j++) {
        out.println("<td>" + j + " × " + i + " = " + (i * j) + "</td>");
    }
    out.println("</tr>");
}
%>

</table>
<p><a href="login" style="text-decoration: underline;">退出</a></p>

</body>
</html>