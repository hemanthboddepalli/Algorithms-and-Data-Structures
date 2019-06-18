/*
Check Palindrome (recursive)
Check if a given String S is palindrome or not (using recursion). Return true or false.
*/


public class IsStringPalindrome {

	public static boolean isStringPalindrome(String input) {
		return isStringPalindrome(input, 0, input.length()-1);
	}
    
    public static boolean isStringPalindrome(String input, int start, int end) {
		if (start >= end) {
            return true;
        }        
        if (input.charAt(start) != input.charAt(end)){
            return false;
        }
        return isStringPalindrome(input, ++start, --end);
	}
}
