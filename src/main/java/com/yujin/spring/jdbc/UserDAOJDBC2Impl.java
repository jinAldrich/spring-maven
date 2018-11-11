package com.yujin.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDAOJDBC2Impl extends JdbcDaoSupport implements UserDAO{
	private JdbcTemplate template;
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected JdbcTemplate createJdbcTemplate(DataSource dataSource) {
		// TODO Auto-generated method stub
		return super.createJdbcTemplate(dataSource);
	}

	@Override
	protected void initTemplateConfig() {
		// TODO Auto-generated method stub
		super.initTemplateConfig();
	}

	@Override
	protected void checkDaoConfig() {
		// TODO Auto-generated method stub
		super.checkDaoConfig();
	}

	
}
