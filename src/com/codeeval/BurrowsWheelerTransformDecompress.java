package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BurrowsWheelerTransformDecompress { 

	private final static int TEST_CASE_CONSTRAINT_LIMIT = 20;
	
	private final static int INPUT_STRING_LIMIT_MIN = 5;
	
	private final static int INPUT_STRING_LIMIT_MAX = 1500;
	
	private String transformBack(String data)
	{
		//Strip of | char
		data = data.substring(0, data.length()-1);
		
		int expectedOutputLen = data.length();
		
		String[] rows = new String[data.length()];
		char[] dataAsChars = data.toCharArray();
		//Initialize the string array with empty string
		for(int i = 0; i < dataAsChars.length; i++)
		{
			rows[i] = String.valueOf(dataAsChars[i]);
		}
		
		//Make a copy of the rows array and sort it
		String[] sortedRows = Arrays.copyOf(rows, rows.length);
		Arrays.sort(sortedRows);
		
		String concat = "";
		//Keep adding/appending elements from each index of unsorted array with sorted array
		//Check if element at last index of this array has $ symbol, indicating that the  
		while(sortedRows[sortedRows.length -1].length() != expectedOutputLen)
		{
			//Add/append elements between sorted and unsorted arrays
			for(int i = 0; i < rows.length; i++)
			{
				concat = rows[i] +sortedRows[i];
				sortedRows[i] = concat; 
			}
			//Make a copy of resulting array and sort it, for next iteration!
			Arrays.sort(sortedRows);
		}
		for(int i = 0; i < sortedRows.length; i++)
		{
			System.out.println(sortedRows[i]);
		}
		//new StringBuilder(sortedRows[0]).reverse().toString()
		return sortedRows[0];
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
		int strLen = 0;
		
		BurrowsWheelerTransformDecompress fb = new BurrowsWheelerTransformDecompress();
		
		int testCaseConstraint = 0;
		
		while((row = br.readLine()) != null && testCaseConstraint != BurrowsWheelerTransformDecompress.TEST_CASE_CONSTRAINT_LIMIT)
		{
			strLen = row.length();
			if(strLen < BurrowsWheelerTransformDecompress.INPUT_STRING_LIMIT_MIN || strLen > BurrowsWheelerTransformDecompress.INPUT_STRING_LIMIT_MAX)
			{
				continue;
			}
			System.out.println(fb.transformBack(row));
			
			testCaseConstraint++;
		}
	}

}
