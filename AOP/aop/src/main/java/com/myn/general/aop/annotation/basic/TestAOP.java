package com.myn.general.aop.annotation.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/myn/general/aop/annotation/basic/app.xml");
		EmployeeManager manager = context.getBean(EmployeeManager.class);

		manager.getEmployeeById(1);
		manager.createEmployee(new EmployeeDTO());
	}
}