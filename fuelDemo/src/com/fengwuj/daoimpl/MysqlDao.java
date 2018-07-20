package com.fengwuj.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.New;

import com.fengwuj.Dao.*;
import com.fengwuj.entity.User;
import com.fengwuj.util.DBConnection;
import com.mysql.cj.xdevapi.SqlDataResult;

public class MysqlDao implements Dao{
	String sql = null;
	Connection conn = null;
	DBConnection dbConnection = new DBConnection();
	boolean flag = false;
	
	@Override
	public boolean add(Object object) {
		flag = false;
		User user = (User) object;
		sql = "insert into user valuses (?,?)";
		try {
			
			conn = dbConnection.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			if (psmt.executeUpdate(sql) > 0) {
				flag =true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(String name) {
		flag = false;
		sql = "delete from user where username = ?";
		try {
			conn = dbConnection.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			if (psmt.executeUpdate(sql) > 0) {
				flag =true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean edit(Object object) {
		
		
		return false;
	}

	@Override
	public User select(String name) {
		User user = new User();
		sql = "select * from user where username = ?";
		try {
			conn = dbConnection.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> selectAll(String table) {
		
		return null;
	}

}
