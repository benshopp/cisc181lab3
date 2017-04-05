package pkgException;

import pkgPokerBLL.Deck;

public class DeckException extends Exception{

	private Deck exDeck;
	
	public DeckException(Deck d) {
		super();
		this.exDeck = d;
	}

	public Deck getExDeck() {
		return exDeck;
	}

}
