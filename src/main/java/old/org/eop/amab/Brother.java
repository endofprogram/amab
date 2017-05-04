package old.org.eop.amab;

/**
 * @author lixinjie
 */
public interface Brother {

	String appear();
	
	void train();

	String devote();
	
	Brother getParent();
	
	void setParent(Brother parent);
	
	String getOrigin();
	
	void setOrigin(String origin);
}
