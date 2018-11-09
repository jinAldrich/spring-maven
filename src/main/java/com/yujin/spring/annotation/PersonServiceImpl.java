package com.yujin.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")	 /* scope="singleton" 单例模式  scope="prototype" 原型模式 */
public class PersonServiceImpl implements PersonService {
	
//	@Resource(type = PersonDAO.class) /*可以指定匹配规则：name = "tiger", PersonDAO.class */
	@Autowired /*按照类型进行注入，省去了写set和get方法*/
	private PersonDAO dao;
	
	public PersonServiceImpl() {
		System.out.println("PersonServiceImpl Constructor");
	}
	
//	@Bean(initMethod = "init")
    @PostConstruct /*等价于<bean/>元素中的init-method*/
	public void init() {
		System.out.println("初始化PersonServiceImpl");
	}
	
	@Override
	public void regist() {
		// TODO Auto-generated method stub
		dao.save();
		System.out.println("调用PersonService注册Person");
	}
	
//	@Bean(destroyMethod = "destroy")
	@PreDestroy  /*等价于<bean/>元素中的destroy-method*/
	public void destory() {
		System.out.println("销毁PersonServiceImpl");
	}

}
