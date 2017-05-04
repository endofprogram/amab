package old.org.eop.amab.place.room.context.chars.matcher;

/**
 * @author lixinjie
 */
public enum MatcherStatus {

	Puerile(-1),
	Qualified(0),
	Retired(1);
	
	private int status;
	
	private MatcherStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
}
