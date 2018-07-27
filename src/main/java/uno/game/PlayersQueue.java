package uno.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//need to implement getFirst / getLast
public class PlayersQueue {
	
	private List<Player> queue = new LinkedList<>();
	private boolean clockwise = true;
	private ListIterator<Player> currentPlayerIt;
	
	public PlayersQueue(List<Player> players) {
		queue.addAll(players);
		currentPlayerIt = queue.listIterator();
	}
	
	public boolean isClockwise() {
		return clockwise;
	}
	
	public void reverse() {
		clockwise = !clockwise;
	}
	
	public Player getNextPlayer() {
		if(clockwise) {
			return currentPlayerIt.hasNext() ? currentPlayerIt.next() : queue.get(0);
		}
		else {
			return currentPlayerIt.hasPrevious() ? currentPlayerIt.previous() : queue.get(queue.size() - 1);
		}
	}
	
}
