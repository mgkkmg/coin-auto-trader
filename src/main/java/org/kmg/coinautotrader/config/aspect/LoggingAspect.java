package org.kmg.coinautotrader.config.aspect;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

	private static final String TRACING_ID = "trace.id";

	@Pointcut("execution(* org.kmg.coinautotrader..*(..))")
	public void allAdvice() {
	}

	@Pointcut("execution(* org.kmg.coinautotrader.application.controller.*.*(..))")
	public void controllerAdvice() {
	}

	@Pointcut("execution(* org.kmg.coinautotrader.application.service.*.*(..))")
	public void serviceAdvice() {
	}

	@Before("controllerAdvice()")
	public void requestLogging(JoinPoint joinPoint) {
		MDC.put(TRACING_ID, UUID.randomUUID().toString());
	}

	@AfterReturning(pointcut = "controllerAdvice()", returning = "returnValue")
	public void requestLogging(JoinPoint joinPoint, Object returnValue) {
		MDC.clear();
	}

	@AfterThrowing(pointcut = "controllerAdvice()", throwing = "exception")
	public void requestLogging(JoinPoint joinPoint, Exception exception) {
		MDC.clear();
	}
}
