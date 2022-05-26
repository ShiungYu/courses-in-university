
public class Card {
	private final String face; // face of card ("Ace", "Deuce", ...)
	private final String suit; // suit of card ("Hearts", "Diamonds", ...)

	// two-argument constructor initializes card's face and suit
	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}

	// return String representation of Card
	public String toString() {
		return face + " of " + suit;
	}

	public int getPoint() {
		int index = -1;
		for(int i=0;i<13;i++)
		{
			if(face==DeckOfCards.faces[i])
			{
				index=i+1;
			}
		}
		if(index==1)
		{
			index+=19;
		}		
		return index;
	}

} // end class Card

