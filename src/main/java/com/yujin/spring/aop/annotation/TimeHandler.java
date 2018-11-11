package com.yujin.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component("timeHandler")
public class TimeHandler {
	
	/**
	 * 切入点
	 */
	@Pointcut("bean(*Service)")
	public void myPointCut() {
		
	}
	
	/**
	 * 定置Around通知
	 * @param pJoin
	 * @return
	 */
	@Around("myPointCut()")
	public Object handlerTime(ProceedingJoinPoint pJoin) {
		System.out.println("-----handlerTime---");
		try {
			//开始计时
			StopWatch watch = new StopWatch(pJoin.getTarget().getClass().getName());
			watch.start(pJoin.getSignature().getName());
			Object obj = pJoin.proceed();
			Thread.sleep(2000);
			watch.stop();
			//停止计时
			System.out.println(watch.prettyPrint());
			return obj;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
