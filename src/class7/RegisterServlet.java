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
//	    // ��ȡMyBatis SqlSessionFactory
//	    String resource = "mybatis-config.xml";
//	    InputStream inputStream = Resources.getResourceAsStream(resource);
//	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//	    
//	    try (SqlSession session = sqlSessionFactory.openSession(true)) {
//	        UserDao mapper = session.getMapper(UserDao.class);
//	        User existingUser = mapper.findByUsername(username);
//	        
//	        if (existingUser != null) {
//	            // �û����Ѵ���
//	            response.setContentType("text/html;charset=UTF-8");
//	            PrintWriter out = response.getWriter();
//	            out.println("<script>alert('�û����Ѵ��ڣ�');window.location.href='register.html';</script>");
//	        } else {
//	            // �������û�
//	            User newUser = new User(username, password, name);
//	            mapper.addUser(newUser);
//	            // ע��ɹ����ض��򵽵�¼ҳ��
//	            response.setContentType("text/html;charset=UTF-8");
//	            PrintWriter out = response.getWriter();
//	            out.println("<script>alert('ע��ɹ������¼');window.location.href='index.html';</script>");
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace(); // ����̨�����屨��
//	        response.setContentType("text/html;charset=UTF-8");
//	        PrintWriter out = response.getWriter();
//	        out.println("<h3>ע��ʧ�ܣ�������Ϣ���£�</h3>");
//	        out.println("<pre>");
//	        e.printStackTrace(out);  // �������ҳ��
//	        out.println("</pre>");
//	    }
//
//	
//		
//	}
//
//}
