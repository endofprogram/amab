package old.org.eop.amab.place.room.context;

import old.org.eop.amab.mount.Wild;
import old.org.eop.amab.place.room.context.event.ContextEventObject;
import old.org.eop.amab.place.room.context.event.TypeEventObject;

/**
 * @author lixinjie
 */
public interface Context {

	Wild getMount();
	
	int readBlock(StringBuilder sb);
	
	void onTypeChange(TypeEventObject eventObject);
	
	void onContextChange(ContextEventObject eventObject);
}
