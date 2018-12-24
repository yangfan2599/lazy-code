package com.lazy.builder;

import java.util.List;

import com.lazy.constant.Constant;
import com.lazy.meta.Column;
import com.lazy.meta.Metadata;
import com.lazy.meta.Table;

public class Import implements Builder {

	
	
	public String build(Metadata data) {
		
		StringBuffer buffer = new StringBuffer("\n");
		
		if(Constant.Layered.CONTROLLER.value.equalsIgnoreCase(data.getLayered())) {
			
			buffer.append("import org.springframework.web.bind.annotation.RestController;\n");
			
			buffer.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
			
			buffer.append("import javax.annotation.Resource;\n");
			
			buffer.append("import ").append(Constant.PACKAGE)
			
			.append(Constant.Layered.MODEL.value.toLowerCase()).append(".").append(data.getClassName()).append(";\n");
			
			buffer.append("import ").append(Constant.PACKAGE).append(Constant.Layered.SERVICE.value.toLowerCase()).append(".")
			
			.append(data.getClassName()).append(Constant.Layered.SERVICE.value).append(";\n");
			
		} else if(Constant.Layered.SERVICE.value.equalsIgnoreCase(data.getLayered())) {
			
			Table table = (Table)data;
			
			List<Column> columns = table.getColumns();
			
			buffer.append(buildDataTypeImport(columns));
			
			buffer.append("import ").append(Constant.PACKAGE).append(".")
			
			.append(Constant.Layered.MODEL.value.toLowerCase())
			
			.append(data.getClassName()).append("\n");
			
		} else if(Constant.Layered.IMPLIMENTS.value.equalsIgnoreCase(data.getLayered())) {
			
			buffer.append("import org.springframework.stereotype.Service;\n");
			
			buffer.append("import javax.annotation.Resource;\n");
			
			buffer.append("import ").append(Constant.PACKAGE).append(".")
			
			.append(Constant.Layered.MODEL.value.toLowerCase()).append(".")
			
			.append(data.getClassName()).append("\n");
			
		} else if(Constant.Layered.MAPPER.value.equalsIgnoreCase(data.getLayered())) {
			
			buffer.append("import ").append(Constant.PACKAGE).append(".")
			
			.append(Constant.Layered.MODEL.value.toLowerCase())
			
			.append(".")
			
			.append(data.getClassName()).append("\n");
		} 
		
		return buffer.toString();
	}
	
	
	private String buildDataTypeImport(List<Column> columns) {
		
		StringBuffer buffer = new StringBuffer();
		
		for( Column column : columns ) {
			
			if ("bigdecimal".equalsIgnoreCase(column.getPropertyType())) {
				
				buffer.append("import java.math.BigDecimal;\n");
				
			} 
			
		}
		
		return buffer.toString();
	}
}
