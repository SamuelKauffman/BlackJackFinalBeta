
public class Hand extends Deck {
	private int handValue;
	private String[] handCard;
	private int dealerHandValue;
	private String dealerHandCard;

	public Hand() {
		super();
		handValue = 0;
		dealerHandValue = 0;
		handCard = new String[5];
		dealerHandCard = "";

	}

	public Hand(String[] suit, String[] rank, String[] deck, int[] value, String[] handCard, int handValue, int dealerHandValue,
			String dealerHandCard, String topCard) {
		super(suit, rank, deck, value, topCard);
		this.handValue = handValue;
		this.handCard = handCard;
		this.dealerHandValue = dealerHandValue;
		this.dealerHandCard = dealerHandCard;
	}

	public String getHandCard() { //do all these getters and setters after topCard method
		return this.handCard[0];
	}

	public void setHandCard(int hit) {
		Deck deck = new Deck();
		deck.setRank();
		deck.setSuit();
		deck.setOrder();
		deck.shuffleCards();
		String card = deck.getTopCard(hit);
		this.handCard[0] = card;
	}

	public int getHandValue() {
		return handValue;
	}

	public void setHandValue(int hit) {
		int handValue = deck.getTopCard(hit);
		this.handValue = hit;
	}

	public int getDealerHand() {
		return dealerHandValue;
	}

	public void setDealerHand(int dealerHand) {
		this.dealerHandValue = dealerHand;
	}
	public String getDealerHandCard() {
		return dealerHandCard;
	}

	public void setDealerHandCard(String dealerHandCard) {
		this.dealerHandCard = dealerHandCard;
	}

}
