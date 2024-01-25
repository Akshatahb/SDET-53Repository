package NewPractice;

import org.testng.annotations.Test;

public class NewPractice2Test {
	
	@Test(groups={"smoke","regression"})
	public void sample1Test()
	{
		System.out.println("---------Test Script 4-----------");
	}
	@Test(groups="smoke")
	public void sample2Test()
	{
		  System.out.println("---------Test Script 5-----------");
	}

	@Test
	public void sample3Test()
	{
		System.out.println("---------Test Script 6-----------");
	}
}
