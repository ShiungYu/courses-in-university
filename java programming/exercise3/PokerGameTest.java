
import java.security.SecureRandom;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class PokerGameTest {
	public static void main(String[] args) {
		PokerGame game = new PokerGame();
		Scanner input = new Scanner(System.in);
		while(1==1)
		{
			System.out.print("Please input your choice (0: quit, 1: play, 2: restart):");
			int choice=input.nextInt();
			if(choice==0)
			{
				System.out.println("Game over!!");
			}
			else if(choice==1)
			{
				game.dealFiveCards();
			}
			else
			{
				game=new PokerGame();
				game.dealFiveCards();
			}
		}
		
	}
} // end class PokerGame
