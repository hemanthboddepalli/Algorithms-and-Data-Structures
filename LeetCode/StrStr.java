//Implement strStr().
//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//https://leetcode.com/problems/implement-strstr/

class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i=0; i<=haystack.length()-needle.length(); i++) {
            for (int j=0; j<needle.length() && (haystack.charAt(i+j) == needle.charAt(j)); j++) {
                if (j == needle.length()-1) {
                   return i;
                }
            }
        }
        return -1;
    }
}
