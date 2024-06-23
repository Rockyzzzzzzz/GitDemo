package rahulshetty.ExcelDataProvider;

import org.testng.annotations.Test;

public class ExcelTestcase 
{

	
		@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
		public void testCaseData(String greeting, String communication, String id)
		{
			System.out.println(greeting+communication+id);
		}
		

}
