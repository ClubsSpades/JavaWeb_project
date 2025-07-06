//package class7;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import com.kk.dao.UserDao;
//import com.kk.entity.User;
//
///**
// * Servlet implementation class LoginServlet
// */
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        
//        // 获取MyBatis SqlSessionFactory
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            UserDao mapper = session.getMapper(UserDao.class);
//            User user = mapper.findByUsername(username);
//            
//            if (user != null && user.getPassword().equals(password)) {
//                // 登录成功，存储用户信息并重定向
//                request.getSession().setAttribute("currentUser", user);
//                response.sendRedirect("welcome.jsp");
//            } else {
//                // 登录失败，返回错误信息
//                response.setContentType("text/html;charset=UTF-8");
//                PrintWriter out = response.getWriter();
//                out.println("<script>alert('用户名或密码错误！');window.location.href='index.html';</script>");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "系统错误");
//        }
//    }
//}