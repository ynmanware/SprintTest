package com.myn.general.aop.before;

import org.springframework.aop.framework.ProxyFactory;

import com.myn.general.aop.before.MessageWriter.Person;

public class HelloWorldAOPExample {
	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();
		// create the proxy
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MessageBeforeAdvice());
		pf.setTarget(target);
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		// write the messages target.writeMessage();

		Person s1 = new Person();
		s1.setId("1");
		s1.setName("Yogesh");

		target.writeMessage(s1);
		System.out.println("");
		proxy.writeMessage(s1);
	}
}