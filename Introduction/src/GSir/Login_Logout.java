package GSir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Logout {

	public static void main(String[] args) 
	{
		WebDriver ch = null;
		try {
			//Loading .exe file(which is having supporting artifacts
			//to invoke Jason wire protocol
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			
			//maximize the browser
			ch.manage().window().maximize();
			
			//navigate the URL
			ch.get("https://rahulshettyacademy.com/client");
			Thread.sleep(2000);
			
			
			//verify page opened
			String strTitle = ch.getTitle();
			System.out.println(strTitle);
			if(strTitle.equalsIgnoreCase("Let's Shop")) 
            {
	          System.out.println("Page opened successful");
            }else 
            {
	          System.out.println("Failed to open the page");
            }
			
			//Login to application
			ch.findElement(By.id("userEmail")).sendKeys("rakeshvijayh33@gmail.com");
			ch.findElement(By.id("userPassword")).sendKeys("Rakesh@94");
			ch.findElement(By.name("login")).click();
			Thread.sleep(2000);
			
			//login is successful
			String pageTitle=ch.findElement(By.xpath("(//div/p)[1]")).getText();
			System.out.println(pageTitle);
			if(pageTitle.equalsIgnoreCase("Automation Practice"))
			{
				System.out.println("Login is successful");
			}else 
			{
				System.out.println("Failed to login to application");
			}
			
			//Handle the short cut
			/*if(ch.findElement(By.xpath("//div[@style='display: block;']")).isDisplayed()) {
				ch.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			}
			Thread.sleep(2000);*/
			
			//logout from the application
			ch.findElement(By.xpath("//button[text()=' Sign Out ']")).click();
			Thread.sleep(2000);
			
			//verify logout successful
			String strURL = ch.getCurrentUrl();
			System.out.println(strURL);
			if(strURL.equalsIgnoreCase("https://rahulshettyacademy.com/client/auth/login"))
			{
				System.out.println("Logout is successful");
			}else 
			{
				System.out.println("Failed to logout");
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


	}


