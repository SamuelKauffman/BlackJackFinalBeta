import java.util.ArrayList;

public class Hand {
    private ArrayList<String> mCards;
    private int mTotalValue;
    
    public Hand() {
        mCards = new ArrayList<String>();
        mTotalValue = 0;
    }
    
    public void addCard(String card, int value) {
        mCards.add(card);
        mTotalValue += value;
    }
    
    public int getValue() {
    	return mTotalValue;
    }
    
    public void displayHand() {
        System.out.println("Your Hand: ");
        for (String card : mCards) {
            System.out.println(card);
        }
        System.out.println("Total value: " + mTotalValue);
    }
    public void displayDealersHand() {
    	System.out.println("Dealers Hand: ");
        for (int i = 0; i < 2 && i < mCards.size(); i++) {
            System.out.println(mCards.get(i));
        }
        System.out.println("Total value: " + mTotalValue);
    }
}