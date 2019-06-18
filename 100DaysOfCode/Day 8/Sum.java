// Sum of Array
// Given an array of length N, you need to find and return the sum of all elements of the array.
// Do this recursively.

import java.util.*;

public class Sum {

	public static int sum(int input[]) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		if (input.length == 0) {
            return 0;
        }
        int res = 0;
        res = input[0] + sum(Arrays.copyOfRange(input,1, input.length));
        return res;
	}
}
