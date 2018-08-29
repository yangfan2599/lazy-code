package com.lazy;

import org.junit.Test;

import com.lazy.connection.Database;

public class CodeRunner {

	@Test
	public void run() {
		
		System.out.print(Database.getTables());
		
	}

}
