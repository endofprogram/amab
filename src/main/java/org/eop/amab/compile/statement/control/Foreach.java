package org.eop.amab.compile.statement.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.compile.AmabContextHolder;
import org.eop.amab.compile.Name;
import org.eop.amab.compile.Statement;
import org.eop.amab.compile.statement.Control;
import org.eop.amab.context.Fetcher;
import org.eop.amab.context.Pusher;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class Foreach extends Control {

	private String iterName;
	private Fetcher fetcher;
	private AmabContextHolder contextHolder;
	private End _end;
	
	public Foreach(Section section) {
		super(section);
		contextHolder = new AmabContextHolder();
	}

	@Override
	public void compile(AmabSetting setting) {
		int begin = getSection().getSource().indexOf("(") + 1;
		int end = getSection().getSource().lastIndexOf(")");
		String _foreach = getSection().getSource().substring(begin, end).trim();
		String _in = " in ";
		begin = _foreach.indexOf(_in);
		iterName = _foreach.substring(0, begin).trim();
		String dataName = _foreach.substring(begin + _in.length()).trim();
		fetcher = new Fetcher(new Name(dataName, setting.getSetting("claw.identifier")), contextHolder);
		
		for (Statement statement : getChildren()) {
			statement.compile(setting);
		}
	}
	
	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		AmabContext subContext = context.newSubContext();
		contextHolder.setAmabContext(subContext);
		List<Object> datas = getDatas();
		for (Object value : datas) {
			new Pusher(iterName, value, contextHolder).push();
			for (Statement statement : getChildren()) {
				statement.execute(setting, subContext, result);
			}
			subContext.clearVars();
		}
	}
	
	@SuppressWarnings("unchecked")
	protected List<Object> getDatas() {
		Object value = fetcher.fetch();
		if (value instanceof Object[]) {
			return Arrays.asList((Object[])value);
		}
		if (value instanceof List<?>) {
			return (List<Object>)value;
		}
		if (value instanceof Map<?, ?>) {
			List<Object> datas = new ArrayList<>();
			for (Map.Entry<Object, Object> entry : ((Map<Object, Object>)value).entrySet()) {
				Map<Object, Object> map = new HashMap<>();
				map.put("key", entry.getKey());
				map.put("value", entry.getValue());
				datas.add(map);
			}
			return datas;
		}
		return null;
	}
	
	public Fetcher getFetcher() {
		return fetcher;
	}
	
	public String getIterName() {
		return iterName;
	}
	
	public void setEnd(End _end) {
		this._end = _end;
	}
	
	public End getEnd() {
		return _end;
	}
	
	@Override
	public String toString() {
		return "Foreach[" + getSection().getSource() + "]";
	}
	
	@Override
	public void display(StringBuilder sb, int indent) {
		displayIndent(sb, indent);
		sb.append(toString());
		displayCrLf(sb, indent);
		displayChildren(sb, indent + 1);
		getEnd().display(sb, indent);
	}
}
