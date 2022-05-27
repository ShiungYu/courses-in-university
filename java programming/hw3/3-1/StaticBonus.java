
public class StaticBonus implements Bonus {//創造一個Bonus 介面的StaticBonus 類別

	@Override
	public int getBonus(int salary) {//bonus 為10000元
		return 10000;
	}

}
