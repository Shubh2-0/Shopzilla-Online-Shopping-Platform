package com.masai.CommanCode;

public class Common {

	public static String nameFormat(String name) {

		name = (name.charAt(0) + "").toUpperCase() + (name.substring(1, name.length()).toLowerCase());

		return name;

	}

	public static boolean checkPasswordLength(String password) {

		if (password.length() < 7)
			return true;

		else if (password.length() > 12)
			return true;

		else
			return false;

	}

	public static boolean checkPasswordHaveSpace(String password) {

		int s = 0;

		for (int i = 0; i < password.length(); i++) {

			if ((password.charAt(i) + "").equals(" "))
				s++;

		}

		if (s > 4)
			return true;

		else
			return false;

	}

	public static boolean checkPhoneNumber(String phone) {

		String small = "abcdefghijklmnopqrstuvwxyz";
		String upper = "abcdefghijklmnopqrstuvwxyz";
		String num = "1234567890";
		int c = 0;
		for (int i = 0; i < phone.length(); i++) {

			String el = phone.charAt(i) + "";
			if (small.indexOf(el) != -1 || upper.indexOf(el) != -1)
				return true;

			if (num.indexOf(phone.charAt(i)) != -1)
				c++;

		}

		if (c != phone.length())
			return true;

		return false;

	}

	public static boolean checkBalance(String balance) {

		String num = "1234567890";
		int c = 0;
		for (int i = 0; i < balance.length(); i++) {

			if (num.indexOf(balance.charAt(i)) != -1)
				c++;

		}

		if (c != balance.length())
			return true;

		else
			return false;

	}

	public static double getUptoTwoDecimal(double amount) {

		amount = Math.round(amount * 100.0) / 100.0;

		return amount;

	}

}
