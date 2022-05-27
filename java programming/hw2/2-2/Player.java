import java.util.*;
public class Player {

	public static final long MAX_HP = 10000000000L;//maxHp
	public static final long MIN_HP = 9000000000L;//minHp

	private final String name;
	private long hp;
	private Weapon[] myWeapon = new Weapon[3];//three weapon

	public Player(String name) {//contructor
		// TODO
		this.name=name;
		Random randomno=new Random();
        hp=(long)(randomno.nextFloat()*1000000000);
        hp+=9000000000L;//determine Hp
        //attackPoint=(int)(randomno.nextFloat()*100000000+100000000);
	}

	public String getName() {//get the name of player
		// TODO
		return name;
	}

	public long getHp() {//get the Hp of player
		// TODO
		return hp;
	}

	public void setHp(long newHp) {//set the new Hp of player
		// TODO
		if(newHp<0)//hp cannot less than 0
        {
            hp=0;
        }
        else
        {
            hp=newHp;
        }
	}

	public void makeWeapon() {//make a weapon
		// TODO
		for(int i=0;;i++)
		{
			try{
				if(myWeapon[i]==null)//if the index of weapon haven't be make
				{
					myWeapon[i]=new Weapon();
					System.out.printf("%s makes a weapon with offense %d%n",name,myWeapon[i].getOffense());
					break;
				}
				
			}
			catch(ArrayIndexOutOfBoundsException e)//if the weapon array is full
			{
				System.out.printf("%s cannot make weapons now!!%n",name);
				return;
			}
		}
	}

	public void cloneWeapon() {
		// TODO
		for(int i=0;;i++)
		{
			try{
				if(myWeapon[i]==null)//if the index of the weapon haven't be made
				{
					System.out.printf("%s clones a weapon with offense %d%n",name,myWeapon[i-1].getOffense());
					myWeapon[i]=new Weapon(myWeapon[i-1]);
					System.out.printf("%s's weapon#%d becomes: a weapon with offense %d%n",name,i,myWeapon[i].getOffense());
					break;
				}
				
			}
			catch(ArrayIndexOutOfBoundsException e)//index out of bound
			{
				if(i==0)//if i=0,instead of cloning a weapon, make a weapon 
				{
					makeWeapon();
				}
				else//the weapon array is full
				{			
					System.out.printf("%s cannot make weapons now!!%n",name);
				}
				return;
			}
		}
	}

	public int getAttack() {//get the total of attackpoints and return
		// TODO
		int sum=0;
		for(int i=0;i<myWeapon.length;i++)
		{
			sum+=myWeapon[i].getOffense();
		}
		return sum;
	}
}
