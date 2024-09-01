package ImportantProgrammes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DuplicateNumbers 
{

	public static void main(String[] args) 
	{
		HashMap<Integer,Integer> hm=new HashMap<>();
		int a[]= {1,1,2,2,3,4,5,6,7,7,7,8,9,10};
		for(int temp:a)
		{
			if(hm.containsKey(temp))
			{
				hm.put(temp, hm.get(temp)+1);
			}
			else
			{
				hm.put(temp, 1);
			}
		}
        System.out.println(hm);
        Set<Integer> oset= hm.keySet();
        Iterator<Integer> itr= oset.iterator();
        while(itr.hasNext())
        {
     	   Integer c1=itr.next();
     	   if(hm.get(c1)>1)
     	   {
     		   System.out.println("The number "+c1+" has appeared "+hm.get(c1)+" number of times");
     	   }
        }
	}

}
