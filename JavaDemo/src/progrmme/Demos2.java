package progrmme;

public class Demos2 
{

	public static void main(String[] args)
	{
	   int a[]= {2,4,6,8,10,14,13};
	   
	   int max=a[0];
	   
	   for(int i=1;i<a.length;i++)
	   {
		   if(a[i]<max)
		   {
			   max=a[i];
		   }
	   }
	   
	   System.out.println(max);
	}

}
