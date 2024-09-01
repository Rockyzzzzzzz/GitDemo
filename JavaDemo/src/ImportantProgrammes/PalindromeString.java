package ImportantProgrammes;

import java.util.Scanner;

public class PalindromeString 
{
    //when we reverse any String(word/number) it should be same i.e palindrome ex:- MOM, POP,1001,202 etc
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String :");
		String original= sc.nextLine();
		String reverse="";
		for(int i=original.length()-1;i>=0;i--)
		{
			reverse=reverse+original.charAt(i);
		}
        if(original.equalsIgnoreCase(reverse))
        {
        	System.out.println("Given string "+original+" is a palindrome");
        }
        else
        {
        	System.out.println("Given string "+original+" is not a palindrome");
        }
	}

}
