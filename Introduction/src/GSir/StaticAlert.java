package GSir;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticAlert 
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
			
			Alert oAlert = ch.switchTo().alert();
			String strText = oAlert.getText();
			System.out.println(strText);
			
			oAlert.accept();
			Thread.sleep(1000);
			//System.out.println(driver.switchTo().alert().getText());
			//driver.switchTo().alert().accept();
			
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

	

}
