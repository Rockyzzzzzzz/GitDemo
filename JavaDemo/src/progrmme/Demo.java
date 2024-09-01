package progrmme;

public class Demo {

	public static void main(String[] args) {
		String s="Please use temporary password 'rahulshettyacademy' to Login.";
		String s1[]=s.split("'");
		//for(String ss:s1)
		//{
		//	System.out.println(ss);
		//}
              String   password= s1[1];
              System.out.println(password);
	}

}
