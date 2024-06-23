package GSir;

import org.testng.annotations.Test;

public class TestNgEnabledFalse 
{

	
		@Test
		public void createUser()
		{
			System.out.println("User created successful");
		}
		
		@Test(enabled = false)
		public void modifyUser()
		{
			System.out.println("User modified successful");
		}
		
		@Test
		public void deleteUser()
		{
			System.out.println("User deleted successful");
		}

	

}
