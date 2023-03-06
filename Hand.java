
public class Hand extends Deck {
	private int handValue;
	private String handCard;
	private int dealerHandValue;
	private String dealerHandCard;

	public Hand() {
		super();
		handValue = 0;
		handCard = "";
		dealerHandValue = 0;
		dealerHandCard = "";

	}

	public Hand(String[] suit, String[] rank, String[] deck, String handCard, int handValue, int dealerHandValue,
			String dealerHandCard, String topCard) {
		super(suit, rank, deck, topCard);
		this.handValue = handValue;
		this.handCard = handCard;
		this.dealerHandValue = dealerHandValue;
		this.dealerHandCard = dealerHandCard;
	}

	public String getHandCard() { //do all these getters and setters after topCard method
		return handCard;
	}

	public void setHandCard(String handCard) {
		this.handCard = handCard;
	}

	public int getHandValue() {
		return handValue;
	}

	public void setHandValue(int handValue) {
		this.handValue = handValue;
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
