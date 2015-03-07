package com.myn.general.aop.annotation.basic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeCRUDAspect {

	@Pointcut("execution(*  EmployeeManager.getEmployeeById(..))")
	public void perform() {
	}

	public String getThoughts() {
		return "Yogesh";
	}

	@Before("perform()")
	public void logBeforePointcut(JoinPoint joinPoint) {
		System.out.println("EmployeeCRUDAspect.logBeforePointcut() : " + joinPoint.getSignature().getName());
	}
	
	@Before("execution(* EmployeeManager.getEmployeeById(..))")
	public void logBeforeV1(JoinPoint joinPoint) {
		System.out.println("EmployeeCRUDAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* EmployeeManager.*(..))")
	public void logBeforeV2(JoinPoint joinPoint) {
		System.out.println("EmployeeCRUDAspect.logBeforeV2() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* EmployeeManager.getEmployeeById(..))")
	public void logAfterV1(JoinPoint joinPoint) {
		System.out.println("EmployeeCRUDAspect.logAfterV1() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* EmployeeManager.*(..))")
	public void logAfterV2(JoinPoint joinPoint) {
		System.out.println("EmployeeCRUDAspect.logAfterV2() : " + joinPoint.getSignature().getName());
	}

	@Around("execution(* EmployeeManager.*(..))")
	public void logAroundV1(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("EmployeeCRUDAspect.logAfterV1() before: " + joinPoint.getSignature().getName());
		joinPoint.proceed();
		System.out.println("EmployeeCRUDAspect.logAfterV1() after: " + joinPoint.getSignature().getName());
	}
}