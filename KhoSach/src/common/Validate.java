/*
 * @author VTA
 * @date Apr 17, 2020
 * @version 1.0
 */

package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	

	public static boolean checkNumberPhone(String number) {
		Pattern pattern = Pattern.compile("[0-9]*$");
		Matcher matcher = pattern.matcher(number);
		if (!matcher.matches()) {
			return false;
		} else if (number.length() <= 11 && number.length() >= 10)
			return true;
		else
			return false;
	}

	public static boolean checkName(String name) {
		if (name != null) {
			return true;
		}
		return false;
	}

	public static boolean checkDiaChi(String diaChi) {
		if (diaChi != null) {
			return true;
		}
		return false;
	}
	public boolean checkEmail(String email) {
		String email_regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(email_regex);
	}
	public boolean checkSDT(String sdt) {
		String pattern="(09|03|07|08|05)+[0-9]{8}";
		return sdt.matches(pattern);
	}
}
