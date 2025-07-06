package class7;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kk.dao.UserDao;
import com.kk.entity.User;

public class Test {
    
    public static void main(String[] args)throws IOException{
    	String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			  UserDao mapper = session.getMapper(UserDao.class);
			  User user = mapper.findByUsername("CST001");
			  System.out.println(user.getPassword());
			  
			  user = mapper.findByUsernameAndPassword("CST004", "321");
			  System.out.println(user.getPassword());
			  
			  user = new User();
			  user.setId(4);
			  user.setUsername("CST004");
			  user.setPassword("321");
			  user.setName("weishezhi");
			  
			  //mapper.addUser(user);
			  
//			  List<User> list = mapper.findAllUsers();
//			  for(User u : list)
//			  {
//				  System.out.println(u);
//			  }
		}

    }
}