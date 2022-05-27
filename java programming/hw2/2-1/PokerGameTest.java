import java.security.SecureRandom;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class PokerGameTest {
	public static void main(String[] args) {
		PokerGame game = new PokerGame();
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.print("Please input your choice (0: quit, 1: play, 2: restart):");//input 0,1,2
			int choice=input.nextInt();
			if(choice==0)//end game
			{
				System.out.println("Game over!!");
				return;
			}
			else if(choice==1)//play the game
			{
				game.dealFiveCards();
			}
			else//reshuffle
			{
				game=new PokerGame();
				game.dealFiveCards();
			}
		}
		
	}
} // end class PokerGame
