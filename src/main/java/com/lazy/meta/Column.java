package com.lazy.meta;

public class Column extends Metadata {

	private boolean primary;
	private String type;
	private String name;
	
	public Column() {
		super();
	}
	
	public Column(boolean primary, String type, String name) {
		super();
		this.primary = primary;
		this.type = type;
		this.name = name;
	}
	
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Column [primary=" + primary + ", type=" + type + ", name=" + name + "]";
	}

	
}
