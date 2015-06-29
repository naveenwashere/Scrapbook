package com.prodcons;

//ProdCons2.java

class ProdCons2
{
   public static void main (String [] args)
   {
      Shared s = new Shared ();
      new Producer (s).start ();
      new Consumer (s).start ();
   }
}

class Shared
{
   private char c = '\u0000';
   private boolean writeable = true;

   synchronized void setSharedChar (char c)
   {
	   System.out.println("setChar Producer here to set " + c);
      while (!writeable)
         try
         {
        	 System.out.println("setChar Producer Waiting...");
            wait ();
         }
         catch (InterruptedException e) {}

      this.c = c;
      writeable = false;
      System.out.println("setChar Producer notifying to other thread...");
      notify ();
   }

   synchronized char getSharedChar ()
   {
	   System.out.println("getChar Consumer here to read " + c);
      while (writeable)
         try
         {
        	 System.out.println("getChar Consumer Waiting..."); 
            wait ();
         }
         catch (InterruptedException e) { }

      writeable = true;
      System.out.println("getChar Consumer notifying to other thread...");
      notify ();

      return c;
   }
}

class Producer extends Thread
{
   private Shared s;

   Producer (Shared s)
   {
      this.s = s;
   }

   public void run ()
   {
      for (char ch = 'A'; ch <= 'Z'; ch++)
      {
           try
           {
        	   System.out.println("Producer Sleeping...");
              Thread.sleep ((int) (Math.random () * 4000));
           }
           catch (InterruptedException e) {}

           s.setSharedChar (ch);
           System.out.println (ch + " produced by producer.");
      }
   }
}

class Consumer extends Thread
{
   private Shared s;

   Consumer (Shared s)
   {
      this.s = s;
   }

   public void run ()
   {
      char ch;

      do
      {
         try
         {
        	 System.out.println("Consumer Sleeping...");
            Thread.sleep ((int) (Math.random () * 4000));
         }
         catch (InterruptedException e) {}

         ch = s.getSharedChar ();
         System.out.println (ch + " consumed by consumer.");
      }
      while (ch != 'Z');
   }
}
