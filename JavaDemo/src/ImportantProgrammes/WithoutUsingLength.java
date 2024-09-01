package ImportantProgrammes;

public class WithoutUsingLength 
{

	public static void main(String[] args) 
	{
         String s="Rock Star";
         char ch[]=s.toCharArray();
         int count = 0;
         for(int i=0;i<ch.length;i++)
         {
        	 count++;
        	 
         }
         System.out.println("Length of string is : "+count);

	}

}
