package com.yujin.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOJDBCImpl implements UserDAO {

	private JdbcTemplate template;
	
	public UserDAOJDBCImpl() {
		System.out.println("UserDAOJDBCImpl Constructor");
	}
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user(id,username,pwd) value(?,?,?)";
		template.update(sql, new Object[] {user.getId(), user.getUsername(), user.getPwd()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where id=?";
		template.update(sql,new Object[] {id});
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql = "update user set username=?,pwd=? where id=?";
		template.update(sql, new Object[] {user.getUsername(), user.getPwd(), user.getId()});
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id=?";
		User user = template.queryForObject(sql, new Object[] {id}, new UserMapper());
		return user;
	}

	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		List<User> list = template.query(sql, new UserMapper());
		return list;
	}

	public void setDataSource(DataSource source) {
		template = new JdbcTemplate(source);
	}
}
