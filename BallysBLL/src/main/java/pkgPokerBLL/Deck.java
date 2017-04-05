package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

import pkgException.DeckException;

public class Deck {

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	int JokerCount = 0;
	
	public Deck() {

		super();
		int iCardNbr = 0;
		for (eSuit suit : eSuit.values()) {
			for (eRank rank : eRank.values()) {
				//if ((suit != eSuit.JOKER) && (rank != eRank.JOKER)) {
					DeckCards.add(new Card(rank, suit, ++iCardNbr));
				//}
			}
		}
		Collections.shuffle(DeckCards);
	}
	
	/**
	 * passes an int, the number of jokers desired in the deck
	 */
	public Deck(int iJokers)
	{
		this();
		this.JokerCount = iJokers;
		
		for (int i = 0; i < iJokers; i++)
		{
			DeckCards.add(new Card(eRank.JOKER, eSuit.JOKER, 53 + i));
		}
		
	}
	
	public Deck (int NbrOfJokers, ArrayList<Card> wilds)
	{
		this(NbrOfJokers);
		
		for (Card cardW: wilds){
			for (Card cardD: this.DeckCards){
				if ((cardW.geteSuit()==cardD.geteSuit())& (cardW.geteRank()==cardD.geteRank())){
					cardD.setIsWild(true);
				}
			}
		}
		
	}

	public Card DrawCard() throws DeckException{
		try
		{
			if (DeckCards.size() == 0)
			{
				throw new DeckException(this);
			}
		}
		catch (DeckException e)
		{
			System.out.println("DeckException thrown : Deck empty");
		}
		return DeckCards.remove(0);
	}
	
}