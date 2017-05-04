package old.org.eop.amab.place.room.context.chars.matcher;

/**
 * @author lixinjie
 */
public enum MatchOrder {

	Ascending(1),
	Descending(-1),
	Unordering(0);
	
	private int order;
	
	private MatchOrder(int order) {
		this.order = order;
	}
	
	public int getValue() {
		return order;
	}
	
}
