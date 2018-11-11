package com.yujin.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

public class MyAspect {

	@Before("myPointCut()")
	public void beforeMethod() {
		System.out.println("-------执行前置通知的处理--------");
	}
	
	@After("myPointCut()")
	public void afterMethod() {
		System.out.println("-------执行最终通知的处理--------");
	}
	
	/**
	 * 环绕通知
	 * @param pjoin 连接点
	 */
	@Around("myPointCut()")
	public Object aroundMethod(ProceedingJoinPoint pjoin) {
		try {	
			System.out.println("-------执行环绕通知前期的处理--------");
			Object obj = pjoin.proceed();//调用目标对象的业务方法
			System.out.println("-------执行环绕通知后期的处理--------");
			return obj;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@AfterReturning(pointcut="bean(*Service)", returning="retVal")
	public void afterReturnMethod(Object retVal) {
		System.out.println("-------执行后置通知后期的处理--------");
	}
	
	/**
	 * 
	 * @param ex
	 */
	@AfterThrowing(pointcut="bean(*Service)", throwing="ex")
	public void executeException(Exception ex) {
		System.out.println("-------异常处理--------" + ex.getStackTrace());
	}
}
