package old.org.eop.amab.place;

import java.util.ArrayList;
import java.util.List;

import old.org.eop.amab.Governor;
import old.org.eop.amab.Mount;
import old.org.eop.amab.mount.Green;
import old.org.eop.amab.mount.Wild;
import old.org.eop.amab.place.room.DefaultTokenReader;
import old.org.eop.amab.place.room.TokenReader;

/**
 * @author lixinjie
 */
public class Room extends AbstractPlace {

	private List<String> newMount = new ArrayList<>();
	private TokenReader treader;
	public Room(Governor governor) {
		super(governor);
		this.treader = new DefaultTokenReader((Wild)governor.getMount());
	}
	
	@Override
	public Mount discuss() {
		int count;
		do{
			count = treader.readToken(newMount);
		} while(count != -1);
		return new Green(newMount);
	}
	
}
