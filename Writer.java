package writers;

import java.util.*;

public class main{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String in;
		do {
			System.out.println("Enter the number to be spelt out: ");
			String num = sc.next();
			int n = Integer.parseInt(num);
		
			int check = num.length();
			
			String print="";
		
			switch(check) {
			case 1:
				print = onesWriter(n);
				break;
			case 2:
				print = tensWriter(n);
				break;
			case 3:
				print = hundredsWriter(n);
				break;
			case 4:
				print = thousandsWriter(n);
				break;
			default:
				System.out.println("Invalid input. Enter a number with (1-4) digits");
				break;
			}
			System.out.println(print);
			System.out.println("Do you want to spell another number? (y/n): ");
			in = sc.next();
		}while(in.equals("y"));
		
	}
	
	static String[] ones = {"","one","two","three", "four", "five", "six", "seven", "eight", "nine"};
	static String[] twos = {"ten", "eleven",  "twelve", "thirteen",  "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] tens = {"","", "twenty",  "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety" };

	public static String onesWriter(int a) {
		return(ones[a]);
	}
	
	public static String tensWriter(int n) {
		String out = "";
		if(n<20) {
			out += twos[n%10];
		}
		else if(n%10 == 0) {
			out += tens[n/10];
		}
		else {
			out += tens[n/10] + "-" + ones[n%10];
		}
		return(out);
	}
	
	public static String hundredsWriter(int n) {
		String out = "";
		out += ones[n/100]+" hundred ";
		n = n%100;
		if(n!=0) {
			out += "and ";
			out += tensWriter(n);
		}
			
		return(out);
	}
	
	public static String thousandsWriter(int n) {
		String out = "";
		out += tensWriter(n/100) + " hundred ";
		n = n%100;
		if(n!=0) {
			out += "and " + tensWriter(n);
		}
		return out;
	}
	
}
