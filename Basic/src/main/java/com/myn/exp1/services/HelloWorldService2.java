package com.myn.exp1.services;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldService2 implements IHelloWorldService
{
   private String name = "Service2";

   public void setName(String name)
   {
      this.name = name;
   }

   public String sayHello()
   {
      return "Hello! " + name;
   }
}