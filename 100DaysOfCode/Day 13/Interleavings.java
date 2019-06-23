/*
Interleavings
Given two strings S (of length m) and T (of length n), you need to find and 
print out all the possible inter leavings that are possible of length (m + n).
Inter leaving means - all possible combination of characters from both strings 
such that it contain all characters from both strings and, the respective ordering of 
characters of one string should remain same as in original.
*/


public class Interleavings {

	
	public static void interleavings(String first, String second){
		interleavings(first, second, "");
	}
    
    public static void interleavings(String first, String second, String res){
		if (first.length() == 0 && second.length() == 0) {
            System.out.println(res);
        }
        
        if (first.length() > 0) {
            interleavings(first.substring(1), second, res+first.charAt(0));
        }
        
        if (second.length() > 0) {
            interleavings(first, second.substring(1), res+second.charAt(0));
        }
	}
	
}
