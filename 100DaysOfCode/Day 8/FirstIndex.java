/*
First Index of Number
Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. Return -1 if it is not present in the array.
First index means, the index of first occurrence of x in the input array.
Do this recursively. Indexing in the array starts from 0.
*/
public class FirstIndex {

	public static int firstIndex(int input[], int x) {
		return firstIndex(input, x, 0);		
	}
    
    public static int firstIndex(int input[], int x, int index) {
		    if (index == input.length) {
            return -1;
        }
        if (input[index] == x) {
            return index;
        }
        return firstIndex(input, x, ++index);		
	}
}
