package com.yujin.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yujin.spring.aop.service.DeptService;

public class AopTest {

	@Test
	public void testBeforeAOP() {
		String[] location = {"aop-beans.xml"};
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(location);
		DeptService service = (DeptService)ctx.getBean("deptService");
		service.save();
		service.udpate();
		service.delete();
	}

}
