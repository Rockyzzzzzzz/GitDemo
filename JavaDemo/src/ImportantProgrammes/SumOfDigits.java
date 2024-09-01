package ImportantProgrammes;

import java.util.Scanner;

public class SumOfDigits 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int num= sc.nextInt();
		int temp=num;
		int sum=0;
		int rem;
		while(temp!=0)
		{
			rem=temp%10;
			sum=sum+rem;
			temp=temp/10;
		}
        System.out.println(sum);
	}

}
