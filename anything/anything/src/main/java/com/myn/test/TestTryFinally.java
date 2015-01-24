package com.myn.test;


public class TestTryFinally
{

   private Boolean val = false;

   private Boolean isVal()
   {
      return val;
   }

   @SuppressWarnings("resource")
   public static void main(String[] args)
   {

      TestTryFinally c = new TestTryFinally();
      try
      {
         c.doAnything();
      }
      catch (Exception e)
      {
         System.out.println("cought in Main#");
      }
   }

   public void doAnything()
   {
      {
         try
         {
            throw new RuntimeException();
         }
         finally
         {

         }
      }
   }
}