package note1;
import java.util.*;

public class Lsd {

	public static void main(String[] args)
	{
		LinkedList<String> ss=new LinkedList<String>();
		String sss1="sdad";
		String sss2="sdad";
		String sss3="eeee";
		ss.push(sss1);
		ss.push(sss2);
		ss.push(sss3);
		Iterator<String> sda=ss.iterator();
		sda.next();
		Iterator<String> sdb=sda;
		sda.next();
		if(sdb==sda)
		{
			System.out.println("the same!");
		}
	}
	
}
