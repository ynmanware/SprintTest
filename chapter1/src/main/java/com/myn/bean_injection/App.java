package com.myn.bean_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yogesh.Manware
 * 
 *         Usage of @Named
 * 
 *         This is not at all dependent on XML except enabling Annotations
 */
public class App {
	public static void main(String[] args) {
		// loading the definitions from the given XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		testBeanInjection(context);
		testBeanInterfaceInjection(context);
		testBeanInterfaceInjection2(context);

	}

	public static void testBeanInjection(ApplicationContext context) {
		TestBeanInjection d = (TestBeanInjection) context.getBean("testBeanInjection");

		System.out.println(d.getA().identify());
		System.out.println(d.getB().identify());
	}

	public static void testBeanInterfaceInjection(ApplicationContext context) {
		TestBeanInterfaceInjection d = (TestBeanInterfaceInjection) context.getBean("testBeanInterfaceInjection");

		System.out.println(d.getI().identify());
	}

	public static void testBeanInterfaceInjection2(ApplicationContext context) {
		TestBeanInterfaceInjection d = (TestBeanInterfaceInjection) context.getBean("testBeanInterfaceInjection");

		System.out.println(d.getI().identify());
	}
}
