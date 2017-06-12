package org.eop.amab.compile.statement.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
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

	private String name;
	private Fetcher fetcher;
	
	public Foreach(Section section) {
		super(section);
	}

	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		AmabContext subContext = context.newSubContext();
		List<Object> datas = getDatas();
		for (Object value : datas) {
			new Pusher(name, value, subContext).push();
			for (Statement statement : getChildren()) {
				statement.execute(setting, subContext, result);
			}
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
	
	public String getName() {
		return name;
	}
	
}
