package com.randomproblems;

import java.util.Scanner;

public class UnwantedParanthesis 
{
	private String expression;
	
	public UnwantedParanthesis(String expression)
	{
		this.expression = expression;
	}
	
	public String removeUnwatedParanthesis()
	{
		String finalExp = "";
		char[] expArray = this.expression.toCharArray();
		for(int i = 0; i < expArray.length; i++)
		{
			if(i == expArray.length-1 && expArray[i] == ')'  &&  expArray[i-1] == ')')
			{
				continue;
			}
			else if(i == expArray.length-1 && expArray[i] == '('  &&  (expArray[i-1] == ')' || expArray[i-1] == '('))
			{
				continue;
			}
			else if(expArray[i] == '(' && expArray[i+1] == '(')
			{
				continue;
			}
			else if(expArray[i] == ')' && expArray[i+1] == '(')
			{
				continue;
			}
			else if(expArray[i] == '(' && expArray[i+1] != '(')
			{
				finalExp += expArray[i];
			}
			else if(expArray[i] == ')' && expArray[i+1] == ')')
			{
				continue;
			}
			else if(expArray[i] == ')' && expArray[i+1] == ')')
			{
				finalExp += expArray[i];
			}
			else if(expArray[i] == ')' && expArray[i+1] == '(')
			{
				continue;
			}
			else if(expArray[i] == '(' && expArray[i+1] == ')')
			{
				continue;
			}
			else
			{
				finalExp += expArray[i];
			}
		}
		return finalExp;
	}
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the expression to evaluate: ");
		String exp = s.nextLine();
		UnwantedParanthesis up = new UnwantedParanthesis(exp);
		System.out.println("Cleaned out expression: " + up.removeUnwatedParanthesis());
	}

}
