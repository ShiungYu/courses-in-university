public enum CardType {
	NONE("None"), ONE_PAIR("One Pair"), FULL_HOUSE("Full House"), FOUR_OF_A_KIND("Four of a Kind"), STRAIGHT_FLUSH(
			"Straight Flush");

	private final String name;

	private CardType(String name) {
		this.name = name;
	}

	public String getName() {//the function which can output the name of the type
		return name;
	}
}