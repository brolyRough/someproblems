/*
Input
4
5
MANHATTAN
 #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### 
# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # 
### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## 
# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       
# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  # 


Output
# #  #  ### # #  #  ### ###  #  ###  
### # # # # # # # #  #   #  # # # #  
### ### # # ### ###  #   #  ### # #  
# # # # # # # # # #  #   #  # # # #  
# # # # # # # # # #  #   #  # # # # 


https://www.codingame.com/ide/puzzle/ascii-art  
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ASCIIArt {
	
	public static void main(String[] args) {
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";
		
		Scanner sc = new Scanner(System.in);
		
		int width  = sc.nextInt();
		sc.nextLine();
		int height = sc.nextInt();
		sc.nextLine();
		String text = sc.nextLine().toUpperCase();
		
		ArrayList <String>  al1 = new ArrayList <String> ();
		
		for(int i =0; i <height; i++) {
			al1.add(sc.nextLine());
		}

		
		ArrayList <Integer> indexes =  new ArrayList <Integer> ();
		
		// find the necessary indexes of letters 
		for(char c :  text.toCharArray()) {
			if (c<'A' || c >'Z') indexes.add(26);
			else {
				for(char letter :alphabet.toCharArray()) {
					if(c==letter) {
						indexes.add(alphabet.indexOf(letter));
					}
				}
			}
			
		}
		
		
		// print result 
		
		
		for(int j = 0; j <height ; j++) {
			for(int k= 0; k <indexes.size(); k++) {
				System.out.print(al1.get(j).substring(indexes.get(k)*width, 
						indexes.get(k)*width + width));
			}
			System.out.println();
		}
		
		sc.close();
		
		
		
		
		
	}
}
