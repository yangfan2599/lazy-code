package com.lazy.meta;

import java.util.List;

public class Table extends Metadata {

	private String tableName;
	private List<Column> keys;
	private List<Column> columns;
	
	
	public Table() {
		super();
	}


	public Table(String tableName, List<Column> keys, List<Column> columns) {
		super();
		this.tableName = tableName;
		this.keys = keys;
		this.columns = columns;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public List<Column> getKeys() {
		return keys;
	}


	public void setKeys(List<Column> keys) {
		this.keys = keys;
	}


	public List<Column> getColumns() {
		return columns;
	}


	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}


	
}
