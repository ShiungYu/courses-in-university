
import java.util.*;
public class Player {
    private long hp;
    private int attackPoint;

    public Player()
    {
        Random randomno=new Random();
        hp=(long)(randomno.nextFloat()*1000000000);
        hp+=9000000000L;
        attackPoint=(int)(randomno.nextFloat()*100000000+100000000);
    }

    public void attack(Player enemy)
    {
        enemy.setHp(enemy.hp-attackPoint);
    }

    public long getHp()
    {
        return hp;
    }

    public int getAttackPoints()
    {
        return attackPoint;
    }

    public void setHp(long newHp)
    {
        if(newHp<0)
        {
            hp=0;
        }
        else
        {
            hp=newHp;
        }
    }
}
