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
	 *	方法名
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
	 *	方法名
	 */
	public static enum Symbol {

		LB(" {\r "), RB(" \r} "), LP(" ( "), RP(" ) ");

		public String value;

		private Symbol(String value) {
			this.value = value;
		}
		
	}
	
	
}
