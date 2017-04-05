package pkgException;

import pkgPokerBLL.Hand;

public class HandException extends Exception{

	private Hand exHand;
	
	public HandException(Hand h) {
		super();
		this.exHand = h;
	}

	public Hand getExHand() {
		return exHand;
	}
	
}
