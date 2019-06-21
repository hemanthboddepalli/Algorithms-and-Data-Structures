/*
Replace Character Recursively
Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
Do this recursively.
*/


public class ReplaceCharacter {

	public static String replaceCharacter(String input, char c1, char c2) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
        if (input == null || input.length() == 0) {
            return input;
        }
        String res = "";
        char first = input.charAt(0);        
        if (input.length() > 1) {                    
            res = replaceCharacter(input.substring(1, input.length()), c1, c2);
        }
        res = (first == c1 ? c2 : first) + res;
        return res;
	}
}
