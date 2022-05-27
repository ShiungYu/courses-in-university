
import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class War {
	public static final int ATTACK = 1;
	public static final int DEFEND = 2;
	public static final int END = 3;

	private Player user;
	private Player npc;
	private final SecureRandom random = new SecureRandom();

	public War(Player user, Player npc) {
		this.user = user;
		this.npc = npc;
	}

	public void battle() {

		Scanner input = new Scanner(System.in);

		while (true) {

			System.out.print("\n請選擇: 1.攻擊 2.防禦 3.結束: ");
			int action = -1;
			
			try {
				action = input.nextInt();
			} catch (InputMismatchException e) {
				input.nextLine();
			}
			
			System.out.println();

			if (action == ATTACK) {
				attack(user, npc, 1);
				if (determineVictory(user, npc)) {
					input.close();
					return;
				}
				System.out.println();				
				attack(npc, user, 1);
				if (determineVictory(user, npc)) {
					input.close();
					return;
				}
			} else if (action == DEFEND) {
				attack(npc, user, 2);
				if (random.nextInt(3) == 1) {//33% can do a selfheal
					System.out.println();
					selfHeal(user);
				}
				if (determineVictory(user, npc)) {
					input.close();
					return;
				}
			} else if (action == END) {
				System.out.println("遊戲結束!");
				input.close();
				return;
			} else {
				System.out.println("您輸入無效指令");
				continue;
			}
		}
	}

	public void attack(Player player1, Player player2, double defenseRate) {//player1 attacks player2
		// TODO
		System.out.printf("%s攻擊前：\n",player1.getName());
		System.out.printf("HP of %s: %.1f\n",player2.getName(),player2.getHp());
		System.out.printf("%s攻擊：\n",player1.getName());
		int sumAttackPoint=0;
		for(ATK i:player1.getEquipments())
		{
			int tempAttackPoint=(int)i.attack();
			sumAttackPoint+=tempAttackPoint;
			System.out.printf("[%s可造成 %d 點的傷害]\n",i.getName(),tempAttackPoint);
		}
		System.out.printf("%s防禦：\n",player2.getName());
		int sumDefendPoint=0;
		for(ATK i:player2.getEquipments())
		{
			int tempDefendPoint=(int)(i.defend()*defenseRate);
			sumDefendPoint+=tempDefendPoint;
			System.out.printf("[%s可抵擋 %d 點的傷害]\n",i.getName(),tempDefendPoint);
		}
		System.out.printf("%s攻擊後：",player1.getName());
		if(sumAttackPoint>sumDefendPoint)//if sum of attackpoint is biggerthan sum of defend point
			player2.setHp(player2.getHp()-sumAttackPoint+sumDefendPoint);
		System.out.printf("HP of %s: %.1f",player2.getName(),player2.getHp());
		System.out.println();
	}

	public void selfHeal(Player player) {
		// TODO
		System.out.println("selfHeal:");
		player.setHp(player.getHp()+10+random.nextInt(140));//player HP 加上10~150
		System.out.printf("%s Hp after selfHeal%.1f",player.getName(),player.getHp());
	}
	
	public boolean determineVictory (Player user, Player npc) {//determine whether anyone didn't have HP anymore
		// TODO
		if(user.getHp()<=0)//
		{
			System.out.println("玩家被NPC擊倒了！");
			return true;
		}
		else if (npc.getHp()<=0)
		{
			System.out.println("玩家擊倒了NPC！");
			return true;
		}
		else 
		 	return false;
	}
}
