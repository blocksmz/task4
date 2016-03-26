package note1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;
import java.util.Comparator;

public class part2 {

	public static void main(String[] args)
	{
		
		//input
		Map<String,Integer> numcount=new HashMap<String,Integer>();
		Pattern pat=Pattern.compile("\\b[A-Za-z][A-Za-z0-9]{3,}\\b");
		
		String filename="";
		String keyWord="";
		int count=0;
		
		for(int i=0;i<args.length-1;i++)
		{
			if(args[i].equals("-f"))
			{
				filename+=args[i+1];
				break;
			}
			else if(args[i].equals("-w"))
			{
				keyWord+=args[i+1];
			}
		}
		
		try{
		BufferedReader in=new BufferedReader(new FileReader(filename));
		
		//process
		String temp;
		while((temp=in.readLine())!=null)
		{
			Matcher mth=pat.matcher(temp);
			boolean tf=mth.find();
			while(tf)
			{
				String buffer=mth.group().toLowerCase();
				if(keyWord.equals(buffer))
				{
					count++;
				}
				tf=mth.find();
			}
		}	
		in.close();
		
		//output
		System.out.println("keyword "+keyWord+"occurred "+count+" times !");
		
		}catch(FileNotFoundException e)
		{
			System.out.println("Cannot find the specified file");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}

	}
}

	
	