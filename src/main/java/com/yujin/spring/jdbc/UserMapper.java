package com.yujin.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
	
		int id = rs.getInt("id");
		String name = rs.getString("pwd");
		String pwd = rs.getString("username");
		User user  = new User(id, name, pwd);
		
		return user;
	}

}
