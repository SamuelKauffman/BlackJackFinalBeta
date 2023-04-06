import java.util.Scanner;
import java.lang.Thread;

public class App {
    public static void main(String[] args) throws InterruptedException {
    	Scanner scan = new Scanner(System.in);
    	
    	Deck deck = new Deck();
        deck.setRank();
        deck.setSuit();
        deck.setOrder();
        deck.setValue();
        deck.shuffleCards();
        
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
    	
        System.out.println("Welcome to BlackJack!");
        Thread.sleep(3000);
        System.out.println("Press S to start the game.");
        System.out.println("Press Q to close the game.");
        String input = scan.nextLine().toUpperCase();
        
        boolean validBet = true;
        BlackJack blackjack = new BlackJack();
        
        while(validBet) {
        	System.out.println("How Much money do you want to bet? You have: $" + blackjack.getMoney());
            int bet = scan.nextInt();
            scan.nextLine();
            blackjack.setBet(bet);
            if(bet <= blackjack.getMoney() && bet >= 10) {
            validBet = false;
			switch(input) {
            case "S" : input = "S";
            
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
            
            // display hands
            playerHand.displayHand();
            Thread.sleep(3000);
            dealerHand.displayDealersHand();
            System.out.println("\n");
            break;
           
            case "Q" : input = "Q";
            	System.exit(0);
            	break;
            	
            default: //this messes up your bet
            	System.out.println("This choice is invalid!");
            	return;
            }
            }
        }
       
        
            
        
            String input2;
            if(playerHand.getValue() > 21) { //put switch case in if statement
            	System.out.println("BUST");
            }
            do { 
            Thread.sleep(3000);
            System.out.println("Press H to hit.");
            System.out.println("Press S to Stand.");
            System.out.println("Press Q to quit");
            input2 = scan.nextLine().toUpperCase();
            
            boolean again;
            
            switch(input2) {
            	case "H" : input2 = "H";
            	
            	int round = playerHand.getHandSize();
            	
            	String playerCard3 = deck.getTopCard(round);
                int playerValue3 = deck.mValue[round];
                playerHand.addCard(playerCard3, playerValue3);
                playerHand.displayHand();
                
                round = round +1;
                
                Thread.sleep(3000);
                if(dealerHand.getValue() < 16) { //If dealers hand value is < 16 
                	String dealerCard3 = deck.getTopCard(5);
                	int dealerValue3 = deck.mValue[5];
                	dealerHand.addCard(dealerCard3, dealerValue3);
                	System.out.println("Dealer hit.");
                	dealerHand.displayDealersHand();
                	System.out.println("Plus 1 more card");
                	System.out.println("\n");
             
                	round = round + 1;
                }
                else {
                	dealerHand.displayDealersHand();
                	System.out.println("Dealer did not hit");
                	System.out.println("\n");
                }
                break;
            	case "S" : input2 = "S";
            	
            	break;
            	case "Q" : input2 = "Q";
            	again = false;
            		return;
            	
            	default: 
            		System.out.println("This choice is invalid!");
                	return;
            	}
            }
            while(input2 == "H");
            
        
        
        }
        
    }



