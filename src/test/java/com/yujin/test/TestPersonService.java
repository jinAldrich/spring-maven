package com.yujin.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.yujin.spring.service.PersonService;

public class TestPersonService {

	@Test
	public void test() {
//		Resource res = new FileSystemResource("beans.xml");
//		BeanFactory ctx = new XmlBeanFactory(res);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PersonService service = (PersonService)ctx.getBean("personService");
		service.regist();
	}

	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation-beans.xml");
		PersonService service = (PersonService)ctx.getBean("personService");
		service.regist();
	}
}
