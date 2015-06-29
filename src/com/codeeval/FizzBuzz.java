package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FizzBuzz {
	
	private final static int TEST_CASE_CONSTRAINT_LIMIT = 20;
	
	private final static int X_CONSTRAINT_MIN = 1;
	
	private final static int X_CONSTRAINT_MAX = 20;
	
	private final static int Y_CONSTRAINT_MIN = 1;
	
	private final static int Y_CONSTRAINT_MAX = 20;
	
	private final static int N_CONSTRAINT_MIN = 21;
	
	private final static int N_CONSTRAINT_MAX = 100;

	public void playGame(int x, int y, int limit)
	{
		if(!(x >= FizzBuzz.X_CONSTRAINT_MIN && x <=FizzBuzz.X_CONSTRAINT_MAX) 
				|| !(y >= FizzBuzz.Y_CONSTRAINT_MIN && y <=FizzBuzz.Y_CONSTRAINT_MAX) 
				|| !(limit >= FizzBuzz.N_CONSTRAINT_MIN && y <=FizzBuzz.N_CONSTRAINT_MAX))
		{
			return;
		}
		String replaceWith = "";
		String output = "";
		for(int i = 1; i <= limit; i++)
		{
			if(i % x == 0)
			{
				replaceWith = "F";
			}
			if(i % y == 0)
			{
				replaceWith += "B";
			}
			if(replaceWith != null && !replaceWith.equalsIgnoreCase(""))
			{
				output += replaceWith + " ";
			}
			else
			{
				output += i + " ";
			}
			//reset
			replaceWith = "";
		}
		System.out.println(output.trim());
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);		
		String row = "";
		
		FizzBuzz fb = new FizzBuzz();
		
		int testCaseConstraint = 0;
		
		while((row = br.readLine()) != null && testCaseConstraint != FizzBuzz.TEST_CASE_CONSTRAINT_LIMIT)
		{
			fb.playGame(Integer.parseInt(row.split(" ")[0]), 
					Integer.parseInt(row.split(" ")[1]), 
					Integer.parseInt(row.split(" ")[2]));
			
			testCaseConstraint++;
		}
	}

}
