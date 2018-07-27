package uno.game;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PlayersQueue {
	
	private List<Player> queue = new ArrayList<>();
	private ListIterator<Player> currentPlayerIt;
	private boolean clockwise = true;
	private final int firstIndex;
	private final int lastIndex;
	
	public PlayersQueue(List<Player> players) {
		queue.addAll(players);
		currentPlayerIt = queue.listIterator();
		firstIndex = 0;
		lastIndex = queue.size() - 1;
	}
	
	public void reverse() {
		clockwise = !clockwise;
	}
	
	public Player getNextPlayer() {
		if(clockwise) {
			return currentPlayerIt.hasNext() ? currentPlayerIt.next() : getFirst();
		}
		else {
			return currentPlayerIt.hasPrevious() ? currentPlayerIt.previous() : getLast();
		}
	}

	private Player getFirst() {
		Player first = queue.get(firstIndex);
		currentPlayerIt.set(first);
		return first;
	}
	
	private Player getLast() {
		Player last = queue.get(lastIndex);
		currentPlayerIt.set(last);
		return last;
	}
}
