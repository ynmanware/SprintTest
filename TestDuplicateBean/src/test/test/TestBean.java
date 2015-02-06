package test.test;

import org.springframework.stereotype.Component;

import test.ITestBean;

@Component
public class TestBean extends ITestBean
{
   public void sayHello() {
      System.out.println("BEAN 3!");
   }
}
