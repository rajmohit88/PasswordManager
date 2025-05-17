package com.example.PasswordManager.util;

public class CryptUtil {

    public static boolean isUpper(char x) {
        if ('A' <= x && x <= 'Z') return true;
        return false;
    }

    public static boolean isLower(char x) {
        if ('a' <= x && x <= 'z') return true;
        return false;
    }

    public static boolean isDigit(char x) {
        if ('0' <= x && x <= '9') return true;
        return false;
    }
    public static String encrypt(String password) {
		StringBuilder sb = new StringBuilder("");
		for(char i: password.toCharArray()) {
			if(isUpper(i)) {
				// i -> upper case 
				int val = i-'A';
				char newChar = (char)((char)((val+5)%26)+'A');
				sb.append(newChar);
			}
			else if(isLower(i)) {
				int val = i-'a';
				char newChar = (char)((char)((val+5)%26)+'a');
				sb.append(newChar);
			}
			else if(isDigit(i)) {
				int val = i-'0';
				char newChar = (char)((char)((val+5)%10)+'0');
				sb.append(newChar);
			}
			else {
				sb.append(i);
			}
		}
		return sb.toString();
	}

    public static String decrypt(String encrypPassword) {
		StringBuilder sb = new StringBuilder("");
		for(char i: encrypPassword.toCharArray()) {
			if(isUpper(i)) {
				int val = i-'A';
				char newChar = (char)((char)((val-5+26)%26)+'A');
				sb.append(newChar);
			}
			else if(isLower(i)) {
				int val = i-'a';
				char newChar = (char)((char)((val-5+26)%26)+'a');
				sb.append(newChar);
			}
			else if(isDigit(i)) {
				int val = i-'0';
				char newChar = (char)((char)((val-5+10)%10)+'0');
				sb.append(newChar);
			}
			else {
				sb.append(i);
			}
		}
		return sb.toString();
		
	}

   
}