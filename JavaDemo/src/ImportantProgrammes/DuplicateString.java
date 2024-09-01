package ImportantProgrammes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DuplicateString 
{

	public static void main(String[] args) 
	{
		String str="I am am learning java java";
		HashMap<String,Integer> hm=new HashMap<>();
		String s[]=str.split(" ");
		for(String c:s)
		{
			if(hm.containsKey(c))
			{
				hm.put(c, hm.get(c)+1);
			}
			else
			{
				hm.put(c, 1);
			}
		}
        System.out.println(hm);
        Set<String> oset= hm.keySet();
        Iterator<String> itr= oset.iterator();
        while(itr.hasNext())
        {
     	   String c1=itr.next();
     	   if(hm.get(c1)>1)
     	   {
     		   System.out.println("The string/word "+c1+" has appeared "+hm.get(c1)+" number of times");
     	   }
        }
        
        
        
	}

}
