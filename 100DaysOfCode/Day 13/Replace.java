/*
Replace pi (recursive)
Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".
*/

public class Replace {

	// Return the changed string
	public static String replace(String input){
		if (input.length() == 2) {
            if (input.equals("pi"))
                return "3.14";
            return input;
        }
        String res = "";
        char ch = input.charAt(0);
        res = replace(input.substring(1));
        res = ch + res;
        if ("pi".equals(res.substring(0,2))) {
            res = res.substring(2);
            res = "3.14" + res;
        }
        return res;
	}
}
