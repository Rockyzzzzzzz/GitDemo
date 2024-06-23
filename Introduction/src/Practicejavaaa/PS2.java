package Practicejavaaa;

public class PS2 extends PS3   //utility class notyhing but reusable methods
{
    int a;
    public PS2(int a) 
    {
      super(a);
      this.a=a;
	}
	public int increment()
    {
    	a=a+1;
    	return a;
    }
	
	public int decrement()
    {
    	a=a-1;
    	return a;
    }
}
