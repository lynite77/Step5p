package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;

public class OracleInfo {
	public static String driver = "oracle.jdbc.OracleDriver";
	public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String username = "HELLOUSER";
	public static String password = "HELLOUSER";
}

