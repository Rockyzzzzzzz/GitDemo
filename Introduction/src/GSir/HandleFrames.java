package GSir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames 
{

	public static void main(String[] args)
    {
		WebDriver oBrowser = null;
		try 
         {

			//Open the browser
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\drivers\\chromedriver.exe")
			oBrowser = new ChromeDriver();
                       
            //Maximize the browser
			oBrowser.manage().window().maximize();

            //Navigate to selenium java docs
			oBrowser.navigate().to("https://selenium.dev/selenium/docs/api/java/index.html");
			Thread.sleep(2000);
                      
            //To find number of frames in the webpage or web application
			int total_frames=oBrowser.findElements(By.tagName("frame")).size();
			System.out.println("Total frames in application is :"+total_frames);

			
			//Switch to Frame 1 using index
			oBrowser.switchTo().frame(0);
			
			//Click on "org.openqa.selenium"
			oBrowser.findElement(By.linkText("org.openqa.selenium")).click();
			Thread.sleep(2000);
			
			
			//switch back to main browser
			oBrowser.switchTo().defaultContent();
			
			
			//Switch to second frame using name
			oBrowser.switchTo().frame("packageFrame");
			
			//click on "WebDriver" link
			oBrowser.findElement(By.xpath("//span[text()='WebDriver']")).click();
			
			
			//switch back to main browser
			oBrowser.switchTo().defaultContent();
			
			
			//Switch to third frame using WebElement
            //Webelement used bcz sometimes when we inspect the UI(userinterface) their is no name attribute and also if have more frames,
             // finding index is also difficult.So in such cases webelement is convinent to switch to frames.

			WebElement oFrame = oBrowser.findElement(By.xpath("//frame[@src='overview-summary.html']"));
			oBrowser.switchTo().frame(oFrame);
			Thread.sleep(2000);

            //read the header in 3rd frame
			String sHeader = oBrowser.findElement(By.xpath("//h2[@class='title']")).getText();
			System.out.println(sHeader);
			
			
			//switch back to main browser
			oBrowser.switchTo().defaultContent();
			
			
			//close the main browser
			oBrowser.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			oBrowser = null;
		}
	}

	

}
