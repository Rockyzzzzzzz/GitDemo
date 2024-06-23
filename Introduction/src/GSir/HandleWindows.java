package GSir;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows 
{

	public static void main(String[] args) 
	{
		WebDriver oBrowser = null;
		try {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\drivers\\chromedriver.exe");
			oBrowser = new ChromeDriver();
			
			//maximize the browser
			oBrowser.manage().window().maximize();
                         
            //Navigate URL
			oBrowser.get("http://popuptest.com/");
			Thread.sleep(2000);
                        
           // getWindowHandle() gives only parent window id
            String sParent = oBrowser.getWindowHandle();
			System.out.println("Parent: "+sParent);
		
			
			//click on the link to get the child window
			oBrowser.findElement(By.linkText("Multi-PopUp Test")).click();
			Thread.sleep(5000);
			
            //getWindowHandles() gives all window id's including parent and child
			Set<String> oChild = oBrowser.getWindowHandles();
			for(String child: oChild)
			{

                //Verify that the window id is not a parent or if u want only chid window ids
				if(child!=(sParent)) //it means when window ids present in child variable are not equals to parent window id
                {

					System.out.println("Child: "+child);
                                        
                    //switch to child browser
					oBrowser.switchTo().window(child);
                                        
                     //can also be written as
                    /* WebDriver w=oBrowser.switchTo().window(child);
					String sTitle = w.getTitle();
					System.out.println(sTitle);*/

					String sTitle = oBrowser.getTitle();
					System.out.println(sTitle);
					
					String sURL = oBrowser.getCurrentUrl();
					System.out.println(sURL);
					
					Thread.sleep(2000);
					oBrowser.close();

				}

			}

			//switch back to parent
			oBrowser.switchTo().window(sParent);
			Thread.sleep(2000);

            //oBrowser.close();	//only parent window will close 
			oBrowser.quit();   // all windows will close

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
