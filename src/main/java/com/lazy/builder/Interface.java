package com.lazy.builder;

import com.lazy.constant.Constant;
import com.lazy.meta.Metadata;

public class Interface implements Builder {

	public String build(Metadata data) {

		return new StringBuffer()

				.append(Constant.Qualifier.PUBLIC.value)

				.append(Constant.Keyword.INTERFACE.value)

				.append(data.getClassName())
				
				.append(Constant.Layered.SERVICE.value).toString();

	}

}
