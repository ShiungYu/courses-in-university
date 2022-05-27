public class PokerGame {
	private DeckOfCards myDeckOfCards=new DeckOfCards();

	public PokerGame() {//contructor
		this.myDeckOfCards.shuffle();
	}
	
	public void dealFiveCards() {
		//int sum=0;
		//int currentPoint=0;
		Card temp=null;
		Card []cards=new Card[5];//create a new array in size 5
		System.out.printf("Your Cards:");
		for(int i=0;i<5;i++)
		{
			//try{
				temp=myDeckOfCards.dealCard();
				//currentPoint=temp.getPoint();
			//}
			//if less than five cards 
			if(temp==null)
			{
				//e.printStackTrace();

				System.out.printf("No card can be dealt, please restart the game!%n%n");
				return;
			}
			cards[i]=temp;
			//sum+=currentPoint;
		}
		try{
			for(int i=0;i<5;i++)//output the infrmation of every cards
			{
				
				temp=cards[i];
				if(i!=4)
				{
					System.out.printf(" %s,",temp.toString());
				}
				else
				{
					System.out.printf(" %s%n",temp.toString());
				}
			}	
		}	
		catch(NullPointerException e)//if less than five cards 
			{
				//e.printStackTrace();

				System.out.printf("No card can be dealt, please restart the game!%n%n");
				return;
			}
		//System.out.printf("Your total point is %d%n",sum);
		//New
		HandOfCards neww=new HandOfCards();
		neww=CardTypeHandler.produceHandOfCards(cards);
		System.out.printf("Card type: %s%n%n",neww.toString());
	}

} // end class PokerGame
