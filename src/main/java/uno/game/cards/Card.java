package uno.game.cards;

import uno.game.common.COLOR;
import uno.game.common.RANK;

public class Card {
	private COLOR color;
	private RANK rank;
	private boolean isSpecial;
	private boolean isAvailable = false;
	
	public Card(COLOR color, RANK rank) {
		this.color = color;
		this.rank = rank;
		this.isSpecial = rank.value > 9;
	}
	
	public COLOR getColor() {
		return color;
	}
	
	/*for wild cards only*/
	public void setColor(COLOR color) {
		this.color = color;
	}
	
	public RANK getRank() {
		return rank;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public boolean isSpecial() {
		return isSpecial;
	}
	
	@Override
	public String toString() {
		String underscore = "_";
		StringBuilder sb = new StringBuilder();
		return sb.append(color)
				.append(underscore)
				.append(rank.value < 100 ? rank.value : rank)
				.append(underscore)
				.append(isAvailable).toString();
	}
}
