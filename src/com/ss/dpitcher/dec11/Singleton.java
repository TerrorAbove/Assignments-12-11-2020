package com.ss.dpitcher.dec11;

/**
 * 
 * @author David Pitcher
 *
 */
public class Singleton
{
	private static volatile Singleton instance;
	
	/**
	 * 
	 * @return the single instance of this class, creating it if necessary
	 */
	public static Singleton getInstance()
	{
		if(instance == null)
		{
			synchronized(Singleton.class)
			{
				if(instance == null)
				{
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
