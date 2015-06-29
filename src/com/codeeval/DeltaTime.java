package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DeltaTime {

	private String calculateTimeDelta(String times)
	{
		String timeOne = times.split(" ")[0];
		String timeTwo = times.split(" ")[1];

		long t1 = 0, t2 = 0;
		long diff = 0;
		
		t1 = getTimeInSeconds(timeOne);
		t2 = getTimeInSeconds(timeTwo);
		
		//Calculate the time diff now, in seconds
		if(t1 > t2)
		{
			diff = t1 - t2;
		}
		else
		{
			diff = t2 - t1;
		}
		
		String diffTime = null;
		int i = 0, hours = 0, minutes = 0, seconds = 0;
		while(diff > 60)
		{
			//Calc hours
			if(i == 0)
			{
				hours = (int) (diff/(60 * 60));
				diff = diff%(60 * 60);
			}
			//Calc minutes
			if(i == 1)
			{
				minutes = (int) (diff/60);
				diff = diff%60;
			}
			//Seconds
			else
			{
				seconds = (int) diff%60;
			}
			i++;
		}
		
		diffTime = String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
		
		return diffTime;
	}
	private int getTimeInSeconds(String time) 
	{
		int timeInSeconds = 0;
		int i = 0;
		String[] splitTime = time.split(":");
		for(String str : splitTime)
		{
			//Hours to Seconds
			if(i == 0)
			{
				timeInSeconds += (Integer.parseInt(str) * 60 * 60);
			}
			//Minutes to Seconds
			else if(i == 1)
			{
				timeInSeconds += Integer.parseInt(str) * 60;
			}
			//Seconds
			else
			{
				timeInSeconds += Integer.parseInt(str);
			}
			i++;
		}
		return timeInSeconds;
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
		
		DeltaTime dt = new DeltaTime();
		while((row = br.readLine()) != null)
		{
			System.out.println(dt.calculateTimeDelta(row));
		}
	}

}
