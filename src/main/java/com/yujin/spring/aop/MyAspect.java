package com.yujin.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	public void beforeMethod() {
		System.out.println("-------执行前置通知的处理--------");
	}
	
	public void afterMethod() {
		System.out.println("-------执行最终通知的处理--------");
	}
	
	/**
	 * 环绕通知
	 * @param pjoin 连接点
	 */
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
	
	public void afterReturnMethod() {
		System.out.println("-------执行后置通知后期的处理--------");
	}
}
