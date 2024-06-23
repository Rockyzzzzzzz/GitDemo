package TestNgTutorial;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 
{
	
	@AfterTest
   public void lastExecution()
   {
	   System.out.println("After test");
   }
   @Test
   public void demo()
   {
	   System.out.println("hello");
	   Assert.assertTrue(false);
   }
   
   @AfterClass
   public void afClass()
   {
	   System.out.println("after class Day 1");
   }
   
   @AfterSuite
   public void afSuite()
   {
	   System.out.println("After Suite");
   }
   
   @Test
   public void secondTest()
   {
	   System.out.println("bye");
   }
}
