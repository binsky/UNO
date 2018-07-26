package uno.game.common;

public enum RANK {
	ZERO(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	REVERSE(100),
	DRAW2(101),
	SKIP(102),
	DRAW4(222),//wild
	SWAP(333),//wild
	WILD(444);//wild
	
	public int value;
	
	private RANK(int value) {
		this.value = value;
	}
}
