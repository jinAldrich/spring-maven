package com.yujin.di;

import com.yujin.spring.PersonDAO;

public class PersonActionImpl implements PersonAction {

	private PersonDAO personDao;
	
//	public PersonActionImpl(PersonDAO dao) {
//		this.personDao = dao;
//	}

	
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		System.out.println("调用PersonActionImpl的execute方法");
		personDao.save();
		return "success";
	}

	public PersonDAO getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDAO personDao) {
		this.personDao = personDao;
	}

}
