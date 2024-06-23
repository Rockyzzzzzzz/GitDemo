package Programme5;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Miscelleanous 
{

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.com/");
		
		//Take overall screen screen shot
		TakesScreenshot t =((TakesScreenshot)driver);
		File src=t.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D://screenshot.png"));
       
        
        //Take webElement screen shot
        WebElement w=driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        File src1 =w.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src1, new File("D://googlelogo.png"));
        
	}
}
