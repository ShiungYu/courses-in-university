
public class PokerGame {
	private DeckOfCards myDeckOfCards=new DeckOfCards();

	public PokerGame() {
		this.myDeckOfCards.shuffle();
	}
	
	public void dealFiveCards() {
		int sum=0;
		int currentPoint=0;
		Card temp=null;
		for(int i=0;i<5;i++)
		{
			try{
				temp=myDeckOfCards.dealCard();
				currentPoint=temp.getPoint();
			}
			catch(NullPointerException e)
			{
				//e.printStackTrace();
				System.out.printf("No card can be dealt, please restart the game!%n%n");
				return;
			}
			sum+=currentPoint;
			System.out.printf("You got %s, point is %d%n",temp.toString(),currentPoint);
		}
		System.out.printf("Your total point is %d%n%n",sum);
	}

} // end class PokerGame
