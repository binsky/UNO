package uno.game.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import uno.game.cards.Card;
import uno.game.cards.Utils;
import uno.game.common.COLOR;
import uno.game.common.Quantities;
import uno.game.common.RANK;

//TEST COMMENT STRING
public class Deck extends Stack<Card> {
	
	private static final long serialVersionUID = 1L;
	
	private Stack<Card> discardPile = new Stack<>();
	
	public Deck() {
		createDeck();
	}
	
	public List<Card> getDiscardPile() {
		return discardPile;
	}
	
	private void createDeck() {
		createNewDeck();
	}
	
	private void createNewDeck() {
		createCards();
		shuffle(this);
	}
	

	@Deprecated
	private void createDeckFromPile(List<Card> pile) {
		shuffle(pile);
		addAll(pile);
	}

	private void createCards() {
		RANK ranks [] = RANK.values();
		Map<RANK, Integer> quantMap = Utils.getQuantitiesMap();

		for(int i = 0; i < ranks.length; i++) {
			RANK currentRank = ranks[i];
			for(int j = 0; j < quantMap.get(currentRank).intValue(); j++) {
				if(currentRank.value < 200) {
					push(createCard(COLOR.RED, currentRank));
					push(createCard(COLOR.GREEN, currentRank));
					push(createCard(COLOR.BLUE, currentRank));
					push(createCard(COLOR.YELLOW, currentRank));
				}
				else {
					push(createCard(COLOR.WILD, currentRank));
				}
			}
		}
	}

	private Card createCard(COLOR color, RANK rank) {
		return new Card(color, rank);
	}

	private void shuffle(Collection<Card> pile) {
		Collections.shuffle((List<Card>)pile);
	}

	public Card drawAndDiscard() {
		Card card = draw();
		
		discardPile.push(card);
		
		return card;
	}
	
	public Card draw() {
		if (isExhausted()) {
			reShuffle();
		}
		
		return pop();
	}
	
	public List<Card> draw(int amount) {
		List<Card> cards = new ArrayList<>();
		for(int i=0; i < amount; i++) {
			cards.add(draw());
		}
		
		return cards;
	}
	
	public void discard(Card card) {
		discardPile.push(card);
	}
	
	private void reShuffle() {
		shuffle(discardPile);
		addAll(discardPile);
		resetDiscardPile();
	}
	
	private boolean isExhausted() {
		return empty();
	}
	
	private void resetDiscardPile() {
		discardPile.clear();
	}
	
	@Deprecated
	public List<Hand> deal(int numberOfPlayers) {
		
		if(numberOfPlayers > Quantities.MAX_NUM_OF_PLAYERS) {
			return null;
		}
		
		List<Hand> hands = new ArrayList<>();
		
		for(int i = 0; i++ < numberOfPlayers;) {
			hands.add(new Hand());
		}
		
		for(int i = 0; i++ < Quantities.HAND_SIZE;) {
			for(Hand hand : hands) {
				hand.draw(draw());
			}
		}
		
		return hands;
	}
	
	@Deprecated
	public Card peekDiscardPile() {
		return discardPile.get(discardPile.size() - 1);
	}
}
