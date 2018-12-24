package com.lazy.builder;

import com.lazy.constant.Constant;
import com.lazy.converter.Converter;
import com.lazy.meta.Metadata;

public class Class implements Builder {

	
	public String build(Metadata data) {

		StringBuffer buffer = new StringBuffer();
		
		buildAnnotation(data,buffer);
					
		buffer.append(Constant.Qualifier.PUBLIC.value)

				.append(Constant.SPACE)
				
				.append(Constant.Keyword.CLASS.value)

				.append(Constant.SPACE)
				
				.append(data.getClassName());

		if(!Constant.Layered.MODEL.value.equalsIgnoreCase(data.getLayered())) {
			
			buffer.append(data.getLayered());
			
		}
		
		return buffer.toString();

	}

	
	private void buildAnnotation(Metadata data,StringBuffer buffer) {
		
		
		if(Constant.Layered.CONTROLLER.value.equalsIgnoreCase(data.getLayered())) {
			
			buffer.append(Constant.Annotation.RESTCONTROLLER.value)
			
			.append("\n")
			
			.append(Constant.Annotation.REQUESTMAPPING.value)
			
			.append("(\"/")
			
			.append(data.getLowerClassName())
			
			.append("\")").append("\n");
			
		} else if(Constant.Layered.IMPLIMENTS.value.equalsIgnoreCase(data.getLayered())) {
			
			buffer.append(Constant.Annotation.SERVICE.value)
			
			.append("(\"")
			
			.append(Converter.toFirstLowweCase(data.getServiceClassName()))
			
			.append("\")")
			
			.append("\n");

		}
	}
	
	public static void main(String[] args) {
		
	}
}
