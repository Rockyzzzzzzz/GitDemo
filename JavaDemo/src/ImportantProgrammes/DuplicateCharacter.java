package ImportantProgrammes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DuplicateCharacter 
{

	public static void main(String[] args) 
	{
		String str="jj   avajjj";
		HashMap<Character,Integer> hm=new HashMap<>();
		char ch[]=str.toCharArray();
		for(char c:ch)
		{
			//if(!String.valueOf(c).isBlank())      //to remove empty spaces (naveen automation)
		    if(String.valueOf(c).isBlank()==false)  //to remove empty spaces (naveen automation)
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
		}
        System.out.println(hm);
        
       Set<Character> oset= hm.keySet();
       Iterator<Character> itr= oset.iterator();
       while(itr.hasNext())
       {
    	   char c1=itr.next();
    	   if(hm.get(c1)>1)
    	   {
    		   System.out.println("The character "+c1+" has appeared "+hm.get(c1)+" number of times");
    	   }
       }
	}

}
