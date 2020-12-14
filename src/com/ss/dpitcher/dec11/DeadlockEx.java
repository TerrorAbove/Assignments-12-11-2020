package com.ss.dpitcher.dec11;

/**
 * 
 * @author David Pitcher
 *
 */
public class DeadlockEx
{
	public static void main(String[] args)
	{
		Object o1 = new Object();
		Object o2 = new Object();
		
		Runnable r1 = new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("Thread one started.");
				try
				{
					synchronized(o1)
					{
						Thread.sleep(100);
						synchronized(o2)
						{
							System.out.println("Thread one says hello.");
						}
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		};
		
		Runnable r2 = new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("Thread two started.");
				try
				{
					synchronized(o2)
					{
						Thread.sleep(100);
						synchronized(o1)
						{
							System.out.println("Thread two says hello.");
						}
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		};
	
		new Thread(r1).start();
		new Thread(r2).start();
	}
}
