public class HandOfCards {
    private Card[] cards;
    private CardType type;
    
    public void setter(Card[]cardss){//set the five card to the array
        this.cards=cardss;
        for(int i=0;i<cards.length;i++)//sort those five cards in order
        {
            for(int j=0;j<cards.length-1-i;j++)
            {
                if(cards[j].getPoint()>cards[j+1].getPoint())
                {
                    Card temp=cards[j];
                    cards[j]=cards[j+1];
                    cards[j+1]=temp;
                }
            }
        }
        if(cards.length==5)//if the cards size is 5
        {
            Card a=cards[0];
            Card b=cards[1];
            Card c=cards[2];
            Card d=cards[3];
            Card e=cards[4];
            if(a.getface()==b.getface()&&a.getface()==c.getface()&&a.getface()==d.getface()&&a.getface()==e.getface())
            {
                if(b.getPoint()==a.getPoint()+1&&c.getPoint()==b.getPoint()+1&&d.getPoint()==c.getPoint()+1&&e.getPoint()==d.getPoint()+1)
                {
                    //the condition of Straight_Flush
                    type=CardType.STRAIGHT_FLUSH;
                }
                type=CardType.NONE;
            }
            //the condition of Four_Of_A_Kind
            else if((a.getPoint()==b.getPoint()&&a.getPoint()==c.getPoint()&&a.getPoint()==d.getPoint())||(b.getPoint()==c.getPoint()&&b.getPoint()==d.getPoint()&&b.getPoint()==e.getPoint()))
            {
                type=CardType.FOUR_OF_A_KIND;
            }
            //the condition of Full_house
            else if((a.getPoint()==b.getPoint()&&c.getPoint()==d.getPoint()&&c.getPoint()==e.getPoint())||(a.getPoint()==b.getPoint()&&a.getPoint()==c.getPoint()&&d.getPoint()==e.getPoint()))
            {
                type=CardType.FULL_HOUSE;
            }
            //the condition of One_Pair
            else if(a.getPoint()==b.getPoint()||b.getPoint()==c.getPoint()||c.getPoint()==d.getPoint()||d.getPoint()==e.getPoint())
            {
                type=CardType.ONE_PAIR;
            }
            else
            {
                type=CardType.NONE;
            }
        }
        else{//if the cards size isn't 5
            type=CardType.NONE;
            for(int i=0;i<cards.length-1;i++)
            {
                if(cards[i]==cards[i+1])
                {
                    type=CardType.ONE_PAIR;
                }
            }
            
        }
    }

    public CardType getter()//get the type of those cards
    {
        return type;
    }

    public String toString()//retrun the name of the type
    {
        return type.getName();
    }
}

