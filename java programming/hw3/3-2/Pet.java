
import java.security.SecureRandom;

public class Pet implements ATK {//ATK 介面下的Pet類別
	private int maxAttack;

	public Pet(int maxAttack) {//contructor
		if (maxAttack > 0) {
			this.maxAttack = maxAttack;
		}
	}

	@Override
	public double attack() {
		// TODO
		SecureRandom ran=new SecureRandom();//random
		return ran.nextInt(maxAttack);//attackpoint<=maxAttack
	}

	@Override
	public double defend() {//pet doesn't have defendPoint
		// TODO
		return 0;
	}

	public String getName()
    {
        return "Pet";
    }
}
