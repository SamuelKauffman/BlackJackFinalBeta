
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck deck = new Deck();
		BlackJack blackjack = new BlackJack();
		Hand hand = new Hand();
		//Setting their rank and suit
		deck.setRank();
		deck.setSuit();
		//testing Order card + cardValue
		deck.setOrder();
		deck.setValue();
		//testing Shuffle
		deck.shuffleCards();
		deck.getShuffledCards();
		//testing Bet and money system
		blackjack.setBet(10);
		System.out.println(blackjack.getBet());
		System.out.println(blackjack.getMoney());
		//testing drawing
		System.out.println(deck.getTopCard(1));
		System.out.println(deck.getTopCard(2));
		System.out.println(deck.getTopCard(3));
		//testing hand class
		//hand.setHandCard(1);
		//System.out.println(hand.getHandCard());
	}

}
