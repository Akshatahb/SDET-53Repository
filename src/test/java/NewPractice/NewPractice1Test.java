package NewPractice;

import org.testng.annotations.Test;

public class NewPractice1Test {
	@Test(groups="smoke")
	public void demo1Test()
	{
		System.out.println("---------Test Script 1-----------");  
	}
	@Test
	public void demo2Test()
	{
		System.out.println("---------Test Script 222-----------");
	}
	
	@Test(groups="smoke")
	public void demo3Test()
	{
		System.out.println("---------Test Script 3-----------");
	}
}