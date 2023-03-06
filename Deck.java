import java.util.Random;

public class Deck {
	private String[] mSuit;
	private String[] mRank;
	private String[] mDeck;
	private String mTopCard;

	public Deck() {
		mSuit = new String[4];
		mRank = new String[13];
		mDeck = new String[52];
		mTopCard = "";
	}

	public Deck(String[] suit, String[] rank, String[] deck, String topCard) {
		mSuit = suit;
		mRank = rank;
		mDeck = deck;
		mTopCard = topCard;
	}

	public void setRank() {
		String[] rankArray = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		mRank = rankArray;
	}

	public void setSuit() {
		String[] suitArray = { "Clubs", "Diamonds", "Hearts", "Spades" };
		mSuit = suitArray;
	}

	public void setOrder() {
		String[] deck = new String[52];
		for (int i = 0; i < mRank.length; i++) {
			for (int n = 0; n < mSuit.length; n++) {
				deck[mSuit.length * i + n] = mRank[i] + " of " + mSuit[n];
				mDeck = deck;
			}
		}
	}

	public void getOrder() {
		for (int i = 0; i < mDeck.length; i++) {
			System.out.println(mDeck[i]);
		}
	}

	public void shuffleCards() {
		for (int i = 0; i < mDeck.length; i++) {
			Random shuffle = new Random();
			int newIndex = shuffle.nextInt(mDeck.length);
			String randomCard = mDeck[newIndex];
			mDeck[newIndex] = mDeck[i];
			mDeck[i] = randomCard;
		}
	}

	public void getShuffledCards() {
		for (int i = 0; i < mDeck.length; i++) {
			System.out.println(mDeck[i]);
		}
	}
	public String getTopCard(int hit) {
		mTopCard = mDeck[hit - 1];
		return mTopCard;
	}
	public void setValue() {
		int i = 0;
		while(i < 53) {
			i+=4;
			System.out.println(i);
		}
	}
}
