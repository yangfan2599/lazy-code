package com.lazy.builder;

import com.lazy.constant.Constant;
import com.lazy.meta.Metadata;

public class Package  implements Builder {

	
	public String build(Metadata data) {
		
		return new StringBuffer("package ")
				
				.append(Constant.PACKAGE)
				
				.append(data.getLayered().toLowerCase())
				
				.append(";\n\n").toString();
		
	}

}
