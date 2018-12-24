package com.lazy;

import java.util.List;

import com.lazy.connection.Database;
import com.lazy.generator.ControllerGenerator;
import com.lazy.generator.ModelGenerator;
import com.lazy.meta.Table;

public class CodeRunner {

	public static void main(String[] args) {

		printModel();
		
	}

	public static void printController() {

		List<Table> tables = Database.getTables();

		System.out.println(ControllerGenerator.generate(tables.get(0)));

	}
	
	public static void printModel() {

		List<Table> tables = Database.getTables();

		System.out.println(ModelGenerator.generate(tables.get(0)));

	}

}
