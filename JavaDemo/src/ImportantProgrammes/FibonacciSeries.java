package ImportantProgrammes;

public class FibonacciSeries 
{

	public static void main(String[] args) 
	{
        int n=10;
        int first=0;
        int second=1;
        int res;
        System.out.print(first+","+second);
        for(int i=0;i<=n;i++)
        {
        	res=first+second;
        	System.out.print(","+res);
        	first=second;
        	second=res;
        }


	}

}
