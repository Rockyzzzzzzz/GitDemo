package Programme3;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItems2 {

	
		public static void main(String[] args) throws InterruptedException 
			{
				WebDriver driver= new ChromeDriver();
				int j=0;
				String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot","Carrot"};
				driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
				
				//products are not loading so for loop is failing as we are checking for size in for loop
				Thread.sleep(5000);
				
				List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
				
				
				for(int i=0;i<products.size();i++)
				{
					
					//String name=products.get(i).getText();     //Brocolli - 1 Kg
					//since the contains method in arraylist accepts object as argument we are trimming the string value to match with array list object
					//Format it to get actual veggie value
					//Brocolli - 1 Kg
					String name[]=products.get(i).getText().split("-");  
					//String name[0]="Brocolli ";
					//String name[1]= "- 1 kg";
					String formatedName=name[0].trim();
					//String formatedName=products.get(i).getText().split("-")[0].trim();  //in one step
					
					
					//convert array into arraylist for easy search
					//check wheather name you extracted is present in array or not
					
					
					List itemsNeededList =Arrays.asList(itemsNeeded);
					
					if(itemsNeededList.contains(formatedName))          //contains(object)  boolean  //exact object/string value should match so we formatted the string name
					{
						//click on add to cart
						j++;
						//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
						//Addcart text is changing to Added for few seconds so sleep time is required otherwise right different static xpath using parent child
						//Thread.sleep(5000); // this works as well
						
						driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();						
						if (j==itemsNeeded.length)
						{
					       break;
						}
					}


			     }

			}
		}


