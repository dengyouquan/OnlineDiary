package com.iotek.security;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iotek.db.ConnectionFactory;
import com.iotek.entity.AuthorBean;

public class AuthCheck {
	private AuthorBean author;
	public AuthorBean getAuthor() {
		return author;
	}
	public void setAuthor(AuthorBean author) {
		this.author = author;
	}
	public AuthorBean setUserFromRs(ResultSet rs){
		AuthorBean ac = new AuthorBean();
		try {
			ac.setAuthorid(rs.getInt(1));
			ac.setAnthorname(rs.getString(2));
			ac.setRoletype(rs.getString(3));
			ac.setLoginname(rs.getString(4));
			ac.setPasswords(rs.getString(5));
			ac.setEmail(rs.getString(6));
			ac.setRegistdate(rs.getDate(7));
			ac.setAuthorstatus(rs.getString(8));
			ac.setMemo(rs.getString(9));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ac;
	}
	public boolean addAuthorBean(AuthorBean ab){
		boolean result = false;
		String sql = "insert into d_t_author values(?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		ResultSet set = null;
		Connection conn = ConnectionFactory.createConnection();
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, ab.getAnthorname());
			statement.setString(2,ab.getRoletype());
			statement.setString(3,ab.getLoginname());
			statement.setString(4,ab.getPasswords());
			statement.setString(5,ab.getEmail());
			statement.setDate(6,(Date) ab.getRegistdate());
			statement.setString(7,ab.getAuthorstatus());
			statement.setString(8,ab.getMemo());
			//有错
			//statement.executeQuery();
			statement.execute();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean checkUser(String uname,String upwd){
		boolean result = false;
		//用户校验
		String sql = "select * from d_t_author where loginname=? and passwords=?";
		PreparedStatement state = null;
		ResultSet resultset = null;
		Connection conn = ConnectionFactory.createConnection();
		
		try {
			state = conn.prepareStatement(sql);
			state.setString(1, uname);
			state.setString(2, upwd);
			resultset = state.executeQuery();
			if(resultset.next()){
				setAuthor(setUserFromRs(resultset));
				result = true;
			}
			else{
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
