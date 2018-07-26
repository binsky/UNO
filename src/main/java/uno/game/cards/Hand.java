package uno.game.cards;

import java.util.ArrayList;
import java.util.List;

import uno.game.common.COLOR;

public class Hand {
	
	private List<Card> hand = new ArrayList<Card>();
	
	public Hand() {}
	
	public Card get(int index) {
		return hand.get(index);
	}
	
	@Deprecated
	public List<Card> getHand() {
		return hand;
	}
	
	public Hand(List<Card> hand) {
		this.hand = hand;
	}
	
	public void draw(Card card) {
		hand.add(card);
	}
	
	public void draw(List<Card> cards) {
		hand.addAll(cards);
	}
	
	public Card discard(Card card) {
		hand.remove(card);
		return card;
	}
	
	public void printHand() {
		System.out.println(hand);
	}
	
	public void setHandAvailability(Card discardedCard) {
		for (Card currentCard : hand) {
			if (currentCard.getColor() == COLOR.WILD ||
					currentCard.getColor() == discardedCard.getColor() ||
					currentCard.getRank() == discardedCard.getRank()) {
				currentCard.setAvailable(true);
			}
			else currentCard.setAvailable(false);
		}
	}
}
