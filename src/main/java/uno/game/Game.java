package uno.game;

import java.util.ArrayList;
import java.util.List;


import uno.game.cards.Deck;
import uno.game.cards.Utils;
import uno.game.common.Quantities;

public class Game {
	PlayersQueue queue;
	private Deck deck = new Deck();
	
	public void startGame(int numberOfPlayers) {
		createPlayers(numberOfPlayers);
		
		deal();

		test();
	}
	
	private void createPlayers(int numberOfPlayers) {
		List<Player> players = new ArrayList<Player>();
		for(int i = 0; i++ < numberOfPlayers;) {
			players.add(new Player("Player_" + i));
		}
		queue = new PlayersQueue(players);
	}

	private void deal() {
		for(int i = 0; i++ < Quantities.HAND_SIZE;) {
			for(Player player : queue) {
				player.draw(deck.draw());
			}
		}
	}
	
	private void test() {
		Utils.consoleOutputDeck(deck);
		
		Player p = queue.getNextPlayer();
		
		while(!gameOver(p))
		{
			deck.discard(p.discard());
			System.out.println(p.getName());
			p = queue.getNextPlayer();
//			System.out.println(p.discard());
		}
		
		Utils.consoleOutputDeck(deck);
	}
	
	private boolean gameOver(Player player) {
		return player.isHandEmpty();
	}

	private void setPlayersHandAvailability(Player player) {
		player.getHand().setHandAvailability(deck.getDiscardPile().peek());
	}
	
	private void discard(Player player) {
		deck.discard(player.getHand().discard(player.getHand().get(0)));
	}
}
