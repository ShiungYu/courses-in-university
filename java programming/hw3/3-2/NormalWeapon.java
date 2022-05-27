public class NormalWeapon extends Weapon {//Weapon 的subclass
    
    public NormalWeapon(double offense, double defense) {//contructor
        super(offense,defense);//superclass contructor
	}

    public double attack()
    {
        return getOffense();
    }

    public String getName()
    {
        return "NormalWeapon";
    }
}
