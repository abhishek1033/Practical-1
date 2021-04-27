package com.practical.reg.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.CacheOperationInvoker.ThrowableWrapper;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect 
{
	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution(* com.practical.reg.*.*.*(..))")
	public Object aroundLog(ProceedingJoinPoint j) throws Throwable
	{
		log.info(" " +j.getSignature().getDeclaringTypeName()+ " : " +j.getSignature().getName()+ " : START ");
		Object value = j.proceed();
		
		log.info(" " +j.getSignature().getDeclaringTypeName()+ " : "+j.getSignature().getName()+" : END ");
		return value;		
	}
	
	@AfterThrowing(pointcut = "execution(* com.practical.reg.*.*.*(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint j,  Throwable error)
	{
		log.error("    " + j.getSignature().getDeclaringTypeName() + "  :  " + j.getSignature().getName() + " :     Exception  : " + error.getMessage() + error);
	}
}
