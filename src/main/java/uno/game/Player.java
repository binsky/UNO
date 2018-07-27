package uno.game;

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
	
	public Card discard() {
		return hand.discard();
	}
	
	public boolean isHandEmpty() {
		return hand.isHandEmpty();
	}
}
