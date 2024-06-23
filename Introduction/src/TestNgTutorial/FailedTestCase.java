package TestNgTutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedTestCase 
{
	 @Test
	   public void demo()
	   {
		   System.out.println("hello");
		   Assert.assertTrue(false);
	   }
	 
	 @Test
	   public void demo1()
	   {
		   System.out.println("bye");
		   
	   }
	
	 @Test
	   public void demo2()
	   {
		   System.out.println("high");
		   Assert.assertTrue(false);
	   }
	 
	 @Test
	   public void demo3()
	   {
		   System.out.println("low");
		   Assert.assertTrue(false);
	   }
}
