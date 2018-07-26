package uno.game.cards;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uno.game.cards.Deck;
import uno.game.common.Quantities;
import uno.game.common.RANK;

public class Utils {
	
	public static Map<RANK, Integer> getQuantitiesMap() {
		Map<RANK, Integer> quantMap = new HashMap<RANK, Integer>();
		
		RANK ranks [] = RANK.values();
		
		for(int i=0; i<ranks.length; i++) {
			if(ranks[i] == RANK.ZERO) {
				quantMap.put(ranks[i], Quantities.ZEROS_PER_COLOR);
			}
			else if (ranks[i] == RANK.SWAP){
				quantMap.put(ranks[i], Quantities.SWAP_WILD);
			}
			else if(ranks[i].value < 200) {
				quantMap.put(ranks[i], Quantities.OTHER_PER_COLOR);
			}
			else {
				quantMap.put(ranks[i], Quantities.OTHER_WILD);
			}
		}
		
		return quantMap;
	}
	
	public static void consoleOutputDeck(Deck deck) {
		
		//deck
		System.out.println("\n______________________________________");
		System.out.println("Deck Size: " + deck.size() + "\n\nDeck:");
		
		for(Card card : deck) {
			System.out.println(card.toString());
		}
		System.out.println("\n______________________________________");
		
		//discard
		List<Card> dp = deck.getDiscardPile();
		if(!dp.isEmpty()) {
			System.out.println("Discard Size: " + dp.size() + "\n\nDiscard Pile:");
			for(Card card : dp) {
				System.out.println(card.toString());
			}
			System.out.println("______________________________________\n\n");
		}
		else {
			System.out.println("Discard pile is EMPTY");
			System.out.println("______________________________________\n\n");
		}
	}
}
