package br.edu.insper.desagil.aps5.netpixi;

import java.util.HashMap;
import java.util.Map;

public abstract class Element {
	private Map<String, Object> properties;

	public Element() {
		this.properties = new HashMap<>();
	}

	public Object get(String key) {
		return properties.get(key);
	}

	public void put(String key, Object value) {
		properties.put(key, value);
	}
}
