package old.org.eop.amab.place.room.context;

import old.org.eop.amab.mount.Wild;
import old.org.eop.amab.place.room.DefaultTokenReader;
import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.ItemMatcher;
import old.org.eop.amab.place.room.context.event.TypeEventObject;

/**
 * @author lixinjie
 */
public class Comment extends AbstractContext {

	private CharsMatcher smatcher = new CharsMatcher(new ItemMatcher(CharType.Return, CharType.Line));
	private CharsMatcher mmatcher = new CharsMatcher(new ItemMatcher(CharType.Hash));
	private CharsMatcher matcher;
	private int mode = 0;
	
	public Comment(DefaultTokenReader treader, Wild mount) {
		super(treader, mount);
	}
	
	@Override
	public int readBlock(StringBuilder sb) {
		if (mode == 0) {
			char[] chars = readTwo(sb);
			if (CharType.Hash.match(chars[1])) {
				matcher = smatcher;
				mode = 1;
			} else if (CharType.Asterisk.match(chars[1])) {
				matcher = mmatcher;
				mode = 2;
			}
		} else if (mode == 1) {
			matcher = smatcher;
		} else if (mode == 2) {
			matcher = mmatcher;
		}
		return readUntil(sb, matcher);
	}

	@Override
	public void onTypeChange(TypeEventObject eventObject) {
		if (mode == 2) {
			readOne(eventObject.getStringBuilder());
			if (CharType.Asterisk.match(lookBackwardTwo()[0])) {
				mode = 0;
				super.onTypeChange(eventObject);
			}
		} else if (mode == 1) {
			mode = 0;
			super.onTypeChange(eventObject);
		}
	}
}
