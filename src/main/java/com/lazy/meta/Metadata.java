package com.lazy.meta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lazy.connection.Database;

public class Metadata {

	public static List<Table> getTables() {
		
		Connection conn = Database.connect();
		
		ResultSet rs = null;
		
		try {
			
			DatabaseMetaData metaData = conn.getMetaData();
			
			rs = metaData.getTables(null, null, "%", new String[] { "TABLE" });
			
			List<Table> tables = new ArrayList<Table>();

			while (rs.next()) {
				
				tables.add(getTable(metaData, rs.getString("TABLE_NAME")));
				
			}

			return tables;
			
		} catch (SQLException e) {
			
			throw new RuntimeException("Metadata getTables error!", e);
			
		} finally {
			
			Database.close(rs, conn);
			
		}

	}

	private static Table getTable(DatabaseMetaData metaData, String tableName) throws SQLException {

		ResultSet keys = metaData.getPrimaryKeys(null, null, tableName);
		
		ResultSet cols = metaData.getColumns(null, null, tableName, null);
		
		List<Column> columns = new ArrayList<Column>();
		
		List<Column> tableKeys = new ArrayList<Column>();

		boolean primary = false;

		while (cols.next()) {
			
			primary = false;

			while (keys.next()) {
				
				if (cols.getString("COLUMN_NAME").equalsIgnoreCase(keys.getString("COLUMN_NAME"))) {
					
					primary = true;
					
					tableKeys.add(new Column(primary,
							
							cols.getString("TYPE_NAME"), 
							
							cols.getString("COLUMN_NAME")));
					
					break;
					
				}
			}

			columns.add(new Column(primary, 
					
					cols.getString("TYPE_NAME"),
					
					cols.getString("COLUMN_NAME")));
			
			
		}

		return new Table(tableName, tableKeys, columns);
		
	}

	public static Table getTable(String table) {
		
		Connection conn = Database.connect();
		
		ResultSet keys = null;
		
		ResultSet cols = null;
		
		try {
			
			DatabaseMetaData metaData = conn.getMetaData();
			
			keys = metaData.getPrimaryKeys(null, null, table);
			
			cols = metaData.getColumns(null, null, table, null);
			
			List<Column> columns = new ArrayList<Column>();
			
			List<Column> tableKeys = new ArrayList<Column>();
			
			boolean primary = false;

			while (cols.next()) {
				
				primary = false;

				while (keys.next()) {
					
					if (cols.getString("COLUMN_NAME").equalsIgnoreCase(keys.getString("COLUMN_NAME"))) {
						
						primary = true;
						
						tableKeys.add(new Column(primary, 
								
								cols.getString("TYPE_NAME"),
								
								cols.getString("COLUMN_NAME")));
						
						break;
						
					}
				}

				columns.add(new Column(primary, 
						
						cols.getString("TYPE_NAME"), 
						
						cols.getString("COLUMN_NAME")));
				
			}

			return new Table(table, tableKeys, columns);

		} catch (SQLException e) {
			
			throw new RuntimeException("Metadata getTable error!", e);
			
		} finally {
			
			Database.close(keys);
			
			Database.close(cols,conn);
			
		}
		
	}
	
}
