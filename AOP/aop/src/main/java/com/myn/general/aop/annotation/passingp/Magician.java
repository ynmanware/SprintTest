package com.myn.general.aop.annotation.passingp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Magician implements MindReader {
	private String thoughts;

	@Pointcut("execution(* thinkOfSomething(String, Person)) && args(thoughts, person)")
	public void thinking(String thoughts, Person person) {
	}

	@Before("thinking(thoughts, person)")
	public void interceptThoughtsBefore(JoinPoint joinPoint, String thoughts, Person person) {
		System.out.println("Interceptingvolunteer'sthoughts");
		this.thoughts = thoughts;

		// alternate way to get arguments is
		Object args[] = joinPoint.getArgs();
		System.out.println("alternate way to get param1: " + args[0]);
		System.out.println("alternate way to get param2: " + args[1]);

		person.setId(50);
	}

	@Around("thinking(thoughts, person)")
	public void interceptThoughts(ProceedingJoinPoint joinPoint, String thoughts, Person person) throws Throwable {
		System.out.println("Around: Interceptingvolunteer'sthoughts");
		this.thoughts = thoughts;

		// alternate way to get arguments is
		Object args[] = joinPoint.getArgs();
		System.out.println("Around: alternate way to get param1: " + args[0]);
		System.out.println("Around: alternate way to get param2: " + args[1]);

		person.setId(50);

		joinPoint.proceed();
		
		System.out.println("Around: person.id " + person.getId());
	}

	public String getThoughts() {
		return thoughts;
	}
}