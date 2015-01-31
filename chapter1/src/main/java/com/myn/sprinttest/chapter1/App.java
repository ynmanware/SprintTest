package com.myn.sprinttest.chapter1;

import java.util.Locale;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myn.injection.TestUitlInjection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// loading the definitions from the given XML file
		System.out.println("getting context...");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// testI18n(context);
		testMapInjection(context);
	}

	public static void testMapInjection(ApplicationContext context) {
		TestUitlInjection d = (TestUitlInjection) context.getBean("testUitlInjection");

		for (Entry<String, String> entry : d.getConfigValues().entrySet()) {
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue());
		}
	}

	public static void testI18n(ApplicationContext context) {
		MessageSource d = (MessageSource) context.getBean("rest-common-messages");
		I18n(d, "reporting.title");
		I18n(d, "reporting.title.param1", "A");
		I18n(d, "reporting.title.param2", "A", "B");
	}

	public static void I18n(MessageSource d, String key, String... params) {
		System.out.println(d.getMessage(key, params, new Locale("en")));
	}
}
