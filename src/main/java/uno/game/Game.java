package uno.game;

import java.util.ArrayList;
import java.util.List;

import uno.game.cards.Card;
import uno.game.cards.Deck;
import uno.game.cards.Utils;
import uno.game.common.Quantities;
import uno.game.common.RANK;

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
//		Utils.consoleOutputDeck(deck);
		
		Player p;
		
		boolean gameOver = false;
		
		while(!gameOver)
			
		{
			deck.drawAndDiscard();
			Card lastDiscarded = deck.peekDiscardPile();
			if(lastDiscarded.getRank() == RANK.REVERSE) {
				queue.reverse();
				System.out.println("REVERSE");
			}
			else if(lastDiscarded.getRank() == RANK.SKIP) {
				queue.getNextPlayer();
				System.out.println("SKIP");
			}
			else if(lastDiscarded.getRank() == RANK.DRAW2) {
				queue.getNextPlayer().draw(deck.draw(2));
				System.out.println("DRAW2");
			}
			p = queue.getNextPlayer();
			System.out.println(p.getName());
			p.setHandAvailability(lastDiscarded);
			move(p);
			gameOver = gameOver(p);
			if(gameOver) {
				System.out.println("THE WINNER IS " + p.getName() + "!\n");
			}
		}
		
//		Utils.consoleOutputDeck(deck);
		
	}
	
	private void move(Player player) {
		Card card = player.getAvailableCard();
		if(card != null) {
			deck.discard(player.discard(card));
			return;
		}
		card = deck.draw();
		player.draw(card);
		if(player.checkCardAvailability(card, deck.peekDiscardPile())) {
			player.discard(card);
		}
		return;
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
