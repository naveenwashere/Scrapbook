package com.codesamples;

public class MainClass {
	
	public enum Season 
	{ 
		WINTER(10), SPRING(20), SUMMER(30), FALL(40);
		
		private int i;
		Season(int i)
		{
			this.i = i;
		}
		
		public int getI()
		{
			return this.i;
		}
		
	}
	
	class PrivConst
	{
		private PrivConst()
		{
			
		}
	}
	
	class EnumExt extends PrivConst
	{
		public EnumExt()
		{
			System.out.println("Object got created even when the parent class constructor is private!");
		}
		
	}

	public static void main(String[] args) 
	{
		EnumSample e = EnumSample.INSTANCE;
		e.paint();
		System.out.println(e.hashCode());
		System.out.println(EnumSample.INSTANCE.hashCode());
		for(Season s : Season.values())
		{
			System.out.println(s.ordinal() + " - " + s.getI());
		}
		EnumExt ex = new MainClass().new EnumExt();
	}

}
