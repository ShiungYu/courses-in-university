import java.util.ArrayList;

public class Player {
	public static final double MAX_HP = 1999;
	public static final int DEFAULT_HP = 200;
	public static final int DEFAULT_ATK = 50;

	private final String name;
	private double hp;
	private ArrayList<ATK> equipment = new ArrayList<ATK>();

	public Player(String name) {//contructor
		// TODO
		this.name=name;
		setHp(DEFAULT_HP);
		ATK newWeapon=new NormalWeapon(DEFAULT_ATK,0.0);
		equipment.add(newWeapon);
	}

	public Player(String name, double hp) {//contructor
		// TODO]
		this.name=name;
		setHp(hp);
		ATK newWeapon=new NormalWeapon(DEFAULT_ATK,0.0);
		equipment.add(newWeapon);
	}

	public Player(String name, double hp, ArrayList<ATK> equipments) {
		this.name = name;
		setHp(hp);
		this.equipment = equipments;//?´æŽ¥?Šweapon copy
	}

	public String getName() {
		return name;
	}

	public double getHp() {
		return hp;
	}

	public final void setHp(double hp) {
		if ((0 < hp) && (hp < MAX_HP))
			this.hp = hp;
		else
			this.hp = 0;
	}

	public ArrayList<ATK> getEquipments() {//get the equipment
		return equipment;
	}

	public void setEquipments(ArrayList<ATK> equipments) {
		this.equipment = equipments;
	}

	public double attack() {//get te total attackPoint
		// TODO
		double attackPoint=0;
		for(ATK i:equipment)
		{
			if(i.getName()!="Pet");
			attackPoint+=i.attack();
		}
		return attackPoint;
	}

	public double defend() {//got the total defend point
		// TODO
		double defendPoint=0;
		for(ATK i:equipment)
		{
			defendPoint+=i.defend();
		}
		return defendPoint;
	}

	@Override
	public String toString() {
		return "Player [hp=" + hp + ", equipments=" + equipment + "]";
	}
}
