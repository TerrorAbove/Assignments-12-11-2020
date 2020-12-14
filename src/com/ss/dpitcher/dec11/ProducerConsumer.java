package com.ss.dpitcher.dec11;

/**
 * 
 * @author David Pitcher
 *
 */
public class ProducerConsumer
{
	public static void main(String[] args)
	{
		int[] products = new int[10];
		
		Thread producer = new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				synchronized(products)//lock products until we're done writing to it
				{
					int index = 0;
					while(index < products.length)
					{
						products[index] = (int)(Math.random() * 9) + 1;//store a random digit 1-9
						index++;
					}
				}
			}
			
		});
		
		Thread consumer = new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				synchronized(products)//wait for the lock so we know all of the data has been written
				{
					int index = 0;
					
					while(index < products.length)
					{
						System.out.println(products[index]);
						index++;
					}
				}
			}
			
		});
		
		producer.start();
		consumer.start();
	}
}
