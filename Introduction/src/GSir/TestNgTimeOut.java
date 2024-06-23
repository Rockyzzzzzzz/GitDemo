package GSir;

import org.testng.annotations.Test;

public class TestNgTimeOut {

	@Test(timeOut = 2000)
	public void createUser() {
		try {
			System.out.println("Create User");
			Thread.sleep(3000);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
