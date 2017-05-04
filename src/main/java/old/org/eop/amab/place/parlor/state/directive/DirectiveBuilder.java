package old.org.eop.amab.place.parlor.state.directive;

import old.org.eop.amab.Brother;
import old.org.eop.amab.brother.Captainb;
import old.org.eop.amab.brother.Captainf;
import old.org.eop.amab.brother.Captainl;
import old.org.eop.amab.brother.Captainr;
import old.org.eop.amab.brother.Coach;
import old.org.eop.amab.brother.Jurisdiction;
import old.org.eop.amab.brother.Marquis;
import old.org.eop.amab.brother.Scout;

/**
 * @author lixinjie
 */
public class DirectiveBuilder {

	public static Brother build(String block) {
		String name = getName(block);
		if ("end".equals(name)) {
			return new Marquis(block);
		}
		if ("import".equals(name)) {
			return new Scout(block);
		}
		if ("set".equals(name)) {
			return new Jurisdiction(block);
		}
		if ("if".equals(name)) {
			return new Coach(block);
		}
		if ("elseif".equals(name)) {
			return new Coach(block);
		}
		if ("else".equals(name)) {
			return new Coach(block);
		}
		if ("foreach".equals(name)) {
			return new Captainf(block);
		}
		if ("for".equals(name)) {
			return new Captainb(block);
		}
		if ("while".equals(name)) {
			return new Captainl(block);
		}
		if ("dowhile".equals(name)) {
			return new Captainr(block);
		}
		return null;
	}
	
	private static String getName(String block) {
		int index = block.indexOf("(");
		if (index < 0) {
			return block.substring(1);
		}
		return block.substring(1, index);
	}
}
