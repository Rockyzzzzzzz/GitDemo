package GSir;

import java.io.File;

import org.testng.annotations.Test;

public class TestNgExceptionCondition {

	
		@Test(expectedExceptions=ArithmeticException.class)
		public void division()
		{
			int result = 0;
			result = 10/0;
			System.out.println(result);
		}
		
		
		@Test(expectedExceptions=NullPointerException.class)
		public void fileSystem()
		{
			File f1 = null;
			//f1 = new File("G:\\CoreJava\\Sample.txt");
			System.out.println(f1.getName());
		}

	}


