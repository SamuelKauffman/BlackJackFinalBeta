import java.util.Scanner;
import java.lang.Thread;

public class App {
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		boolean playAgain = false;
		int extraCard;
		int twoCardTotal = 0;
do {
		

		Deck deck = new Deck();
		deck.setRank();
		deck.setSuit();
		deck.setOrder();
		deck.setValue();
		deck.shuffleCards();

		Hand playerHand = new Hand();
		Hand dealerHand = new Hand();

		System.out.println("Welcome to BlackJack!");
		System.out.println("\n");
		Thread.sleep(3000);
		System.out.println("Press S to start the game.");
		System.out.println("Press Q to close the game.");
		String input = scan.nextLine().toUpperCase();

		boolean validBet = true;
		BlackJack blackjack = new BlackJack();

		while (validBet) {
			System.out.println("How Much money do you want to bet? You have: $" + blackjack.getMoney());
			int bet = scan.nextInt();
			scan.nextLine();
			blackjack.setBet(bet);
			if (bet <= blackjack.getMoney() || bet >= 10) {
				validBet = false;
				switch (input) {
				case "S":
					input = "S"; //starts game

					// deal two cards to the player
					System.out.println("Dealers Shuffling the Cards");
					System.out.println("\n");
					Thread.sleep(3000);
					String playerCard1 = deck.getTopCard(0);
					int playerValue1 = deck.mValue[0];
					playerHand.addCard(playerCard1, playerValue1);
					String playerCard2 = deck.getTopCard(1);
					int playerValue2 = deck.mValue[1];
					playerHand.addCard(playerCard2, playerValue2);

					// deal two cards to the dealer
					String dealerCard1 = deck.getTopCard(2);
					int dealerValue1 = deck.mValue[2];
					dealerHand.addCard(dealerCard1, dealerValue1);
					String dealerCard2 = deck.getTopCard(3);
					int dealerValue2 = deck.mValue[3];
					dealerHand.addCard(dealerCard2, dealerValue2);
					twoCardTotal = dealerValue1 + dealerValue2;
					
					// display hands
					playerHand.displayHand();
					Thread.sleep(3000);
					dealerHand.displayDealersHand(twoCardTotal);
					System.out.println("\n");
					break;

				case "Q": //ends game
					input = "Q";
					System.exit(0);
					break;

				default: //if choice is not in switch case
					System.out.println("This choice is invalid!");
					break;
				}
			}
		}

		String input2;
		
			do {
				int round = playerHand.getHandSize();
				Thread.sleep(3000);
				System.out.println("Press H to hit.");
				System.out.println("Press S to Stand.");
				System.out.println("Press Q to quit");
				input2 = scan.nextLine().toUpperCase();

				boolean again;

				switch (input2) {
				case "H":
					input2 = "H";

					String playerCard3 = deck.getTopCard(round);
					int playerValue3 = deck.mValue[round];
					playerHand.addCard(playerCard3, playerValue3);
					playerHand.displayHand();

					round = round + 1;

					Thread.sleep(3000);
					if (dealerHand.getValue() < 16) { // If dealers hand value is < 16, he hits
						
						extraCard =+ 1;
						round = round + 1;
						
						String dealerCard3 = deck.getTopCard(round);
						int dealerValue3 = deck.mValue[round];
						dealerHand.addCard(dealerCard3, dealerValue3);
						System.out.println("Dealer hit.");
						dealerHand.displayDealersHand(twoCardTotal);
						System.out.printf("Plus %s more card", extraCard);
						System.out.println("\n");
						
					} else {
						dealerHand.displayDealersHand(twoCardTotal);
						System.out.println("Dealer did not hit");
						System.out.println("\n");
					}
					break;
				case "S":
					input2 = "S";
					while(dealerHand.getValue() < 16) {
						
						extraCard =+ 1;
						round = round + 1;
						
						String dealerCard3 = deck.getTopCard(round);
						int dealerValue3 = deck.mValue[round];
						dealerHand.addCard(dealerCard3, dealerValue3);
						System.out.println("Dealer hit.");
						dealerHand.displayDealersHand(twoCardTotal);
						System.out.printf("Plus %s more card", extraCard);
						System.out.println("\n");
						
					} 
					blackjack.WinLose(playerHand.getValue(), dealerHand.getValue());
					System.out.println("Your money is now $" + blackjack.getMoney());
					playAgain = true;
					continue;
				case "Q":
					input2 = "Q";
					again = false;
					return;

				default:
					System.out.println("This choice is invalid!");
					break;
				}
			} while (input2 == "H" && playerHand.getValue() <= 21 && dealerHand.getValue() <= 21 || input2 == "S" && playerHand.getValue() <= 21 && dealerHand.getValue() <= 21);
				
		
		if (playerHand.getValue() > 21) { // Does not really work
			blackjack.win = false;
			System.out.println("You bust!");
			blackjack.Bust(playerHand.getValue());
			System.out.printf("Your money is now, %s$.", blackjack.getMoney());
			playAgain = true;
			break;
		} else if (dealerHand.getValue() > 21) {
			blackjack.win = true;
			System.out.println("Dealer bust!");
			blackjack.Bust(playerHand.getValue());
			System.out.printf("Your money is now, %s$.", blackjack.getMoney());
			 break;
		} 
		playAgain = true;
		
	}while(playAgain == true);

	}
}
