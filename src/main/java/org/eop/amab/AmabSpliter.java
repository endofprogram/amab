package org.eop.amab;

import org.eop.amab.split.Section;
import org.eop.amab.split.reader.CharReader;
import org.eop.amab.split.reader.DefaultCharReader;
import org.eop.amab.split.spliter.SectionSpliter;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class AmabSpliter {

	public static SplitedCode split(SourceCode source) {
		CharReader charReader = new DefaultCharReader(source.getSource());
		Section section;
		SplitedCode splitedCode = new SplitedCode();
		while ((section = SectionSpliter.splitSection(charReader)) != null) {
			splitedCode.addSection(section);
		}
		return splitedCode;
	}
}
