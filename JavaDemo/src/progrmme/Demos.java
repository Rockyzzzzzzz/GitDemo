package progrmme;

public class Demos {

	public static void main(String[] args) 
	{
		String s="abcaba";
		
		//int total_length= s.length();
		//int total_length_after_remove_a=s.replace("a", "").length();
		
		//int count_of_a= total_length-total_length_after_remove_a;
		//System.out.println(count_of_a);
		
		
		 String s1=s.replaceAll("[^a]", "");          //aaa
		 int count_a= s1.length();
		 
		 String s2=s.replaceAll("[^b]", "");          //bb
		 int count_b= s2.length();
		 
		 String s3=s.replaceAll("[^c]", "");          //c
		 int count_c= s3.length();

		 
		 System.out.println("a:"+count_a+" b:"+count_b+" c:"+count_c);
		 System.out.println("a"+count_a+"b"+count_b+"c"+count_c);
	}

}
