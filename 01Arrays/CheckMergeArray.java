/**
In this problem, you have to implement the int[] mergeArrays(int[] arr1, int[] arr2) 
function which returns an array consisting of all elements of both arrays in a sorted way.
*/

class CheckMergeArray 
{ 
    // merge arr1 and arr2 into a new result array 
    public static int[] mergeArrays(int[] arr1, int[] arr2) 
    {  
      int[] res = new int[arr1.length + arr2.length];
      int i = 0, j = 0, k = 0;
      while (i < arr1.length && j < arr2.length) {
          if (arr1[i] < arr2[j]) {
              res[k] = arr1[i];
              i++;
          }
          else {
              res[k] = arr2[j];
              j++;
          }
          k++;
      }
      while (i < arr1.length) {
          res[k] = arr1[i];
          i++;k++;
      }
      while (j < arr2.length) {
          res[k] = arr2[j];
          j++;k++;
      }
      return res; // make a new resultant array and return your results in that
    } 
}
