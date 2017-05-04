package old.org.eop.amab;

import java.util.List;

/**
 * @author lixinjie
 */
public interface Header extends Brother {

	List<Brother> getChildren();
	
	Brother addChild(Brother child);
	
	Tailer getTailer();
	
	void setTailer(Tailer tailer);
}
