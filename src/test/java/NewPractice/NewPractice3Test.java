package NewPractice;

import org.testng.annotations.Test;

public class NewPractice3Test {
	
	@Test(groups="smoke")
	public void sam1Test()
	{
		System.out.println("---------Test Script 7-----------");
	}
	@Test(groups={"regression"})
	public void sam2Test()
	{
		System.out.println("---------Test Script 8-----------");  
	}

	@Test
	public void sam3Test()
	{
		System.out.println("---------Test Script 9-----------");
	}
}
