package TestNgTutorial;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 
{
	@Parameters({"URL"})
	@Test
    public void WebloginHomeLoan(String urlName)
    {
   	 System.out.println("Webloginhome");
   	 System.out.println(urlName);
    }
	
	@Test(groups= {"Smoke"})
    public void MobileLoginHomeLoan()
    {
   	 System.out.println("Mobileloginhome");
    }

	@Test
    public void ApiLoginHomeLoan()
    {
   	 System.out.println("APIloginhome");
    }
	
	@BeforeClass
	public void bfClass()
    {
   	 System.out.println("Before class Day 4");
    }
}
