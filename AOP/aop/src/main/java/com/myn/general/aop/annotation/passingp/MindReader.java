package com.myn.general.aop.annotation.passingp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface MindReader {
	void interceptThoughtsBefore(JoinPoint joinPoint, String thoughts, Person person);

	void interceptThoughts(ProceedingJoinPoint joinPoint, String thoughts, Person person) throws Throwable;

	String getThoughts();
}
