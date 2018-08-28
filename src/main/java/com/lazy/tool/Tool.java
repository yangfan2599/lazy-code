package com.lazy.tool;

import com.lazy.constant.Constant;

public class Tool {

	/**
	 * 加大括号
	 * @param content
	 * @return
	 */
	public static String addBracket(String content) {

		StringBuffer buffer = new StringBuffer();

		buffer.append(Constant.Symbol.LB.value).append(content).append(Constant.Symbol.RB.value);

		return buffer.toString();

	}
	
	/**
	 * 加小括号
	 * @param content
	 * @return
	 */
	public static String addBrace(String content) {

		StringBuffer buffer = new StringBuffer();

		buffer.append(Constant.Symbol.LP.value).append(content).append(Constant.Symbol.RP.value);

		return buffer.toString();

	}
	
}
