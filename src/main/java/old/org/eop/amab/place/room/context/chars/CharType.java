package old.org.eop.amab.place.room.context.chars;

/**
 * @author lixinjie
 */
public enum CharType {
	
	// blank space
	Bspace(' '),
	// \t
	Tab('\t'),
	// \r
	Return('\r'),
	// \n
	Line('\n'),
	// \0
	End('\0'),
	
	// /
	Fslash('/'),
	// \
	Bslash('\\'),
	// #
	Hash('#'),
	// $
	Dollar('$'),
	// *
	Asterisk('*'),
	// .
	Dot('.'),
	// _
	Underscore('_'),
	// -
	Hyphen('-'),
	// '
	Squote('\''),
	// "
	Dquote('"'),
	// :
	Colon(':'),
	// ?
	Question('?'),
	
	// <
	Oanglebracket('<'),
	// >
	Canglebracket('>'),
	// (
	Oparenthesis('('),
	// )
	Cparenthesis(')'),
	// [
	Obracket('['),
	// ]
	Cbracket(']'),
	// {
	Obrace('{'),
	// }
	Cbrace('}'),
	
	// &
	Ampersand('&'),
	// |
	Vbar('|'),
	// !
	Exclam('!'),
	
	// 0..9
	Number('0', '9'),
	// a..z
	LCalphabet('a', 'z'),
	// A..Z
	UCalphabet('A', 'Z'),
	// a..zA..Z
	Alphabet(new char[]{'A', 'Z', 'a', 'z'}),
	
	// +
	Positive('+'),
	// -
	Negative('-'),
	
	// +
	Plus('+'),
	// -
	Minus('-'),
	// *
	Multiply('*'),
	// /
	Divide('/'),
	// %
	Percent('%'),
	// =
	Assign('='),
	
	// >
	Greater('>'),
	// <
	Less('<'),
	
	// (char)-1
	Others((char)-1);
	
	private TypeModel typeModel;
	
	private CharType(char c) {
		this.typeModel = new TypeModel(c);
	}
	
	private CharType(char b, char e) {
		this.typeModel = new TypeModel(b, e);
	}
	
	private CharType(char[] pairs) {
		this.typeModel = new TypeModel(pairs);
	}
	
	public static CharType valueOf(char c) {
		if (c == ' ')  return Bspace;
		if (c == '\t') return Tab;
		if (c == '\r') return Return;
		if (c == '\n') return Line;
		if (c == '\0') return End;
		if (c == '/')  return Fslash;
		if (c == '\\') return Bslash;
		if (c == '#')  return Hash;
		if (c == '$')  return Dollar;
		if (c == '*')  return Asterisk;
		if (c == '.')  return Dot;
		if (c == '_')  return Underscore;
		if (c == '-')  return Hyphen;
		if (c == '\'') return Squote;
		if (c == '"')  return Dquote;
		if (c == ':')  return Colon;
		if (c == '?')  return Question;
		if (c == '<')  return Oanglebracket;
		if (c == '>')  return Canglebracket;
		if (c == '(')  return Oparenthesis;
		if (c == ')')  return Cparenthesis;
		if (c == '[')  return Obracket;
		if (c == ']')  return Cbracket;
		if (c == '{')  return Obrace;
		if (c == '}')  return Cbrace;
		if (c == '&')  return Ampersand;
		if (c == '|')  return Vbar;
		if (c == '!')  return Exclam;
		if ('0' <= c && c <= '9') return Number;
		if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) return Alphabet;
		return Others;
	}
	
	public boolean match(char c) {
		return typeModel.match(c);
	}
	
	public TypeModel getModel() {
		return typeModel;
	}
	
	@Override
	public String toString() {
		return typeModel.toString();
	}
}
