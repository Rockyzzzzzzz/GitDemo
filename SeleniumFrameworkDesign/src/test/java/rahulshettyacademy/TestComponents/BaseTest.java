package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest 
{
    public WebDriver driver;          //WebDriver driver=null;
    public LandingPage landingPage;   //LandingPage landingPage=null;
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop=new Properties();          //System.getProperty("user.dir")   gives project path
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
			
		else if(browserName.equalsIgnoreCase("edge"))
		{

			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("appURL"));
		return driver;
	}
	
	public List<HashMap<String, String>> getJasonDataToMap(String filePath) throws IOException
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//convert string to json  using jackson databind dependency
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data =mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;	
	}
	
	
	 public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	    {
	    	TakesScreenshot ts =((TakesScreenshot)driver);
			File src=ts.getScreenshotAs(OutputType.FILE);
	       // FileUtils.copyFile(src, new File("D://screenshot.png"));
			File file=new File(System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png");
			FileUtils.copyFile(src, file);
	        return System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png";
			
	    }
		
	    @BeforeMethod(alwaysRun=true) //it works for any groups                            //(groups= {"ErrorHandling"})
		public LandingPage launchApplication() throws IOException
		{
			 driver=initializeDriver();
			 landingPage=new LandingPage(driver);
			 //landingPage.goTo();
			 return landingPage;
		}
		
	    @AfterMethod(alwaysRun=true)
		public void tearDown()
		{
			 driver.close();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

