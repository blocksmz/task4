package note1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;
import java.util.Comparator;

public class part1 {

	public static void main(String[] args)
	{
		
		//input
		Map<String,Integer> numcount=new HashMap<String,Integer>();
		Pattern pat=Pattern.compile("\\b[A-Za-z][A-Za-z0-9]{3,}\\b");
		
		String filename="";
		
		for(int i=0;i<args.length-1;i++)
		{
			if(args[i].equals("-f"))
			{
				filename+=args[i+1];
				break;
			}
		}
		
		try{
		BufferedReader in=new BufferedReader(new FileReader(filename));
		String temp;
		while((temp=in.readLine())!=null)
		{
			Matcher mth=pat.matcher(temp);
			boolean tf=mth.find();
			while(tf)
			{
				String buffer=mth.group().toLowerCase();
				numcount.put(buffer, numcount.get(buffer)==null?1:numcount.get(buffer)+1);
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
		
		//output
		Iterator<Map.Entry<String,Integer>> w1=media.iterator();
		for(Map.Entry<String, Integer> disp1;w1.hasNext();)
		{
			disp1=w1.next();
			System.out.println(disp1.getKey()+":"+disp1.getValue());
		}
	}
}

class sortman implements Comparator<Map.Entry<String, Integer>> {
	public int compare(Map.Entry<String, Integer> p1,Map.Entry<String,Integer> p2)
	{
		if(p1.getValue()<p2.getValue()) return 1;
		else if(p1.getValue()==p2.getValue())
				if(p1.getKey().compareTo(p2.getKey())<0) return -1;
				else if(p1.getKey().compareTo(p2.getKey())==0) return 0;
				else return 1;
		else return -1;
	}
}


	
	