package class7;

import org.apache.ibatis.session.SqlSession;

import com.kk.dao.UserDao;
import com.kk.entity.User;

public class Test2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try (SqlSession session = MyBatisUtil.getSession()) {
			  UserDao mapper = session.getMapper(UserDao.class);
			  User user = mapper.findByUsername("CST001");
			  System.out.println(user.getPassword());
		}

	}

}
