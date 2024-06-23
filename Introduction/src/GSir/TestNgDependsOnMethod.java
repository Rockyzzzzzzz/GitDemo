package GSir;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgDependsOnMethod 
{

	@Test
	public void createUser() 
	{
		System.out.println("Create User");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods="createUser", alwaysRun=true)
	public void deleteUser() 
	{
		System.out.println("delete User");
	}

}
