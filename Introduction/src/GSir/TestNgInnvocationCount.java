package GSir;

import org.testng.annotations.Test;

public class TestNgInnvocationCount 
{

	@Test(invocationCount=10)
	public void createUser() 
	{
		System.out.println("Create user");
	}

}
