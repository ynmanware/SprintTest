package com.myn.aspect_test;

import java.util.List;

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

		//testAfterReturning(context);

		testAfterThrowing(context);
	}

	private static void testAfterReturning(ApplicationContext context) {
		DoBusiness f = (DoBusiness) context.getBean("doBusiness");

		RequestData rd = new RequestData();
		rd.setF1("Yogesh");
		rd.setF2(99L);

		ResponseData response = f.work(rd);
		System.out.println("Advice applied as: " + response.getF1Resp());

		response = f.simpleWork();
		System.out.println("Advice applied as: " + response.getF1Resp());

		response = f.workForAround(rd);
		System.out.println("Advice applied as: " + response.getF1Resp());
	}

	private static void testAfterThrowing(ApplicationContext context) {
		DoBusiness f = (DoBusiness) context.getBean("doBusiness");
		
		/*RequestData rd = new RequestData();
		rd.setF1("Yogesh");
		rd.setF2(99L);
		ResponseData red = f.workWhichthrowsException(rd);
		*/
		List<ResponseData> respon = f.workForLoop();
		for (ResponseData responseData : respon) {
			System.out.println("Advice applied as: " + responseData.getF1Resp());
		}
	}
}
