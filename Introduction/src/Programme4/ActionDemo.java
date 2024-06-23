package Programme4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://myaccount.google.com/");
       // driver.findElement(By.xpath("(//a[@aria-label='Go to your Google Account'])[2]")).click();
       // driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("rakeshvijayh33@gmail.com");
        
        driver.get("https://www.amazon.in/");
		
		Actions a=new Actions(driver);
		
		//Move to element click and then press shift for capital letters and type the text and then double click to select the text
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		
		//moves to the specific element and right click
		WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		a.moveToElement(move).contextClick().build().perform();
		
		//drag and drop
	}

}