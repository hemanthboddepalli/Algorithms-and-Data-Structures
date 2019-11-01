//https://leetcode.com/problems/permutation-in-string/

class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        int low = 0, high = 0;
        int[] count = new int[26]; 
        int i=0;
        while (i < length) {
            count[s1.charAt(i)-'a']++;
            i++;
        }
        while (high < s2.length()) {
            char c = s2.charAt(high);
            if (count[c-'a'] <= 0) {
                while (c != s2.charAt(low)) {
                    count[s2.charAt(low)-'a']++;
                    low++;
                }
                low++;
            }
            else {
                count[c-'a']--;
                if (high-low+1 == length) return true;
            }
            high++;
        }
        return false;
    }
}
