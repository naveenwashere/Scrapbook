package com.codesamples;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class NaturalNumBlockingQueue {

	private BlockingQueue<Integer> threadOneQ;
	private BlockingQueue<Integer> threadTwoQ;
	public NaturalNumBlockingQueue()
	{
		threadOneQ = new LinkedBlockingDeque<Integer>();
		threadTwoQ = new LinkedBlockingDeque<Integer>();
	}
	class OddNumThread extends Thread
	{
		public void run()
		{
			int curr = 1;
				try {
					while(true)
					{
						curr = threadOneQ.take();
						System.out.println("Odd : " + curr);
						if(curr >= 99)
						{
							threadTwoQ.offer(curr + 1);
							System.out.println("Odd Breaking");
							break;
						}
						threadTwoQ.offer(curr + 1);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
	
	class EvenNumThread extends Thread
	{
		public void run()
		{
			int curr = 1;
			try {
				while(true)
				{
					curr = threadTwoQ.take();
					System.out.println("Even : " + (curr));
					if(curr >= 100)
					{
						System.out.println("Even Breaking");
						break;
					}
					threadOneQ.offer(curr + 1);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String []args)
	{
		NaturalNumBlockingQueue nature = new NaturalNumBlockingQueue();
		OddNumThread odd = nature.new OddNumThread();
		EvenNumThread even = nature.new EvenNumThread();
		odd.start();
		even.start();
		nature.threadOneQ.offer(1);
	}

}
