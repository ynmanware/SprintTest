package com.myn.general.aop.after;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.myn.general.aop.after.MessageWriter.Person;

public class MessageAfterAdvice implements AfterReturningAdvice {
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		Person p = (Person) args[0];
		p.setName("from Returning.." + p.getClass());
		System.out.print("Hello " + p.getName());
	}
}