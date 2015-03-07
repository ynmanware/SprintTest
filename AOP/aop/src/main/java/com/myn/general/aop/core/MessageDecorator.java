package com.myn.general.aop.core;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.myn.general.aop.core.MessageWriter.Person;

public class MessageDecorator implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.print("Hello ");
		Person p = (Person) invocation.getArguments()[0];
		p.setName("Sayuri");
		Object retVal = invocation.proceed();
		System.out.println("!");
		return retVal;
	}
}