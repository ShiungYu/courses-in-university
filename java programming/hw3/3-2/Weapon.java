public abstract class Weapon implements ATK {//抽象父類別Weapon

	public static double MAX_VALUE = 255;
	private double offense;
	private double defense;

	public Weapon(double offense, double defense) {//contructor
		if ((0 < offense) && (offense < MAX_VALUE))
			this.offense = offense;
		else
			this.offense = 0;

		if ((0 < defense) && (defense < MAX_VALUE))
			this.defense = defense;
		else
			this.defense = 0;
	}

	public double getOffense() {//get the offense
		return offense;
	}

	public void setOffense(double offense) {//set the offense
		if ((0 < offense) && (offense < MAX_VALUE))
			this.offense = offense;
		else
			this.offense = 0;
	}

	public double getDefense() {//get the defense
		return defense;
	}

	public void setDefense(double defense) {//set the defense
		if ((0 < defense) && (defense < MAX_VALUE))
			this.defense = defense;
		else
			this.defense = 0;
	}

	@Override
	public double defend() {
		return getDefense();
	}

	@Override
	public String toString() {
		return "Weapon [offense=" + offense + ", defense=" + defense + "]";
	}
}
