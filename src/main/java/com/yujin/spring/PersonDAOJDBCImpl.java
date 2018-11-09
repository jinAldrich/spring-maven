package com.yujin.spring;

public class PersonDAOJDBCImpl implements PersonDAO {

	public PersonDAOJDBCImpl() {
		System.out.println("PersonDAOJDBCImpl构造方法");
	}
	
	/**
	 * 通过配置指定其调用
	 */
	public void init() {
		System.out.println("PersonDAOJDBCImpl 初始化方法");
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("使用JDBC方式保存Person信息");

	}
	
	/**
	 * 通过配置指定其调用
	 */
	public void destroy() {
		System.out.println("PersonDAOJDBCImpl 销毁方法");
	}

}
