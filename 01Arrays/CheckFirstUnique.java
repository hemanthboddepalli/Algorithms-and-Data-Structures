/**
Given an array, find the first integer which is unique in the array. Unique means the number does not repeat and appears only once in the whole array. 
Implement your solution in Java and see if it runs correctly!
*/

class CheckFirstUnique
{
 public static int findFirstUnique(int[] arr) 
 {
    int result = 0;
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int i=0; i<arr.length; i++) {
      if (hm.get(arr[i]) != null) {
        hm.put(arr[i], hm.get(arr[i]) + 1);
      }
      else {
        hm.put(arr[i], 1);
      }
    }
    for (int i=0; i<arr.length; i++) {
      if (hm.get(arr[i]) <= 1) {
        return arr[i];
      }
    }
    return result;
 }
}
