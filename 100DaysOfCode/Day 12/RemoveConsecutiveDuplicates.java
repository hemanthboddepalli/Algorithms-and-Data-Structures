/*
Remove Duplicates Recursively.
Given a string S, remove consecutive duplicates from it recursively.
*/

public class RemoveConsecutiveDuplicates {

	public static String removeConsecutiveDuplicates(String s) {
		if (s == null || s.length() <= 1) {
            return s;
        }
        String res = "";
        char prev = s.charAt(0);
        if (s.length() > 1) {
            res = removeConsecutiveDuplicates(s.substring(1));
        }
        if (prev != res.charAt(0)) {
            res = prev + res;
        }
        return res;
	}
}
