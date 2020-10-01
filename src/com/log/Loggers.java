package com.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.biz.CarStatus;

@Service
@Aspect
public class Loggers {
	private Logger work_log = Logger.getLogger("work");
	private Logger car_log = Logger.getLogger("car");
	
	// before
	@Before("execution(* com.biz.CarBiz.*(..))")
	public void logging3(JoinPoint jp) {	
		Object[] args = jp.getArgs();
		CarStatus cstatus = (CarStatus)args[0];		
		car_log.debug(cstatus.getId() + "," + cstatus.getDirection() + "," + cstatus.getSpeed() + "," + cstatus.getSpeeding());
	}
	
	@Before("execution(* com.*.*MainController.*(..))")
	public void logging2(JoinPoint jp) {
		work_log.debug(jp.getSignature().getName()+","+"ABC");		
	}
}