//Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length < 1) {
            return "";
        }
        String str_prev = strs[0]; 
        int prev_length = str_prev.length();
        for (int i=1; i<length; i++) {
            String str_next = strs[i];
            int next_length = str_next.length();
            int count = 0;
            if (next_length < prev_length) {
                for (int j=0; j<next_length; j++) {
                    if (str_prev.charAt(j) != str_next.charAt(j)) {
                        break;
                    }
                    count++;
                }
            }
            else {
                for (int j=0; j<prev_length; j++) {
                    if (str_prev.charAt(j) != str_next.charAt(j)) {
                        break;
                    }
                    count++;
                }                
            }
            str_prev = str_next;
            prev_length = count;
        }
        return str_prev.substring(0, prev_length);
    }
}
