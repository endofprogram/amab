package org.eop.amab.compile;

import java.util.List;
import java.util.Map;

import org.eop.amab.context.Fetcher;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class Condition {

	private Fetcher fetcher;
	
	public Condition(Fetcher fetcher) {
		this.fetcher = fetcher;
	}
	
	@SuppressWarnings("unchecked")
	public boolean predicate() {
		Object value = fetcher.fetch();
		if (value == null) {
			return false;
		}
		if (value instanceof String) {
			return predicate((String)value);
		}
		if (value instanceof List<?>) {
			return predicate((List<Object>)value);
		}
		if (value instanceof Map<?, ?>) {
			return predicate((Map<Object, Object>)value);
		}
		if (value instanceof Integer) {
			return predicate((Integer)value);
		}
		if (value instanceof Long) {
			return predicate((Long)value);
		}
		if (value instanceof Double) {
			return predicate((Double)value);
		}
		return true;
	}
	
	public Fetcher getFetcher() {
		return fetcher;
	}
	
	protected boolean predicate(String value) {
		return !value.isEmpty();
	}
	
	protected boolean predicate(List<Object> value) {
		return !value.isEmpty();
	}
	
	protected boolean predicate(Map<Object, Object> value) {
		return !value.isEmpty();
	}
	
	protected boolean predicate(Integer value) {
		return value != 0;
	}
	
	protected boolean predicate(Long value) {
		return value != 0L;
	}
	
	protected boolean predicate(Double value) {
		return value != 0;
	}
	
}
