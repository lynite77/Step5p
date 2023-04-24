package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		/*DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;*/
		DataSource ds = new DataSource();
		ds.setDriverClassName(OracleInfo.driver);
		ds.setUrl(OracleInfo.url);
		ds.setUsername(OracleInfo.username);
		ds.setPassword(OracleInfo.password);
		ds.setInitialSize(2);	// 커넥션 풀을 초기화할 때 생성할 초기 커넥션 개수
		ds.setMaxActive(10); 	// 커넥션 풀에서 가져올 수 있는 최대 커넥션 개수
		ds.setTestWhileIdle(true);	// 커넥션 풀에 유후 상태로 있는 동안에 검사할지 여부
		ds.setMinEvictableIdleTimeMillis(60000 * 3);	// 커넥션 풀에 유휴상태 유지할 최소 시간(밀리초) : 3분
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);	// 커넥션 풀의 유후 커넥션을 검사하는 주기(밀리초) : 10초
		return ds;
	}
}
