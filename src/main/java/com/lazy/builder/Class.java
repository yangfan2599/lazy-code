package com.lazy.builder;

import com.lazy.constant.Constant;
import com.lazy.meta.Metadata;
import com.lazy.meta.Table;
import com.lazy.tool.Tool;


public class Class implements Builder {

	
	
	public String build(Metadata data) {
		
		if ( data instanceof Table ) {
		
			Table table = (Table)data;
			
			String name = table.getName();
			
			String [] names = name.split("_");
			
			StringBuffer buffer = new StringBuffer();
			
			if ( names.length > 1 ) {
				
				for(int i = 1 ; i < names.length ; i ++){
					
					buffer.append(Tool.toFirstUpperCase(names[i]));
					
				}
				
			} else {
				
				buffer.append(Tool.toFirstUpperCase(name));
				
			}
			
			return new StringBuffer()
					
					.append(Constant.Qualifier.PB)
					
					.append(Constant.Keyword.CS)
					
					.append(buffer).toString();
			
		}
		
		return null;
		
	}
	
}
