package TestNgTutorial;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 
{
     @Test(groups= {"Smoke"})
     public void ploan()
     {
    	 System.out.println("good");
     }
     
     @BeforeGroups(groups= {"Smoke"})
     public void bgroup()
     {
    	 System.out.println("before group");
     }
     
     @AfterGroups(groups= {"Smoke"})
     public void agroup()
     {
    	 System.out.println("after group");
     }
     @BeforeTest
     public void prerequiste()
     {
    	 System.out.println("Before test");
     }
}
