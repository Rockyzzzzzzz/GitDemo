package ImportantProgrammes;

public class ReturnName 
{   
	
	public String returnName(String name)
	{
		return name;
	}
	

	public static void main(String[] args) 
	{
		ReturnName r=new ReturnName();
		 String name=r.returnName("rakesh");
		 System.out.println(name);
		 
	}

}
