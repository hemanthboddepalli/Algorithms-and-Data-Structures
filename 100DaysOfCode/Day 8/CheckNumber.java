/* Check Number
Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.
Do this recursively*/

public class CheckNumber {
	
	public static boolean checkNumber(int input[], int x) {
        return checkNumber(input, x, 0);
	}
    
    public static boolean checkNumber(int input[], int x, int index) {
        if (index == input.length){
            return false;
        }       
        if (input[index] == x) {
            return true;
        }        
        return checkNumber(input, x, ++index);
	}
}
