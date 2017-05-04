package org.eop.amab.split;

import java.util.ArrayList;
import java.util.List;

import org.eop.amab.Location;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public class Row extends Section {

	private HeadBlank headBlank;
	private List<Section> children = new ArrayList<>();
	private TailBlank tailBlank;
	private LineFeed lineFeed;
	
	public Row(String source, Location location) {
		super(source, location);
	}

	public HeadBlank getHeadBlank() {
		return headBlank;
	}

	public void setHeadBlank(HeadBlank headBlank) {
		this.headBlank = headBlank;
	}

	public List<Section> getChildren() {
		return children;
	}

	public TailBlank getTailBlank() {
		return tailBlank;
	}

	public void setTailBlank(TailBlank tailBlank) {
		this.tailBlank = tailBlank;
	}

	public LineFeed getLineFeed() {
		return lineFeed;
	}

	public void setLineFeed(LineFeed lineFeed) {
		this.lineFeed = lineFeed;
	}
	
	public void addChild(Section section) {
		children.add(section);
	}

	@Override
	public String toString() {
		return "Row [headBlank=" + headBlank + ", children=" + children + ", tailBlank=" + tailBlank + ", lineFeed="
				+ lineFeed + "]";
	}

}
