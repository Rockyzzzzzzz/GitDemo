package GSir;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {

	@Test
	public void equals() 
	{
		String s1 = "SG Testing";
		String s2 = new String("SG Testing");
		Assert.assertEquals(s1, s2);
		System.out.println("**************");
	}
	
	
	@Test
	public void same() 
	{
		String s1 = "SG Testing";
		String s2 = new String("SG Testing");
		Assert.assertSame(s1, s2);
		System.out.println("**************");
	}

}
