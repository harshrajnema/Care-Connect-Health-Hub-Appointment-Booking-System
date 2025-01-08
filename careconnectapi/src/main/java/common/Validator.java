package common;

import java.util.Date;

public class Validator {

	public static boolean emptyCheck(String value) {
		if("".equals(value)) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean isPositiveNumber(float value) {
		if(value<1) {
			return false;
		}else {
			return true;
		}
	}
		
	
	public static boolean nullCheck(String value) {
		if(value == null) {
		return true;
	      }else {
		return false; 
	  }
	
    }
	public static boolean countCheck(String value) {
		int count = Integer.parseInt(value);
		if(count<0) {
			return true;
		}else {
			return false;
		}
	}

public static boolean nullDateCheck(Date value) {
		
		if(value == null) {
			return true;
		}else {
			return false;
		}
	}
}

