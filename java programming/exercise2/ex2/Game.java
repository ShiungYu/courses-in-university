public class Game {
	public static void main(String[] args) {
		// Code here
		Player player1 = new Player();
		System.out.printf("Player1 -> HP: %d, attack points: %d%n", player1.getHp(), player1.getAttackPoints());
		// Code here
		Player player2 = new Player();
		System.out.printf("Player2 -> HP: %d, attack points: %d%n", player2.getHp(), player2.getAttackPoints());

		while (true) {
			player1.attack(player2);
			String player2Hp=player2.getHp()+"";
			//千位有逗號程式
			String ans2="";
			int i;
			int j;
			for(i=0,j=-1;i<=player2Hp.length();i++,j++)
			{
				if(i%3==0 && i!=0)
				{
					j=-1;
					if(i!=3)
					{
						ans2=player2Hp.substring(player2Hp.length()-i,player2Hp.length()+3-i)+","+ans2;
					}
					else 
					{
						ans2=player2Hp.substring(player2Hp.length()-i,player2Hp.length()+3-i);
					}
				}
			}
			if(j!=0&&i>3)
			{
				ans2=player2Hp.substring(0,0+j)+","+ans2;
			}
			else if(j!=0)
			{
				ans2=player2Hp.substring(0,0+j);
			}
			System.out.printf("Player1 attacks! Player2's HP becomes %s%n", ans2);
			if(player2.getHp()==0)
			{
				System.out.println("Player1 wins!");
				break;
			}
			// Code here to determine the winner and exit while

			player2.attack(player1);
			String player1Hp=player1.getHp()+"";
			String ans1="";
			for(i=0,j=-1;i<=player1Hp.length();i++,j++)
			{
				if(i%3==0 && i!=0)
				{
					j=-1;
					if(i!=3)
					{
						ans1=player1Hp.substring(player1Hp.length()-i,player1Hp.length()+3-i)+","+ans1;
					}
					else 
					{
						ans1=player1Hp.substring(player1Hp.length()-i,player1Hp.length()+3-i);
					}
				}
			}
			if(j!=0&&i>3)
			{
				ans1=player1Hp.substring(0,0+j)+","+ans1;
			}
			else if(j!=0)
			{
				ans1=player1Hp.substring(0,0+j);
			}
			System.out.printf("Player2 attacks! Player1's HP becomes %s%n", ans1);
			if(player1.getHp()==0)
			{
				System.out.println("Player2 wins!");
				break;
			}
			// Code here to determine the winner and exit while
		}
	}
}