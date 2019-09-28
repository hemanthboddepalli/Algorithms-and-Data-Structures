//https://leetcode.com/problems/is-subsequence/
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i=0, j=0;
        boolean found = true;
        while (i < s.length()) {
            char c = s.charAt(i);
            found = false;
            while (j < t.length()) {
                if (c == t.charAt(j)) {
                    found = true;
                    j++; 
                    break;
                }
                j++;
            }
            i++;
        }
        return found;
    }
}
