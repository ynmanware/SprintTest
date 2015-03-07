package com.myn.general.aop.annotation.passingp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myn/general/aop/annotation/passingp/app.xml");
		Thinker t = (Thinker) context.getBean("volunteer");

		Person person = new Person("Yogesh", 1);

		t.thinkOfSomething("Queen of Hearts", person);

		MindReader m = (MindReader) context.getBean("mAspect");
		System.out.println("Thoughts: " + m.getThoughts());

	}
}