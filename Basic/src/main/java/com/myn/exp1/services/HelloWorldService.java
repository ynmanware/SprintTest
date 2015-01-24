package com.myn.exp1.services;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldService implements IHelloWorldService
{
   private String name = "Service 1";

   public void setName(String name)
   {
      this.name = name;
   }

   public String sayHello()
   {
      return "Hello! " + name;
   }
}