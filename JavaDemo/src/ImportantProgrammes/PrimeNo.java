package ImportantProgrammes;

import java.util.Scanner;

public class PrimeNo 
{
    //Prime no is a no which is divisible by 1 and itself
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number :");
		int no= sc.nextInt();
		int temp=0;
		for(int i=2;i<=no-1;i++)
		{
			if(no%i==0)
			{
				temp=temp+1;
			}
		}
		if(temp==0 && no>1)
		{
			System.out.println(no+" is prime no");
		}
		else
		{
			System.out.println(no+" is not a prime no");
		}
        
	}

}
