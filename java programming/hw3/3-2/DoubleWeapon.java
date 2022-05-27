
import java.security.SecureRandom;
public class DoubleWeapon extends Weapon {//Weapon 的subclass
    public DoubleWeapon(double offense, double defense) {//contructor
        super(offense,defense);//superclass contructor
	}

    public double attack()//concrete method
    {
        SecureRandom i=new SecureRandom();
        int chance=i.nextInt(5);
        if(chance%5!=0)
            return getOffense();
        else//20% attackpoint*2
            return getOffense()*2;
    }

    public String getName()
    {
        return "DoubleWeapon";
    }
}
