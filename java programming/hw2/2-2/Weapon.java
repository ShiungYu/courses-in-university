import java.util.*;
public class Weapon {
	
	public static int MAX_VALUE = 200000000;
	private int offense;

	private static int generateRandomOffense()//generate the offense of every weapon 
	{
		Random randomno=new Random();
		return (int)(randomno.nextFloat()*100000000+100000000);
	}

	public Weapon() {
		// TODO
		offense=generateRandomOffense();
	}

	public Weapon (Weapon weapon) {//if the contructor is weapon , the offense of weapon should be 90% of original weapon
		// TODO
		offense=(int)(weapon.offense*0.9);		
	}

	public Weapon(int offense) {
		if ((0 < offense) && (offense <= MAX_VALUE)) {
			this.offense = offense;
		}
	}

	public int getOffense() {//get the offense of this weapon
		return offense;
	}

	public void setOffense(int offense) {//set the offense of the weapon
		if ((0 < offense) && (offense <= MAX_VALUE)) {
			this.offense = offense;
		}
	}

	@Override
	public String toString() {
		return String.format("a weapon with offense %,d", offense);
	}
}
