package com.myn.general.aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.myn.general.aop.before.MessageWriter.Person;

public class MessageBeforeAdvice implements MethodBeforeAdvice {
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.print("Hello ");
		Person p = (Person) args[0];
		p.setName("Sayuri");
	}
}