package com.myn.aspect_test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @Author Yogesh.Manware
 *
 */
@Aspect
@Component
public class AspectForDoBusiness {

	@AfterReturning(pointcut = "execution(* work(RequestData))", returning = "response")
	public void workAdvice(ResponseData response) {
		response.setF1Resp(response.getF1Resp() + " [Through After Returning] ");
	}

	/**
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Around("execution(* simpleWork())")
	public Object simpleWorkAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		Object obj = joinPoint.proceed();
		ResponseData response = (ResponseData) obj;
		response.setF1Resp(response.getF1Resp() + " [Through SimpleWorkAround After...] ");
		return obj;
	}

	/**
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Around("execution(* workForAround(..)) && " + "args(requestData)")
	public Object workAdvice2(ProceedingJoinPoint joinPoint, RequestData requestData) throws Throwable {
		requestData.setF1(requestData.getF1() + "[Through workForAround Before..]" );
		
		Object obj = joinPoint.proceed(new Object[]{requestData});
		ResponseData response = (ResponseData) obj;
		response.setF1Resp(response.getF1Resp() + " [Through workForAround After...] ");

		return obj;
	}
	
	/**
	 * @param joinPoint
	 * @throws Throwable
	 */
	@AfterThrowing(pointcut = "execution(* workWhichthrowsException(..))", throwing = "runtimeException")
	public void workAdviceExcAdvice(JoinPoint joinPoint, RuntimeException runtimeException) throws Throwable {
		System.out.println("Got you...");
		
	}
}
