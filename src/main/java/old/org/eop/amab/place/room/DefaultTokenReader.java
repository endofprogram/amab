package old.org.eop.amab.place.room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import old.org.eop.amab.mount.Wild;
import old.org.eop.amab.place.room.context.Comment;
import old.org.eop.amab.place.room.context.Context;
import old.org.eop.amab.place.room.context.Directive;
import old.org.eop.amab.place.room.context.Literal;
import old.org.eop.amab.place.room.context.Variable;
import old.org.eop.amab.place.room.context.Vase;
import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.ItemMatcher;

/**
 * @author lixinjie
 */
public class DefaultTokenReader implements TokenReader {
	
	private List<String> tokens;
	private Wild mount;
	private StringBuilder tokenBuilder = new StringBuilder();
	private Map<String, Context> contexts = new HashMap<>();
	private Context context;
	private boolean tchanged;
	
	public DefaultTokenReader(Wild mount) {
		this.mount = mount;
		this.tchanged = false;
		registerContext();
		initializeContext();
	}
	
	@Override
	public int readToken(List<String> tokens) {
		this.tokens = tokens;
		tchanged = false;
		int count = 0;
		do{
			count += context.readBlock(tokenBuilder);
		} while(count > -1 && !tchanged);
		return count;
	}

	public int typeChange() {
		int len = tokenBuilder.length();
		if (len > 0) {
			tokens.add(tokenBuilder.toString());
			tokenBuilder.setLength(0);
			tchanged = true;
		}
		return len;
	}
	
	public Context contextChange(CharsMatcher matcher) {
		context = contexts.get(matcher.toString());
		return context;
	}
	
	private void registerContext() {
		contexts.put(new CharsMatcher(new ItemMatcher(CharType.Hash, CharType.LCalphabet)).toString(), new Directive(this, mount));
		contexts.put(new CharsMatcher(new ItemMatcher(CharType.Dollar, CharType.Obrace)).toString(), new Variable(this, mount));
		contexts.put(new CharsMatcher(new ItemMatcher(CharType.Hash, CharType.Hash)).toString(), new Comment(this, mount));
		contexts.put(new CharsMatcher(new ItemMatcher(CharType.Hash, CharType.Asterisk)).toString(), new Comment(this, mount));
		contexts.put(new CharsMatcher(new ItemMatcher(CharType.Others)).toString(), new Literal(this, mount));
	}
	
	private void initializeContext() {
		context = new Vase(this, mount);
	}
}
