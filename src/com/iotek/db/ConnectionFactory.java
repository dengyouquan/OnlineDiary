package com.iotek.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import com.iotek.entity.AuthorBean;

public class ConnectionFactory {
	private static final String dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=mydiary";
	private static final String dbUser="sa";
	private static final String dbPwd="511322";
	
	private static BasicDataSource dataSource;
	
	static{
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUser);
		dataSource.setPassword(dbPwd);
		dataSource.setInitialSize(10);
		dataSource.setMaxActive(10);
		//idle(空闲的)
		dataSource.setMaxIdle(3);
	}
	//synchronized 同步
	public static synchronized Connection createConnection(){
		Connection conn = null;
		try {
			if(conn==null || conn.isClosed()){
				conn = dataSource.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void main(String[] args) {
		String sql = "select * from d_t_author";
		Connection conn = createConnection();
		Statement state = null;
		ResultSet result = null;
		try {
			state = conn.createStatement();
			result = state.executeQuery(sql);
			int line=0;
			while(result.next()){
				line++;
				//从数据库中以两种不同的方式取得数据
				int authorid=result.getInt(1);  
		        String authorname=result.getString("authorname");   
		        System.out.println(authorid+" "+authorname+" ");  
		        //将检索结果在用户浏览器上输出  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
