public class PowerWeapon extends Weapon {//Weapon's subclass
    private int time;

    public PowerWeapon(double offense, double defense) {//contructor
        super(offense,defense);//superclass contructor
        time=0;
	}

    public double attack()
    {
        time++;
        return getOffense()*Math.pow(1.2,time);//everytime attackPoint will be 1.2??
        
    }

    public String getName()
    {
        return "PowerWeapon";
    }
}
