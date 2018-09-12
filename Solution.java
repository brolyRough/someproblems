/*
https://www.codingame.com/ide/puzzle/gravity-tumbler

17 5
1
.................
.................
...##...###..#...
.####..#####.###.
#################
Output
....#
....#
....#
....#
....#
...##
...##
...##
...##
...##
...##
..###
..###
..###
..###
..###
..###

*/

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

   public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height =  sc.nextInt();
		sc.nextLine();
		
		int count =  sc.nextInt();
		sc.nextLine();
	
		
		char a[] []  =  new char [height] [width];
		
		char b[] [];
		if(count % 2 ==1)
			b =  new char [width][height];
		else 
			b  = new char [height] [width];
		
		for(int i = 0; i <height;i++) {
			a[i] =  sc.nextLine().toCharArray();
		}
		
		
		char c[] [] = new char[height] [width];
		
		for(int i = 0; i <height;i++) {
			Arrays.fill(c[i], '.');
		}
		
		
		if(count %4 == 1  || count % 4 == 3) {
			
		
			int loc;
			for(int i =0; i < height; i++) {
				loc = 0;
				for(int j = 0; j <width ; j++) {
					if (a[i][j] == '#') {
						c[i][loc] = '#';
						loc++;
					}
				}
			}
		
			
			
			for(int n = width -1 , i=0; n >= 0 && i<width;  n--, i++) {
				for(int m = 0 , j = 0; m < height && j < height; m++ , j++) {
					
					b[i][j] = c [m][n];
					
				}
			}
			
			for(int i = 0; i < width; i++) {
				for(int j = 0; j <height; j++) {
					System.out.print(b[i][j]);
				}
				System.out.println();
			}
			
		}
		
		else if(count % 4 == 2 || count %  4 == 0) {
			int loc;
			for(int i = 0; i < height;  i ++) {
				loc =  width - 1;
				for(int j = 0; j <width; j++) {
					if (a[i][j] == '#') {
						c[i][loc] =  '#';
						loc--;
					}
				}
			}
			
			
			for(int i = 0; i < height;i++) {
				for(int j = 0; j <width; j++) {
					System.out.print(c[i][j]);
				}
				System.out.println();
			}
			
			
		}
		
		
	
		
		
		
		
		
		
		
		
	}

}
