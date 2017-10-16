package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;



public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	//it throws an exception if the deck is empty
	public Card Draw() throws DeckException {
		if (this.cardsInDeck.size() == 0) {
			throw new DeckException(this);
		}
		
		
		return cardsInDeck.remove(0);
	}
	
	//Draw a card of a given eSuit
	public Card DrawSuit(eSuit eSuit) {
		for (Card card : this.cardsInDeck) {
			if (card.geteSuit() == eSuit) {
				cardsInDeck.remove(card);
				return (card);
			}
		}
		return null;
	
	}
	public Card DrawRank(eRank eRank) {
		for (Card card : this.cardsInDeck) {
			if (card.geteRank() == eRank) {
				cardsInDeck.remove(card);
				return (card);
			}
		}
		return null;
	}

	// return the number of a given eSuit left in the deck.
	public int countSuit(eSuit eSuit) {
		ArrayList<Card> eSuitLeft = cardsInDeck.stream().filter(c -> c.geteSuit() == eSuit)
				.collect(Collectors.toCollection(ArrayList::new));

		return eSuitLeft.size();
	}

	// return the number of a given eRank left in the deck.
	public int countRank(eRank eRank) {
		ArrayList<Card> eRankLeft = cardsInDeck.stream().filter(c -> c.geteRank() == eRank)
				.collect(Collectors.toCollection(ArrayList::new));

		return eRankLeft.size();
	}

	// return 0 or 1 if a given card is left in the deck.
	public int FindCard(Card c) {
		for (Card cards : cardsInDeck) {
			if (cards == c)
				return 1;
		}
		return 0;
	}
}

	
	
	