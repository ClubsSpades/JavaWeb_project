package com.kk.controller;

import com.kk.entity.User;
import com.kk.exception.UserException;
import com.kk.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns = {"/login", "/register"})
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    @Override
    public void init() throws ServletException {
        try {
            // ��ʼ�� MyBatis
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            
            // �ֶ�ע�� UserService��Ҳ������ Spring ������˵��
            userService = new UserService(sqlSessionFactory);
        } catch (IOException e) {
            throw new ServletException("MyBatis ��ʼ��ʧ��", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath(); // /login or /register

        if ("/login".equals(servletPath)) {
            handleLogin(request, response);
        } else if ("/register".equals(servletPath)) {
            handleRegister(request, response);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.login(username, password);
            // ��¼�ɹ������� session
            request.getSession().setAttribute("currentUser", user);
            response.sendRedirect("welcome.jsp");
        } catch (UserException e) {
            sendAlert(response, e.getMessage(), "index.html");
        }
    }

    private void handleRegister(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        User newUser = new User(username, password, name);

        try {
            userService.register(newUser);
            sendAlert(response, "ע��ɹ������¼", "index.html");
        } catch (UserException e) {
            sendAlert(response, e.getMessage(), "register.html");
        }
    }

    private void sendAlert(HttpServletResponse response, String message, String redirectUrl)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("<script>alert('%s');window.location.href='%s';</script>", message, redirectUrl);
    }
}
