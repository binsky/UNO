package uno.game;

import java.util.List;

import uno.game.cards.Card;
import uno.game.cards.Hand;

public class Player {
	private String name;
	private Hand hand;
	
	public Player(String name) {
		this.name = name;
		this.hand = new Hand();
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void draw(Card card) {
		hand.draw(card);
	}
	
	public void draw(List<Card> cards) {
		hand.draw(cards);
	}
	
	//TEST
	public Card discard() {
		return hand.discard();
	}
	
	public boolean isHandEmpty() {
		return hand.isHandEmpty();
	}
	
	public void setHandAvailability(Card discardedCard) {
		hand.setHandAvailability(discardedCard);
	}
	
	//TEST
	public Card getAvailableCard() {
		for(Card card : hand.getHand()) {
			if(card.isAvailable())
				return card;
		}
		return null;
	}
	
	public Card discard(Card card) {
		return hand.discard(card);
	}
	
	public boolean checkCardAvailability(Card card, Card discardedCard) {
		return hand.checkAndSetCardAvailability(card, discardedCard);
	}
}
