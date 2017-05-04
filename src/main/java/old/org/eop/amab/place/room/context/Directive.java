package old.org.eop.amab.place.room.context;

import old.org.eop.amab.mount.Wild;
import old.org.eop.amab.place.room.DefaultTokenReader;
import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.ItemMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.MatchOrder;
import old.org.eop.amab.place.room.context.event.TypeEventObject;

/**
 * @author lixinjie
 */
public class Directive extends AbstractContext {

	private CharsMatcher matcher1 = new CharsMatcher(MatchOrder.Unordering, new ItemMatcher(CharType.Dquote), new ItemMatcher(CharType.Obrace), new ItemMatcher(CharType.Cbrace));
	private CharsMatcher matcher2 = new CharsMatcher(new ItemMatcher(CharType.Dquote));
	private CharsMatcher matcher = matcher1;
	private int dqcount = 0;
	private int stack = 0;
	
	public Directive(DefaultTokenReader treader, Wild mount) {
		super(treader, mount);
	}
	
	@Override
	public int readBlock(StringBuilder sb) {
		return readUntil(sb, matcher);
	}

	@Override
	public void onTypeChange(TypeEventObject eventObject) {
		char c = readOne(eventObject.getStringBuilder());
		if (CharType.Dquote.match(c)) {
			dqcount++;
			if (dqcount % 2 == 1) {
				matcher = matcher2;
			} else {
				matcher = matcher1;
			}
			return;
		}
		if (CharType.Obrace.match(c)) {
			stack++;
		}
		if (CharType.Cbrace.match(c)) {
			stack--;
		}
		if (stack == 0) {
			super.onTypeChange(eventObject);
		}
	}
}
