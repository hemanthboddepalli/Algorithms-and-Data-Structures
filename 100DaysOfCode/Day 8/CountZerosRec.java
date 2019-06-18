/*
Count Zeros
Given an integer n, count and return the number of zeros that are present in the given integer using recursion.
*/


public class CountZerosRec {

	public static int countZerosRec(int input){
        return countZerosRec(input, 0);
	}
    public static int countZerosRec(int input, int count){
        if (input == 0) {
            return count;
        }
    	if (input%10 == 0) {
            count++;
        }
        return countZerosRec(input/10, count);
    }
}
