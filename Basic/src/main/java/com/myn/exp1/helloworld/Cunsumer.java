package com.myn.exp1.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myn.exp1.services.IHelloWorldService;

public class Cunsumer
{

   @SuppressWarnings("resource")
   public static void main(String[] args)
   {

      // loading the definitions from the given XML file
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

      IHelloWorldService service = (IHelloWorldService) context.getBean("helloWorldService");
      String message = service.sayHello();
      System.out.println(message);

      // set a new name
      service.setName("Spring");
      message = service.sayHello();
      System.out.println(message);

   }
}