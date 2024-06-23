		package Programme2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//dropdown with select tag is nothing but static drop down
		WebElement staticdropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown= new Select(staticdropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		//<option value="AED">AED</option>
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		//<option value="INR">INR</option>
		System.out.println(dropdown.getFirstSelectedOption().getText());
	System.out.println("------------------------------------------------------------------------------------------------------------------------------------");	
		//To find total options in dropdown
		List<WebElement> options=dropdown.getOptions();
		System.out.println(options.size());
		
		//print options in console window using for loop
		for(int i=0; i<options.size(); i++)
		{
			System.out.println("For loop: "+options.get(i).getText());
		}
		
		//print options in console window using for each/enhanced loop
		for(WebElement op:options)
		{
			System.out.println("For each/enchanced loop: "+op.getText());
		}
		
		//print options in console window using cursors
		Iterator it=options.iterator();
		while(it.hasNext())
		{
			WebElement w=(WebElement) it.next();
			System.out.println("Iterator: "+w.getText());
		}

	}

}
