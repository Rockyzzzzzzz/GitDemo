package ImportantProgrammes;

import java.util.Scanner;

public class NextPalindrome
{
   public static boolean isPalindrome(int num)
   {
	   
	   int temp=num;
	   int rem;
	   int rev=0;
	   
	   while(temp!=0)
	   {
		   rem=temp%10;
		   rev=rev*10+rem;
		   temp=temp/10;		   
	   }
	   
	   if(num==rev)
	   {
		   return true;
	   }else
	   {
		   return false;
	   }
	   
   }
	
   public static int nextPalindrome(int num)
   {
	      num++; // Start checking from the next number
	     
      // while (!isPalindrome(num))  
       while (isPalindrome(num)==false)             //while(false==false)   this will run infinite times till it becomes (true==false)
       
       {
           num++;
       }
       
       return num;
	   
   }
	
	public static void main(String[] args) 
	{
		//Scanner sc= new Scanner(System.in);
		//int num=sc.nextInt();
		
		int num=115;
		int nextPalindromeNumber = nextPalindrome(num);
		System.out.println("The next palindrome after " + num + " is: " + nextPalindromeNumber);

	}

}
