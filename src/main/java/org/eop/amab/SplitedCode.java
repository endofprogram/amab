package org.eop.amab;

import java.util.ArrayList;
import java.util.List;

import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class SplitedCode {
	
	private List<Section> sections;
	
	public SplitedCode() {
		this.sections = new ArrayList<>();
	}
	
	public List<Section> getSections() {
		return sections;
	}

	public void addSection(Section section) {
		sections.add(section);
	}
	
	public String display() {
		StringBuilder sb = new StringBuilder();
		for (Section section : sections) {
			sb.append(section).append(getCrLf());
		}
		return sb.toString();
	}
	
	protected String getCrLf() {
		return System.getProperty("line.separator");
	}
}
