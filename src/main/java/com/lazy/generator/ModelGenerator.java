package com.lazy.generator;

import com.lazy.builder.ModelBuilder;
import com.lazy.constant.Constant;
import com.lazy.converter.Converter;
import com.lazy.meta.Table;

public class ModelGenerator {

public static String generate(Table table) {
		
		table.setLayered(Constant.Layered.MODEL.value);
		
		ModelBuilder builder = new ModelBuilder();
		
		Converter.convertMetadata(table);
		
		return builder.build(table);
		
	}
}
