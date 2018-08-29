package com.lazy.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Output {

	public static void generate(String content)  {
		FileOutputStream fop = null;
		try {
			File file = new File("d:/table.java");
			fop = new FileOutputStream(file);
			if (!file.exists()) { file.createNewFile();}
			byte[] bytes = content.getBytes();
			fop.write(bytes);
			fop.flush();
			fop.close();
		} catch (IOException e) {
			throw new RuntimeException("Output generate Error!",e);
		} finally {
			try {
				fop.close();
			} catch (IOException e) {
				throw new RuntimeException("Output generate Error!",e);
			}
		}
	}
}
