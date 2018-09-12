/*
https://www.codingame.com/ide/puzzle/the-river-ii-

*/



import java.util.*;
import java.io.*;
import java.math.*;


class TheRiver2 {

    
		public static long sumnum (long a) {
		long sum = 0; 
		long r;
		while(a!= 0) {
			r =  a % 10;
			sum += r;
			a = a/10;
		}
		
		return  sum ; 
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		String a =  sc.nextLine();
		int digits =  a.length();
		int maxnum = digits * 9;
		
		long num =  Long.parseLong(a);
		
		long cnum =  num;
		boolean flag = false;
		
		
		for(int i = 1 ; i < maxnum ; i++) {

			if(num - i > 0) {
			
			if (((num -i) + sumnum (num -i)) == num) {
				flag = true;
				break;
				
			}
			
			}
			else
				break;
		}
		
		System.out.println(flag ? "YES" : "NO");
		
	}

}
