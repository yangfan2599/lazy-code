package com.lazy.meta;

import java.util.List;

public class Table extends Metadata {

	private List<String> imports;
	private String name;
	private List<Column> keys;
	private List<Column> columns;
	
	public Table() {
		super();
	}
	
	public Table(String name, List<Column> keys, List<Column> columns) {
		super();
		this.name = name;
		this.keys = keys;
		this.columns = columns;
	}
	
	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public List<Column> getKeys() {
		return keys;
	}

	public void setKeys(List<Column> keys) {
		this.keys = keys;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getImports() {
		return imports;
	}

	public void setImports(List<String> imports) {
		this.imports = imports;
	}

	@Override
	public String toString() {
		return "Table [imports=" + imports + ", name=" + name + ", keys=" + keys + ", columns=" + columns
				+ ", getColumns()=" + getColumns() + ", getKeys()=" + getKeys() + ", getName()=" + getName()
				+ ", getImports()=" + getImports() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
