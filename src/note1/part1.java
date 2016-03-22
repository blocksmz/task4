package note1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class part1 {

	public static void main(String[] args)
	{
		
		//input
		Map<String,Integer> numcount=new TreeMap<String,Integer>();
		Pattern pat=Pattern.compile("\\b[A-Za-z][A-Za-z0-9]{3,}\\b");
		
		try{
		BufferedReader in=new BufferedReader(new FileReader("A_Tale_of_Two_Cities.txt"));
		String temp;
		while((temp=in.readLine())!=null)
		{
			Matcher mth=pat.matcher(temp);
			boolean tf=mth.find();
			while(tf)
			{
				String buffer=mth.group().toLowerCase();
				
				numcount.put(buffer, numcount.get(buffer)==null?1:numcount.get(buffer)+1);
//				System.out.println(buffer);
				tf=mth.find();
			}
		}
				
		in.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("Cannot find the specified file");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	
		
		//sort
		LinkedList<Map.Entry<String,Integer>> media=new LinkedList<Map.Entry<String,Integer>>(numcount.entrySet());
		Collections.sort(media,new sortman());

		sort2 soo=new sort2();
		LinkedList<Map.Entry<String, Integer>> fin=soo.r(media);
		
		
		
		//output
		if(fin==null) System.out.println("none");
		if(fin.isEmpty()) System.out.println("no element!");
		while(fin.peek()!=null)
		{
			System.out.println(fin.poll());
		}
		
		//output
//		Iterator<Map.Entry<String, Integer>> worker=fin.iterator();
//		while(worker.hasNext())
//		{
//			Map.Entry<String, Integer> sda=worker.next();
//			System.out.println(sda.getKey()+":"+sda.getValue());
//		}
		
	}
}
	
class sortman implements Comparator<Map.Entry<String, Integer>> {
	public int compare(Map.Entry<String, Integer> p1,Map.Entry<String,Integer> p2)
	{
		if(p1.getValue()<p2.getValue()) return -1;
		else if(p1.getValue()==p2.getValue()) return 0;
		else return 1;
	}
}


class sort2{
	LinkedList<Map.Entry<String, Integer>> yy;
	LinkedList<Map.Entry<String, Integer>> temppp;
	
	LinkedList<Map.Entry<String, Integer>> real(LinkedList<Map.Entry<String, Integer>> ret,Iterator<Map.Entry<String, Integer>> mm, Iterator<Map.Entry<String, Integer>> mm2)
	{
		
		Iterator<Map.Entry<String, Integer>> tt1=mm,tt2=mm2,medter=null;
		Map.Entry<String, Integer> temp1,temp2;
		if(mm==null) System.out.println("mm is null");
		if(mm2==null) System.out.println("mm2 is null");
		for(;tt1.hasNext();)
		{
			if(tt1.hasNext())
			{
				temp1=tt1.next();
				System.out.println("temp1 intialized");
				if(tt2.hasNext())
				{
					temp2=tt2.next();
					System.out.println("temp2 intialized");
					
					if(temp1.getValue()<temp2.getValue())
					{
						medter=tt1;
						System.out.println("enter the inner recurisive method");
						yy=real(ret,tt1,tt2);
						System.out.println("yy real time value:"+yy);
						
					}	
				}
				else
				{
					medter=tt2;
				}
			}
			else
			{
				medter=tt1;
			}

		}
		
		System.out.println("yy before the for, add method, return "+yy);
		for(;mm2!=medter;)
		{
			if(mm2.hasNext())
				yy.add(mm2.next());
		}
		
		System.out.println("yy returned "+yy);
		return yy;
	}
	
	public LinkedList<Map.Entry<String, Integer>> r(LinkedList<Map.Entry<String, Integer>> beg)
	{
		
		LinkedList<Map.Entry<String, Integer>> ret;
		Iterator<Map.Entry<String, Integer>> mm=beg.iterator();
		mm.next();
		Iterator<Map.Entry<String, Integer>> mm2=mm;
		ret=real(beg,mm,mm2);
		return ret;
	}
	
}
	
	