package class7;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static //��̬����飬�������ʱ��ִ��
	{
		try
		{
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession()
	{
		return sqlSessionFactory.openSession(true);
	}

}
