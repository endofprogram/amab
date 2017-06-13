package org.eop.amab.compile.statement;

import java.util.ArrayList;
import java.util.List;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.compile.Statement;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-16
 */
public class Control extends Statement {

	private List<Statement> children = new ArrayList<>();
	
	public Control(Section section) {
		super(section);
	}

	public void addChild(Statement statement) {
		children.add(statement);
	}
	
	public List<Statement> getChildren() {
		return children;
	}

	@Override
	public void compile(AmabSetting setting) {
		
	}

	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		
	}
	
	@Override
	public String toString() {
		return "Control[" + getSection().getSource() + "]";
	}
	
	@Override
	public void display(StringBuilder sb, int indent) {
		
	}
	
	protected void displayChildren(StringBuilder sb, int indent) {
		for (Statement child : children) {
			child.display(sb, indent);
		}
	}
}
