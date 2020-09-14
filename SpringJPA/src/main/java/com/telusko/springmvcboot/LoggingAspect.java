package com.telusko.springmvcboot;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//Cross cutting concerns

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.telusko.springmvcboot.RestController.getAliens())")
	public void logBefore() {
		LOGGER.info("getAliens method called from aspect");
	}
	
	@AfterReturning("execution(public * com.telusko.springmvcboot.RestController.getAliens())")
	public void logAfter() {
		LOGGER.info("#### getAliens method executed");
	}
	
	@AfterThrowing("execution(public * com.telusko.springmvcboot.RestController.getAliens())")
	public void logException() {
		LOGGER.info("ISSUE");
	}
}
