/*

Input
{([]){}()}
Output
true
https://www.codingame.com/ide/puzzle/brackets-extreme-edition

*/


import java.util.Scanner;
import java.util.Stack;

public class BracketsExtreme {
	
	public static boolean isOpening(char x) {
		boolean flag = false;
		switch(x) {
		case '{' :
			flag  =  true;
			break;
		case '(' :
			flag = true;
			break;
		case '[' :
			flag = true;
			break;
		}
		
		return flag;
	}
	
	public static boolean isClosing(char x) {
		boolean flag = false;
		switch(x) {
		case '}' :
			flag  =  true;
			break;
		case ')' :
			flag = true;
			break;
		case ']' :
			flag = true;
			break;
		}
		
		return flag;
	}
	
	
	public static char openingPair(char x) {
		char a ='~';
		switch(x) {
		case '}' :
			a = '{';
			break;
		case ')' :
			a = '(';
			break;
		case ']' :
			a = '[';
			break;
		}
		
		return a;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Stack <Character> st = new Stack <Character> ();
		
		boolean flag =  true;
		
		char a[] = sc.nextLine().toCharArray();
		
		for(int i = 0; i < a.length; i++) {
			if (isOpening(a[i])) {
				st.push(a[i]);
			}
			else if (isClosing(a[i])) {
				if (st.empty() == true) {
					flag =  false;
					break;
				}
				
			    if (st.peek() == openingPair(a[i])) {
					st.pop();
				}
				else {
					flag = false;
					break;
				}
				
				
			}
		}
		
		if(!st.empty()) {
			flag =  false;
		}
		
		System.out.println(flag);
		
		
		
	}
	
	
	

}
