package uno.game;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PlayersQueue extends ArrayList<Player>{
	
	static final long serialVersionUID = 1L;
	//	private List<Player> queue = new ArrayList<>();
	private ListIterator<Player> currentPlayerIt;
	private boolean clockwise = true;
	private int firstIndex;
	private int lastIndex;
	
	public PlayersQueue() {
		init();
	}
	
	public PlayersQueue(List<Player> players) {
//		queue.addAll(players);
		addAll(players);
		currentPlayerIt = listIterator();
		init();
	}
	
	private void init() {
		firstIndex = 0;
		lastIndex = size() - 1;
	}
	
	public void reverse() {
		clockwise = !clockwise;
		getNextPlayer();
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
		currentPlayerIt = listIterator();
		return currentPlayerIt.next();
	}
	
	private Player getLast() {
		Player last = get(lastIndex);
		currentPlayerIt = listIterator(lastIndex);
		return last;
	}
}
