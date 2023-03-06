
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck deck = new Deck();
		BlackJack blackjack = new BlackJack();
		
		deck.setRank();
		deck.setSuit();
		
		deck.setOrder();
		
		deck.shuffleCards();
		deck.getShuffledCards();
		
		blackjack.setBet(10);
		System.out.println(blackjack.getBet());
		System.out.println(blackjack.getMoney());
		
		
		System.out.println(deck.getTopCard(1));
		System.out.println(deck.getTopCard(2));
		System.out.println(deck.getTopCard(3));
		deck.setValue();
	}

}
