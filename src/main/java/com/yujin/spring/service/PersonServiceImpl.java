package com.yujin.spring.service;

import com.yujin.spring.dao.PersonDAO;

public class PersonServiceImpl implements PersonService{
	private PersonDAO perDao;
	
	@Override
	public void regist() {
		// TODO Auto-generated method stub
		System.out.println("调用PersonService完成用户注册");
		perDao.save();
	}

	public void setPerDao(PersonDAO perDao) {
		this.perDao = perDao;
	}


}
