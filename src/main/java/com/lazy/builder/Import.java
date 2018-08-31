package com.lazy.builder;

import java.util.List;

import com.lazy.constant.Constant;
import com.lazy.meta.Column;
import com.lazy.meta.Metadata;
import com.lazy.meta.Table;

public class Import implements Builder {

	
	
	public String build(Metadata data) {
		
		if(data instanceof Table){
			
			Table table = (Table)data;
			
			List<Column> columns = table.getColumns();
			
			StringBuffer buffer = new StringBuffer();
			
			for(Column column : columns){
				
				buffer.append(casePackage(column.getType())).append(Constant.Symbol.NL);
				
			}
			
			return buffer.toString();
			
		}else{
			
			return null;
			
		}
		
		
	}
	
	public static String casePackage(String type){
		
		String result = null;
		
		switch (type) {
		
		case "BIGDECIMAL":
			
			result = "java.math.BigDecimal;";
			
			break;
			
		case "DATE":
			
			result = "java.util.Date;";
			
			break;

		default:
			
			result = null;
			
			break;
			
		}
		
		return result;
	}

}
