package top.greysun.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleUtils {	
	final private static String driver = "oracle.jdbc.OracleDriver";
	final private static String url = "jdbc:oracle:thin:@localhost:1521:";

	/**
	 * 数据库软件名
	 */
	final public static String NAME = "oracle";

	private static String dbname = "orcl";
	private static String user = "SCOTT";
	private static String password = "tiger";

	//静态代码块：仅加载这个类时执行一次
	static{
		//注册
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public OracleUtils(String dbname,String user,String password){
		OracleUtils.dbname = dbname;
		OracleUtils.user = user;
		OracleUtils.password = password;
	}

	public static Connection getConnection() {
		Connection conn = null;
		//连接
		try {
			conn = DriverManager.getConnection(url+dbname, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
