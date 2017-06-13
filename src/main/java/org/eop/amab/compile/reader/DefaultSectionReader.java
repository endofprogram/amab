package org.eop.amab.compile.reader;

import java.util.List;

import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class DefaultSectionReader implements SectionReader {

	private List<Section> sections;
	private int index;
	private int length;
	
	public DefaultSectionReader(List<Section> sections) {
		this.sections = sections;
		this.index = 0;
		this.length = sections.size();
	}
	
	@Override
	public Section read() {
		if (index < length) {
			Section section = sections.get(index);
			index++;
			return section;
		}
		index++;
		return null;
	}

	@Override
	public Section[] read(int count) {
		if (index < length) {
			int ncount = length - index;
			if (ncount > count) {
				ncount = count;
			}
			Section[] sa = new Section[ncount];
			for (int i = 0; i < ncount; i++) {
				sa[i] = sections.get(index);
				index++;
			}
			return sa;
		}
		return new Section[0];
	}

	@Override
	public int unread() {
		if (index >= 1) {
			index--;
			return 1;
		}
		return 0;
	}

	@Override
	public int unread(int count) {
		if (index >= count) {
			index -= count;
			return count;
		}
		int ncount = index;
		index = 0;
		return ncount;
	}

	@Override
	public Section lookNext() {
		if (index < length) {
			return sections.get(index);
		}
		return null;
	}

	@Override
	public Section[] lookNext(int count) {
		if (index < length) {
			int ncount = length - index;
			if (ncount > count) {
				ncount = count;
			}
			Section[] sa = new Section[ncount];
			for (int i = 0; i < ncount; i++) {
				sa[i] = sections.get(index + i);
			}
			return sa;
		}
		return new Section[0];
	}

	@Override
	public Section lookPrev() {
		if (index >= 2) {
			return sections.get(index - 2);
		}
		return null;
	}

	@Override
	public Section[] lookPrev(int count) {
		if (index >= 2) {
			int ncount = index - 1;
			if (ncount > count) {
				ncount = count;
			}
			Section[] sa = new Section[ncount];
			for (int i = 0; i < ncount; i++) {
				sa[i] = sections.get(index - 1 - ncount + i);
			}
			return sa;
		}
		return new Section[0];
	}

	@Override
	public Section lookBack() {
		if (index > 0) {
			return sections.get(index - 1);
		}
		return null;
	}
	
	@Override
	public boolean isEnd() {
		return index >= length;
	}
}
