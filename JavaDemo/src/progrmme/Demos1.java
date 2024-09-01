package progrmme;

public class Demos1 
{

	public static void main(String[] args) 
	{
		String s="Test a is this";
		String rev="";
		String s1[]=s.split(" ");
		for(int i=s1.length-1;i>=0;i--)
		{
			rev=rev+s1[i]+" ";
		}
		
		rev=rev.substring(0,1).toUpperCase()+rev.substring(1,9)+rev.substring(9,11).toLowerCase()+rev.substring(11);
       System.out.println(rev);
	}

}
//this is a Test 
