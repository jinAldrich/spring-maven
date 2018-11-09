package com.yujin.test;

import static org.junit.Assert.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.yujin.spring.PersonDAO;

public class Test {
	/**
	 * 创建容器对象，通过容器对象获取personDao对象
	 */
	@org.junit.Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");/*不一定非要叫applicationContext.xml，名称随便起*/
//		ApplicationContext ctx = new FileSystemXmlApplicationContext("");
		PersonDAO personDAO = (PersonDAO)ctx.getBean("personDAO"); /*获取bean实例*/
		personDAO.save();
	}
	
	/**
	 * 测试通过工厂模式创建对象
	 */
	@org.junit.Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonDAO personDAO = (PersonDAO)ctx.getBean("personDAO1"); /*获取bean实例*/
		personDAO.save();
	}
	/**
	 * 测试通过工厂模式的静态方法创建对象
	 */
	@org.junit.Test
	public void test3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonDAO personDAO = (PersonDAO)ctx.getBean("personDAO2"); /*获取bean实例*/
		personDAO.save();
	}
	
	/**
	 * 测试容器生命周期，容器是一个单例对象
	 * init-method="init" 
	 * destroy-method="destroy" 只对单例有效scope="singleton"，对scope="prototype"无效
	 */
	@org.junit.Test
	public void test4() {
		/**
		 * 容器中的对象随着容器的实例化一并创建出来
		 */
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.close();
	}
	
	/**
	 * 测试对象创建模式，默认为singleton模式
	 * scope="singleton" 单例模式
	 * scope="prototype" 原型模式 
	 */
	@org.junit.Test
	public void test5() {
		/**
		 * 容器中的对象随着容器的实例化一并创建出来
		 */
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonDAO personDAO1 = (PersonDAO)ctx.getBean("personDAO"); 
		PersonDAO personDAO2 = (PersonDAO)ctx.getBean("personDAO"); 
		System.out.println(personDAO1 == personDAO2); /*true，证明是单例对象，添加scope="prototype"配置后返回false*/
	}
}
