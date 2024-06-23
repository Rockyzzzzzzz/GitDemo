package Programme4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Links {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php");
		
		//1) Get the count of links on the page?
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//WebElement w= driver.findElement(By.xpath("//body"));
		//System.out.println(w.findElements(By.tagName("a")).size());
		
		//2) Get the count of links on the footer section of the page?
		WebElement footerDriver= driver.findElement(By.id("gf-BIG")); //limiting the webDriver scope from entire page to footer section
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		//3) Get the count of links in the first column of footer section on the page?
		WebElement columnDriver= footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		int sizeOfLinks= columnDriver.findElements(By.tagName("a")).size();
		
		//4)Click on each link in the column and check if the pages are opening
		for(int i=1; i<sizeOfLinks; i++)
		{
			//columnDriver.findElements(By.tagName("a")).get(i).click();
			//driver.navigate().back();
			
			//click on the links using ctrl+click to open in diff tabs
			String clickOnLinkTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);	 
			Thread.sleep(3000L);
		} //opens all the tabs
		 
		Set<String> windowids= driver.getWindowHandles();
		Iterator<String> it= windowids.iterator();
		while(it.hasNext())
		{
			//String s=it.next();
			//driver.switchTo().window(s);
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
		
	}

}
