import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    int curr = 0; int max = -1;
    for (int i=0; i<str.length(); i++) {
      char c = str.charAt(i);
      if (hm.get(c) != null) {
        hm.put(c, hm.get(c)+1);
      }
      else {
        hm.put(c, 1);
      }
      while (hm.size() > k) {
        max = Math.max(max, i-curr);
        c = str.charAt(curr);
        if (hm.get(c) == 1) {
          hm.remove(c);
        }
        else {
          hm.put(c, hm.get(c)-1);
        }
        curr++;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }
}
