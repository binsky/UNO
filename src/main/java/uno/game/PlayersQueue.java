package uno.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class PlayersQueue {
	
	private Deque<Player> queue = new ArrayDeque<>();
	private boolean clockwise = true;
	private Iterator<Player> currentPlayer;
	
	public PlayersQueue(List<Player> players) {
		queue.addAll(players);
		currentPlayer = queue.iterator();
	}
	
	public boolean isClockwise() {
		return clockwise;
	}
	
	public void reverse() {
		clockwise = !clockwise;
	}
	
	public Player getNextPlayer() {
		if(clockwise) {
			return currentPlayer.hasNext() ? currentPlayer.next() : queue.getFirst();
		}
		else {
//			return currentPlayer.hasPrevious() ? currentPlayer.previous() : queue.getLast();
		}
				
		return null;
	}
	
}
