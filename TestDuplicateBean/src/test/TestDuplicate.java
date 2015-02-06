package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDuplicate
{
   public static void main(String[] args)
   {
      ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config1.xml", "config2.xml","config3.xml"});

      //((TestBean) context.getBean("testBean")).sayHello();
      
      ((Customer) context.getBean("customer")).testBean.sayHello();;
      
      
   }
}
