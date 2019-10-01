//https://leetcode.com/problems/longest-palindromic-substring/
class LongestPalindrome {
    int max = Integer.MIN_VALUE; int index = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i=0; i<s.length(); i++) {
            longestPalindrome(s, i, i);
            longestPalindrome(s, i, i+1);
        }
        return s.substring(index, index + max + 1);
    }
    public void longestPalindrome(String s, int i, int j) {
        while (i>=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--; j++;
        }
        i++; j--;
        if (j - i > max) {
            max = j - i;
            index = i;
        }
    }
}
