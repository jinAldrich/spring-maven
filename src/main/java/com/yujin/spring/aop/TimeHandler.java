package com.yujin.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class TimeHandler {

	public Object handlerTime(ProceedingJoinPoint pJoin) {
		System.out.println("-----handlerTime---");
		try {
			//开始计时
			StopWatch watch = new StopWatch(pJoin.getTarget().getClass().getName());
			watch.start(pJoin.getSignature().getName());
			Object obj = pJoin.proceed();
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
