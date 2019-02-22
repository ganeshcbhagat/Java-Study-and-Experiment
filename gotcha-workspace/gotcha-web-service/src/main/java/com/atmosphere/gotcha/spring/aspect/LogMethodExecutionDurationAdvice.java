package com.atmosphere.gotcha.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogMethodExecutionDurationAdvice {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Around("com.atmosphere.gotcha.spring.aspect.MethodExecutionDurationJoinPoint.trackExecutionDuration()")
	public Object  around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object returnObj=null;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		LOG.info("Execution of method ["+proceedingJoinPoint.getSignature()+"] is started.");
		try {
			returnObj = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			LOG.error("Error caught in aspect while method execution",e);
			throw e;
		} finally {
			stopWatch.stop();
			LOG.info("Execution of method ["+proceedingJoinPoint.getSignature()+"] is finished in "+stopWatch.getTotalTimeMillis()+" ms");
		}
		return returnObj;
	}
}
