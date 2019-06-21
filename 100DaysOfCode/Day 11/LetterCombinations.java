/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

*/

import java.util.*;

public class LetterCombinations {
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);input.add(2);input.add(3);
		Solution sol = new Solution();
		sol.letterCombinations("432");
		for (String item : sol.res) {
			System.out.println(item);
		}
	}
	ArrayList<String> res = new ArrayList<String>();
    public ArrayList<String> letterCombinations(String A) {
    	HashMap<Character, String> hm = new HashMap<Character, String>();
    	hm.put('2',"abc"); hm.put('3',"def"); hm.put('4',"ghi");
    	hm.put('5',"jkl"); hm.put('6',"mno"); hm.put('7',"pqrs");
    	hm.put('8',"tuv"); hm.put('9',"wxyz"); hm.put('1',"1");
    	hm.put('0',"0");
    	return letterCombinations(A, 0, new StringBuffer(), hm);
    }    
    public ArrayList<String> letterCombinations(String A, int start, StringBuffer sb, HashMap<Character, String> hm) {
    	if (sb.length() == A.length()) {
    		res.add(new String(sb.toString()));
    		return res;
    	}
    	for (int i = start; i < A.length();) {
    		String str = hm.get(A.charAt(i));
    		for (int j = 0; j < str.length(); j++) {
    			sb.append(str.charAt(j));
    			letterCombinations(A, start+1, sb, hm);
    			sb.deleteCharAt(sb.length() - 1);
    		}
    		return res;
    	}
    	return res;
    }
}
