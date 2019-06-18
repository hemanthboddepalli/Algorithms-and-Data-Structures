/*
Geometric Sum
Given k, find the geometric sum i.e.
1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 
using recursion. Return the answer.

*/


public class FindGeometricSum {

	public static double findGeometricSum(int k){
		if (k == 0) {
            return 1.0;
        }
        return 1.0/Math.pow(2,k) + findGeometricSum(k-1);
	}
}
