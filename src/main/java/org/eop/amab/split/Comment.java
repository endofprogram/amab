package org.eop.amab.split;

import org.eop.amab.Location;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public class Comment extends Section {

	private CommentType commentType;
	
	public Comment(String source, CommentType commentType, Location location) {
		super(source, location);
		this.commentType = commentType;
	}

	public CommentType getCommentType() {
		return commentType;
	}

	public enum CommentType {
		SingleLine,
		MultiLine
	}
}
