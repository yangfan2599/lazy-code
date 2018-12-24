package com.lazy.meta;

public class Column extends Metadata {

	private boolean primary;
	private String columnType;
	private String columnName;
	private String propertyType;
	private String propertyName;

	public Column() {
		super();
	}

	public Column(boolean primary, String columnType, String columnName, String propertyType, String propertyName) {
		super();
		this.primary = primary;
		this.columnType = columnType;
		this.columnName = columnName;
		this.propertyType = propertyType;
		this.propertyName = propertyName;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Override
	public String toString() {
		return "Column [primary=" + primary + ", columnType=" + columnType + ", columnName=" + columnName
				+ ", propertyType=" + propertyType + ", propertyName=" + propertyName + "]";
	}

}
