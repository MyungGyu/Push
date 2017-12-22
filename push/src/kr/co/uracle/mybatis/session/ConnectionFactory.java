package kr.co.uracle.mybatis.session;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.uracle.push.util.PushConfiguration;

public class ConnectionFactory {

	private static SqlSessionFactory sqlSessionFactory;

	private ConnectionFactory() {
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	static {
		try {
			Reader reader = Resources.getResourceAsReader(PushConfiguration.get("mybatis.config.path"));

			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
