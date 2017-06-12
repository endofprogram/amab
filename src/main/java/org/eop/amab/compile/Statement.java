package org.eop.amab.compile;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class Statement {

	private Section section;
	
	public Statement(Section section) {
		this.section = section;
	}
	
	public void compile(AmabSetting setting, AmabContext context) {
		
	}
	
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
}
