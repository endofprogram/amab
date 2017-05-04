package old.org.eop.amab.place.room.context;

import java.util.EventObject;

import old.org.eop.amab.mount.Wild;
import old.org.eop.amab.place.room.DefaultTokenReader;
import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.ItemMatcher;
import old.org.eop.amab.place.room.context.event.ContextEventObject;
import old.org.eop.amab.place.room.context.event.TypeEventObject;

/**
 * @author lixinjie
 */
public abstract class AbstractContext implements Context {

	protected DefaultTokenReader treader;
	protected Wild mount;
	
	protected AbstractContext(DefaultTokenReader treader, Wild mount) {
		this.treader = treader;
		this.mount = mount;
	}
	
	@Override
	public Wild getMount() {
		return mount;
	}
	
	@Override
	public void onTypeChange(TypeEventObject eventObject) {
		treader.typeChange();
		char[] chars = lookForwardTwo();
		if (CharType.Hash.match(chars[0]) && CharType.Obrace.match(chars[1])) {
			fireEvent("contextChange", new ContextEventObject(this, new CharsMatcher(new ItemMatcher(CharType.Hash, CharType.Obrace))));
			return;
		}
		if (CharType.Dollar.match(chars[0]) && CharType.Obrace.match(chars[1])) {
			fireEvent("contextChange", new ContextEventObject(this, new CharsMatcher(new ItemMatcher(CharType.Dollar, CharType.Obrace))));
			return;
		}
		if (CharType.Hash.match(chars[0]) && CharType.Hash.match(chars[1])) {
			fireEvent("contextChange", new ContextEventObject(this, new CharsMatcher(new ItemMatcher(CharType.Hash, CharType.Hash))));
			return;
		}
		if (CharType.Hash.match(chars[0]) && CharType.Asterisk.match(chars[1])) {
			fireEvent("contextChange", new ContextEventObject(this, new CharsMatcher(new ItemMatcher(CharType.Hash, CharType.Asterisk))));
			return;
		}
		if (CharType.End.match(chars[0])) {
			return;
		}
		fireEvent("contextChange", new ContextEventObject(this, new CharsMatcher(new ItemMatcher(CharType.Others))));
	}
	
	@Override
	public void onContextChange(ContextEventObject eventObject) {
		treader.contextChange(eventObject.getCharMatcher());
	}
	
	public char readOne(StringBuilder sb) {
		char[] chars = read(1, sb);
		if (chars.length > 0) {
			return chars[0];
		}
		return '\0';
	}
	
	public char[] readTwo(StringBuilder sb) {
		char[] chars = read(2, sb);
		if (chars.length > 1) {
			return chars;
		}
		if (chars.length > 0) {
			return new char[]{chars[0], '\0'};
		}
		return new char[]{'\0', '\0'};
	}
	
	public char[] read(int len, StringBuilder sb) {
		char[] chars = getMount().read(len);
		sb.append(chars);
		return chars;
	}
	
	public char readOne() {
		char[] chars = read(1);
		if (chars.length > 0) {
			return chars[0];
		}
		return '\0';
	}
	
	public char[] readTwo() {
		char[] chars = read(2);
		if (chars.length > 1) {
			return chars;
		}
		if (chars.length > 0) {
			return new char[]{chars[0], '\0'};
		}
		return new char[]{'\0', '\0'};
	}
	
	public char[] read(int len) {
		return getMount().read(len);
	}
	
	public int unReadOne() {
		return unRead(1);
	}
	
	public int unReadTwo() {
		return unRead(2);
	}
	
	public int unRead(int len) {
		return getMount().unread(len);
	}
	
	public char lookForwardOne() {
		char[] chars = lookForward(1);
		if (chars.length > 0) {
			return chars[0];
		}
		return '\0';
	}
	
	public char[] lookForwardTwo() {
		char[] chars = lookForward(2);
		if (chars.length > 1) {
			return chars;
		}
		if (chars.length > 0) {
			return new char[]{chars[0], '\0'};
		}
		return new char[]{'\0', '\0'};
	}
	
	public char[] lookForward(int len) {
		return getMount().lookForward(len);
	}
	
	public char lookBackwardOne() {
		char[] chars = lookBackward(1);
		if (chars.length > 0) {
			return chars[0];
		}
		return '\0';
	}
	
	public char[] lookBackwardTwo() {
		char[] chars = lookBackward(2);
		if (chars.length > 1) {
			return chars;
		}
		if (chars.length > 0) {
			return new char[]{'\0', chars[0]};
		}
		return new char[]{'\0', '\0'};
	}
	
	public char[] lookBackward(int len) {
		return getMount().lookBackward(len);
	}
	
	public int readAlways(StringBuilder sb, CharsMatcher matcher) {
		int count = 0;
		char c = readOne();
		while (!CharType.End.match(c) && matcher.match(c)) {
			sb.append(c);
			count++;
			c = readOne();
		}
		if (!CharType.End.match(c)) {
			unReadOne();
		} else {
			count = -1;
		}
		fireEvent("typeChange", new TypeEventObject(this, sb));
		return count;
	}
	
	public int readUntil(StringBuilder sb, CharsMatcher matcher) {
		int count = 0;
		char c = readOne();
		while (!CharType.End.match(c) && !matcher.match(c)) {
			sb.append(c);
			count++;
			if (CharType.Bslash.match(c)) {
				readOne(sb);
				count++;
			}
			c = readOne();
		}
		if (!CharType.End.match(c)) {
			unReadOne();
		} else {
			count = -1;
		}
		fireEvent("typeChange", new TypeEventObject(this, sb));
		return count;
	}
	
	protected void fireEvent(String eventName, EventObject eventObject) {
		if ("typeChange".equals(eventName)) {
			onTypeChange((TypeEventObject)eventObject);
			return;
		}
		if ("contextChange".equals(eventName)) {
			onContextChange((ContextEventObject)eventObject);
			return;
		}
	}
	
}
