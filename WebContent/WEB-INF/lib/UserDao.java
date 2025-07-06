package class7;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

	User findByUsername(String username);
	User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	int addUser(User user);
	
	List<User> findAllUsers();
}
