
public class BlackJack extends Hand {
	private int bet;
	private int money;
	private boolean win;

	public BlackJack() {
		super();
		bet = 10;
		money = 100;
	}

	public BlackJack(String[] suit, String[] rank, String[] deck, int[] value, String handCard, int handValue, int dealerHandValue,
			String dealerHandCard, int bet, int money, String topCard) {
		super(suit, rank, deck, value, handCard, handValue, dealerHandValue, dealerHandCard, topCard);
		this.bet = bet;
		this.money = money;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		if (bet >= 10 && bet <= money) {
			this.bet = bet;
		} else if (bet < 10) {
			System.out.println("Minimum bet is $10");
		} else if (bet > money) {
			System.out.println("You do not have enough money for this bet");
		} else {
			System.out.println("You need at least 10$ to place a bet");
		}
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		if (win == true) {
			money = bet * 2 + money;
		}
		if (win == false) {
			money = money - bet;
		}
		this.money = money;
	}

	public void WinLose() { //finish this after topCard method, getters and setters in hand
		if (handValue > 21 && dealerHandValue) {
			
		}
	}
}
