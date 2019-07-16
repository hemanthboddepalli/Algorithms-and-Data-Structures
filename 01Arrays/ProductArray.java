/**
Array of Products of All Elements Except Itself.
Given an array, return an array where each index stores the product of all numbers except the number on the index itself. 
Implement your solution in Java and see if your output matches the expected output!
*/

class ProductArray  
{  
  public static int[] findProduct(int arr[])  
  {    
    int [] result = new int[arr.length];
    int indexOfZero = -1; int product = 1;
    for (int i=0; i<arr.length; i++) {
        if (arr[i] == 0) {
            if (indexOfZero == -1) {
                indexOfZero = i;
            }
            else {
                return result;
            }
        }
        else {
            product = product * arr[i];
        }
    }
    for (int i=0; i<arr.length; i++) {
        if (indexOfZero == i) {
            result[i] = product;
        }
        else {
            if (indexOfZero == -1) {
                result[i] = product / arr[i];
            }
        }
    }
    return result; 
   } 
} 
