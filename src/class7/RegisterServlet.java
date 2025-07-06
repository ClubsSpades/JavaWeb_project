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
// * Servlet implementation class RegisterServlet
// */
//@WebServlet("/register")
//public class RegisterServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public RegisterServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String username = request.getParameter("username"); 
//		String password = request.getParameter("password"); 
//		String name = request.getParameter("name");
//	    // 获取MyBatis SqlSessionFactory
//	    String resource = "mybatis-config.xml";
//	    InputStream inputStream = Resources.getResourceAsStream(resource);
//	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//	    
//	    try (SqlSession session = sqlSessionFactory.openSession(true)) {
//	        UserDao mapper = session.getMapper(UserDao.class);
//	        User existingUser = mapper.findByUsername(username);
//	        
//	        if (existingUser != null) {
//	            // 用户名已存在
//	            response.setContentType("text/html;charset=UTF-8");
//	            PrintWriter out = response.getWriter();
//	            out.println("<script>alert('用户名已存在！');window.location.href='register.html';</script>");
//	        } else {
//	            // 创建新用户
//	            User newUser = new User(username, password, name);
//	            mapper.addUser(newUser);
//	            // 注册成功，重定向到登录页面
//	            response.setContentType("text/html;charset=UTF-8");
//	            PrintWriter out = response.getWriter();
//	            out.println("<script>alert('注册成功！请登录');window.location.href='index.html';</script>");
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace(); // 控制台看具体报错
//	        response.setContentType("text/html;charset=UTF-8");
//	        PrintWriter out = response.getWriter();
//	        out.println("<h3>注册失败，错误信息如下：</h3>");
//	        out.println("<pre>");
//	        e.printStackTrace(out);  // 输出到网页上
//	        out.println("</pre>");
//	    }
//
//	
//		
//	}
//
//}
