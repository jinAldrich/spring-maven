package com.yujin.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yujin.di.PersonAction;

/**
 * DI(Dependency Inject)依赖注入
 * 依赖注入测试
 * @author yujin
 *
 */
public class DITest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonAction action = (PersonAction)ctx.getBean("personAction");
		action.execute();
	}

}
