package com.atmosphere.gotcha.spring.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class MethodExecutionDurationJoinPoint {

	@Pointcut("@annotation(com.atmosphere.gotcha.spring.aspect.TrackExecutionDuration)")
	public void trackExecutionDuration(){}
}
