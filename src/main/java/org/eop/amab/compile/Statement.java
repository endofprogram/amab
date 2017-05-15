package org.eop.amab.compile;

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
	
	public void compile() {
		
	}
	
	public void execute() {
		
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
}
