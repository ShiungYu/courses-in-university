public class CardTypeHandler {
    public static HandOfCards produceHandOfCards(Card[] cards)
    {
        HandOfCards Hand=new HandOfCards();
        Hand.setter(cards);//set the HandOfCards object
        return Hand;//and return it
    }
}
