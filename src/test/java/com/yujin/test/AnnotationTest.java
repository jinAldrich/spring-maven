package com.yujin.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yujin.spring.annotation.PersonDAO;
import com.yujin.spring.annotation.PersonService;

public class AnnotationTest {

	@Test
	public void testPersonDao() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation-beans.xml");
		PersonDAO dao = (PersonDAO)ctx.getBean("personDAOImpl");/*注意：取类名并且类名第一个字母小写*/
		dao.save();
		
	}
	
	@Test
	public void testPersonService() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation-beans.xml");
		PersonService service = (PersonService)ctx.getBean("personServiceImpl");/*注意：取类名并且类名第一个字母小写*/
		service.regist();
	}
	
	/**
	 * 测试注解生命周期
	 */
	@Test
	public void testLifeCycle() {
		String[] locations = {"annotation-beans.xml"};     
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
		PersonService service1 = (PersonService)ctx.getBean("personServiceImpl");/*注意：取类名并且类名第一个字母小写*/
		PersonService service2 = (PersonService)ctx.getBean("personServiceImpl");
		System.out.println("验证Spring容器创建出的Bean对象是否是单例：" + (service1 == service2));
		service1.regist();
		ctx.close();
	}

}
