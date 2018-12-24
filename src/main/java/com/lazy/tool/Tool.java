package com.lazy.tool;

import java.util.Collection;

import com.lazy.constant.Constant;

public class Tool {

	/**
	 * 加大括号
	 * 
	 * @param content
	 * @return
	 */
	public static StringBuffer addBracket(StringBuffer content) {

		StringBuffer buffer = new StringBuffer();

		buffer.append(Constant.Symbol.LB.value).append(content).append(Constant.Symbol.RB.value);

		return buffer;

	}

	/**
	 * 加小括号
	 * 
	 * @param content
	 * @return
	 */
	public static StringBuffer addBrace(StringBuffer content) {

		StringBuffer buffer = new StringBuffer();

		buffer.append(Constant.Symbol.LP.value).append(content).append(Constant.Symbol.RP.value);

		return buffer;

	}
	
	public static boolean isNotEmpty(Object o) {
		
		if (o == null) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}

	public static boolean isNotEmpty(Collection<?> c) {
		
		if (c == null || c.size() == 0) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}

	public static void main(String[] args) {
	}

}
