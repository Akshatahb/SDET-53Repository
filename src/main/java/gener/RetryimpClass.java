package gener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryimpClass implements IRetryAnalyzer{

	int counter=0;
	int retrycount=4;
	 
	@Override
	public boolean retry(ITestResult result) {
		
		if(counter<retrycount)
		{
			counter++;
			return true;
		}
		return false;
	}

}
