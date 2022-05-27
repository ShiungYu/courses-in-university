
public class DynamicBonus implements Bonus {//創造一個Bonus 介面的DynamicBonus 類別

	@Override
	public int getBonus(int salary) {//bonus 為薪水的10%
		// TODO
		return (int)(salary*0.1);
	}

}
