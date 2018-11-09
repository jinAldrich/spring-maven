package com.yujin.spring;

public class DAOFactory {

	public PersonDAO createPersonDAO() {
		System.out.println("使用工厂模式的createPersonDAO方法创建DAO");
		return new PersonDAOImpl();
	}
	
	public static PersonDAO createHibernatePersonDAO() {
		System.out.println("使用工厂模式的createHibernatePersonDAO方法创建DAO");
		return new PersonDAOHibernateImpl();
	}
}
