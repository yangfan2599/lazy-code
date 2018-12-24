package com.lazy.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lazy.converter.Converter;
import com.lazy.meta.Column;
import com.lazy.meta.Table;

public class Database {

	static {

		try {

			Class.forName(Infomation.DRIVER);

		} catch (ClassNotFoundException e) {

			throw new RuntimeException("Init driver error !", e);

		}

	}

	public static java.sql.Connection connect() {

		try {

			return DriverManager.getConnection(Infomation.URL, Infomation.USERNAME, Infomation.PASSWORD);

		} catch (Exception e) {

			throw new RuntimeException("Conn getConn fail!", e);

		}
	}

	public static void close(java.sql.Connection conn) {

		try {

			if (conn != null) {

				conn.close();

			}

		} catch (SQLException e) {

			throw new RuntimeException("Connection close error !", e);

		}

	}

	public static void close(ResultSet rs, java.sql.Connection conn) {

		try {

			if (rs != null) {

				rs.close();

			}

			close(conn);

		} catch (SQLException e) {

			throw new RuntimeException("Connection and ResultSet close error !", e);

		}
	}

	public static void close(ResultSet rs) {

		try {

			if (rs != null) {

				rs.close();

			}

		} catch (SQLException e) {

			throw new RuntimeException("ResultSet close error !", e);

		}

	}

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

							cols.getString("COLUMN_NAME"),

							Converter.convertColumnType(cols.getString("TYPE_NAME")),

							Converter.columnToProperty(cols.getString("COLUMN_NAME"))

					));

					break;

				}
			}

			columns.add(new Column(primary,

					cols.getString("TYPE_NAME"),

					cols.getString("COLUMN_NAME"),

					Converter.convertColumnType(cols.getString("TYPE_NAME")),

					Converter.columnToProperty(cols.getString("COLUMN_NAME"))));

		}

		return new Table(tableName,

				tableKeys,

				columns);

	}

	public static Table getTable(String tableName) {

		Connection conn = Database.connect();

		ResultSet keys = null;

		ResultSet cols = null;

		try {

			DatabaseMetaData metaData = conn.getMetaData();

			keys = metaData.getPrimaryKeys(null, null, tableName);

			cols = metaData.getColumns(null, null, tableName, null);

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

								cols.getString("COLUMN_NAME"),

								Converter.convertColumnType(cols.getString("TYPE_NAME")),

								Converter.columnToProperty(cols.getString("COLUMN_NAME"))));
						break;

					}
				}

				columns.add(new Column(primary,

						cols.getString("TYPE_NAME"),

						cols.getString("COLUMN_NAME"),

						Converter.convertColumnType(cols.getString("TYPE_NAME")),

						Converter.columnToProperty(cols.getString("COLUMN_NAME"))));

			}

			return new Table(tableName,

					tableKeys,

					columns);

		} catch (SQLException e) {

			throw new RuntimeException("Metadata getTable error!", e);

		} finally {

			Database.close(keys);

			Database.close(cols, conn);

		}

	}
}
