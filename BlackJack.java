
public class BlackJack extends Hand {
	private int bet;
	private int money;
	private boolean win;

	public BlackJack() {
		bet = 10;
		money = 100;
	}

	public BlackJack(int bet, int money, String topCard) {
		this.bet = bet;
		this.money = money;
	}

	public int getBet() {
		return this.bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
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

	public void WinLose() { //Make this take in 2 getValue methods, compare the 2 values and whoever is greater but under 21, wins
		if (handValue > 21 && dealerHandValue) {
			
		}
	}
}
