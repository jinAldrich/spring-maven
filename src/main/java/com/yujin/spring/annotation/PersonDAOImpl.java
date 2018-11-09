package com.yujin.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	public PersonDAOImpl() {
		System.out.println("PersonDAOImpl Constructor");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("初始化PersonDAOImpl");
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("调用PersonDaoImpl保存Person信息");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("销毁PersonDAOImpl");
	}
	
}
