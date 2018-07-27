package uno.game;

import java.util.ArrayList;
import java.util.List;


import uno.game.cards.Deck;
import uno.game.cards.Utils;
import uno.game.common.Quantities;

public class Game {
	private List<Player> players = new ArrayList<Player>();
	private Deck deck = new Deck();
//	private boolean clockwise = true;
	
	public void startGame(int numberOfPlayers) {
		createPlayers(numberOfPlayers);
		
		deal();

		test();
	}
	
	private void createPlayers(int numberOfPlayers) {
		for(int i = 0; i++ < numberOfPlayers;) {
			players.add(new Player("Player_" + i));
		}
	}

	private void deal() {
		for(int i = 0; i++ < Quantities.HAND_SIZE;) {
			for(Player player : players) {
				player.draw(deck.draw());
			}
		}
	}
	
	private void test() {
		Utils.consoleOutputDeck(deck);
		
		deck.draw(deck.size() - 10);
		
		Utils.consoleOutputDeck(deck);
		
		for(int i = 0; i++ < 10;) {
			deck.drawAndDiscard();
		}
		
		Utils.consoleOutputDeck(deck);
		
		deck.draw();
		
		Utils.consoleOutputDeck(deck);
	}
	
	private void setPlayersHandAvailability(Player player) {
		player.getHand().setHandAvailability(deck.getDiscardPile().peek());
	}
	
	private void discard(Player player) {
		deck.discard(player.getHand().discard(player.getHand().get(0)));
	}
}
