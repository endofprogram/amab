package old.org.eop.amab.place.room.context;

import old.org.eop.amab.mount.Wild;
import old.org.eop.amab.place.room.DefaultTokenReader;
import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.ItemMatcher;

/**
 * @author lixinjie
 */
public class Literal extends AbstractContext {

	private CharsMatcher matcher = new CharsMatcher(new ItemMatcher(CharType.Bspace), new ItemMatcher(CharType.Tab), new ItemMatcher(CharType.Return), new ItemMatcher(CharType.Line), new ItemMatcher(CharType.Hash), new ItemMatcher(CharType.Dollar));
	
	public Literal(DefaultTokenReader treader, Wild mount) {
		super(treader, mount);
	}
	
	@Override
	public int readBlock(StringBuilder sb) {
		CharType type = CharType.valueOf(lookForwardOne());
		if (matcher.match(type)) {
			return readAlways(sb, new CharsMatcher(new ItemMatcher(type)));
		}
		return readUntil(sb, matcher);
	}
}
