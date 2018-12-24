package com.lazy.constant;

public class Constant {
	
	public static final String PACKAGE = "com.frame.";

	public final static String SPACE = " ";
	

	/**
	 * 
	 * @author Lazy-bird
	 *	方法名前缀
	 */
	public static enum Method {

		SAVE("save"), QUERY("query"), MODIFY("modify"),DETAIL("detail"), REMOVE("remove"),
		
		INSERT("insert"), SELECT_BY_KEY("select"), SELECT_BY_CONDITION("selectByCondition"), 
		
		 SELECT_BY_PAGE("selectByPage"), UPDATE("update"), DELETE("delete");

		public String value;

		private Method(String value) {
			
			this.value = value;
			
		}
		
	}
	
	/**
	 * 
	 * @author Lazy-bird
	 *	括号
	 */
	public static enum Symbol {

		LB(" {\r "), RB(" \r} "), LP("("), RP(")"), NL("\r");

		public String value;

		private Symbol(String value) {
			
			this.value = value;
			
		}
		
	}
	
	/**
	 * 
	 * @author Lazy-bird
	 *	括号
	 */
	public static enum Annotation {

		RESTCONTROLLER("@RestController"), SERVICE("@Service"), REQUESTMAPPING("@RequestMapping");

		public String value;

		private Annotation(String value) {
			
			this.value = value;
			
		}
		
	}
	
	/**
	 * 
	 * @author Lazy-bird
	 *	关键字
	 */
	public static enum Keyword {

		INTERFACE("interface "), CLASS("class "), VOID("void "), BREAK("break");

		public String value;

		private Keyword (String value) {
			
			this.value = value;
			
		}
		
	}
	
	/**
	 * 
	 * @author Lazy-bird
	 *	关键字
	 */
	public static enum Qualifier {

		PRIVATE("private "), PUBLIC("public "), PROTECTED("protected "), DEFAULT("default ");

		public String value;

		private Qualifier (String value) {
			
			this.value = value;
			
		}
		
	}
	
	/**
	 * 
	 * @author Lazy-bird
	 *	数据类型
	 */
	public static enum PropertyType {

		BYTE("Byte"), INTEGER("Integer"), LONG("Long"), FLOAT("Float"), 
		
		DOUBLE("Double"), BIGDECIMAL(" BigDecimal"), STRING("String"), 
		
		TIMESTAMP("Timestamp") , DATE("Date"), BOOLEAN("Boolean");

		public String value;

		private PropertyType (String value) {
			
			this.value = value;
			
		}
		
	}
	
	
	/**
	 * 
	 * @author Lazy-bird
	 *	分层
	 */
	public static enum Layered {

		CONTROLLER("Controller"), SERVICE("Service"), IMPLIMENTS("ServiceImpl"), MAPPER("Mapper"), MODEL("Model");

		public String value;

		private Layered (String value) {
			
			this.value = value;
			
		}
		
	}
	
}
