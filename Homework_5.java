import java.util.ArrayList;
import java.util.Scanner;

public class Homework_5 {

	public static void main(String [] args)
	{
		boolean flag=true;
		boolean valid = true;
		ArrayList<String> tuples = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		while(flag)
		{
			String str = "";
			System.out.println("Please enter your tuple");
			System.out.print("Old State: ");
			String a = s.next()+",";
			if(Integer.valueOf(a)>20)
				valid = false;
			str += a+",";
			System.out.print("Tape-symbol (-1, 0, 1): ");
			a = s.next();
			if(Integer.valueOf(a)<=1 && Integer.valueOf(a)>=-1)
				valid = false;
			str += a+",";
			System.out.print("Old-stack-symbol: ");
			str += s.next()+",";
			System.out.print("New-state: ");
			str += s.next()+",";
			System.out.print("New-stack: ");
			str += s.next();
			System.out.print("Would you like to enter another tuple? (y/n): ");
			String ans = s.next();
			if(ans.equals("n"))
				flag=false;
		}
	}
}