package GSir;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicAlert 
{

	public static void main(String[] args) 
	{
		WebDriver ch = null;
		try {
			
			ch = new ChromeDriver();

			ch.manage().window().maximize();
			
			ch.get("https://rahulshettyacademy.com/AutomationPractice/");
			Thread.sleep(2000);
			
			//Click on button to get the Alert
			ch.findElement(By.id("name")).sendKeys("Rakesh");
			ch.findElement(By.cssSelector("[id='alertbtn']")).click();
			Thread.sleep(1000);
			
			//Verify alert is present. If present handle the alert
            //Handle dynamic alert 
          if(isAlertPresent(ch)==true) 
             {
                 System.out.println("Alert Found");
	             
	             System.out.println(ch.switchTo().alert().getText());
	             ch.switchTo().alert().accept();
             }
           else 
            {
	             System.out.println("Alert doesnot exist");
            }
			
			//Close the browser
			ch.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ch = null;
		}
	}

	    //Check alert is present?
		static boolean isAlertPresent(WebDriver oDriver) 
		{
			try 
			{
				oDriver.switchTo().alert();
				return true;
			}catch(NoAlertPresentException e)
			{
				return false;
			}
		}

}
