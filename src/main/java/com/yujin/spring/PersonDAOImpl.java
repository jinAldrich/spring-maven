package com.yujin.spring;

public class PersonDAOImpl implements PersonDAO{

	
	public PersonDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("PersonDAOImpl Constructor");
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("保存Person信息");
	}
	
	

}
