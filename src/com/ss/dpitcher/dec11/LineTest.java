package com.ss.dpitcher.dec11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * 
 * @author David Pitcher
 *
 */
public class LineTest
{
	private Line line0, line1;
	
	@Test
	public void getSlopeTest()
	{
		double x0 = Math.random(), y0 = Math.random(), x1 = Math.random(), y1 = Math.random();
		line0 = new Line(x0, y0, x1, y1);
		
		if(x1 != x0)
			assertEquals(line0.getSlope(), (y1 - y0) / (x1 - x0), 0.0001);
		else
		{
			try
			{
				line0.getSlope();//this should always throw an ArithmeticException
				fail();//if not, the test fails
			}
			catch(ArithmeticException ae) {}
		}
	}
	
	@Test
	public void getDistanceTest()
	{
		double x0 = Math.random(), y0 = Math.random(), x1 = Math.random(), y1 = Math.random();
		line0 = new Line(x0, y0, x1, y1);
		
		assertEquals(line0.getDistance(), Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0)), 0.0001);
	}
	
	@Test
	public void parallelToTest()
	{
		double x0 = Math.random(), y0 = Math.random(), x1 = Math.random(), y1 = Math.random();
		line0 = new Line(x0, y0, x1, y1);
		double x2 = Math.random(), y2 = Math.random(), x3 = Math.random(), y3 = Math.random();
		line1 = new Line(x2, y2, x3, y3);
		
		assertEquals(line0.parallelTo(line1), Math.abs(line0.getSlope() - line1.getSlope()) < 0.0001);
	}
}
