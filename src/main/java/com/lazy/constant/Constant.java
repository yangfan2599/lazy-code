package com.lazy.constant;

public class Constant {

	/**
	 * 
	 * @author Lazy-bird
	 * 注解
	 */
	public static enum Annotation {

		CL("@Controller"), RC("@RestController"), RS("@Resource"), RM("@RequestMapping"), SC("@Service"), OR("@Override");

		public String value;

		private Annotation(String value) {
			
			this.value = value;
			
		}
		
	}

	/**
	 * 
	 * @author Lazy-bird
	 *	方法名前缀
	 */
	public static enum Method {

		CC("save"), CR("search"), CU("modify"), CD("remove"),SC("insert"), SR("select"), SU("update"), SD("delete");

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

		LB(" {\r "), RB(" \r} "), LP(" ( "), RP(" ) ");

		public String value;

		private Symbol(String value) {
			
			this.value = value;
			
		}
		
	}
	
	/**
	 * 
	 * @author Lazy-bird
	 *	关键字
	 */
	public static enum Keyword {

		IF(" interface "), CS(" class "), VD(" void "), BK("break");

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

		LP("private "), RP("public "), PT("protected "), DF("default ");

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
	public static enum DataType {

		BT(" Byte "), LP(" Integer "), RP(" Long "), PT(" Float "), DF(" Double ");

		public String value;

		private DataType (String value) {
			
			this.value = value;
			
		}
		
	}
	/**
	 * 
	 * @author Lazy-bird
	 *	关键字
	 */
	public static enum Mark {

		CM(" , "), SM(" : "), CO(";"), LS(" < "), MO(" > "), EQ(" == "), AS(" = "), AD(" + "),ST(" - ");

		public String value;

		private Mark (String value) {
			
			this.value = value;
			
		}
		
	}
}
