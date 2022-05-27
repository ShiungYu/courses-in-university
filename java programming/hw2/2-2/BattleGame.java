
import java.security.SecureRandom;

public class BattleGame {

	public static void main(String[] args) {
		Player player1 = new Player("Batman");
		determineAllWeapons(player1);
		System.out.printf("%s -> HP: %,d, attack: %,d%n%n", player1.getName(), player1.getHp(), player1.getAttack());

		Player player2 = new Player("Superman");
		determineAllWeapons(player2);
		System.out.printf("%s -> HP: %,d, attack: %,d%n%n", player2.getName(), player2.getHp(), player2.getAttack());

		
			// TODO
			// 透過此迴圈讓雙方輪流攻擊，並分出勝負
		while(player1.getHp()>0&&player2.getHp()>0)
		{
			player2.setHp(player2.getHp()-player1.getAttack());
			System.out.printf("%s attacks! %s's HP becomes %d%n",player1.getName(),player2.getName(),player2.getHp()); 
			if(player2.getHp()==0)//player2 die
			{
				System.out.printf("%s wins!",player1.getName());
				break;
			}
			player1.setHp(player1.getHp()-player2.getAttack());
			System.out.printf("%s attacks! %s's HP becomes %d%n",player2.getName(),player1.getName(),player1.getHp()); 
		}
		if(player1.getHp()==0)//player1 die
		{
			System.out.printf("%s wins!",player2.getName());
		}
		
	}
	
	// 取四個武器，第一個用製造的，第2~4則是亂數決定是製造或複製，
	// 第4個會無法成功製造或複製(因Player只能配戴3個武器)
	public static void determineAllWeapons(Player player) {
		SecureRandom random = new SecureRandom();
		player.makeWeapon();
		for (int i = 1; i <= 3; i++) {
			if (random.nextBoolean()) {
				player.makeWeapon();
			} else {
				player.cloneWeapon();
			}
		}
	}
}