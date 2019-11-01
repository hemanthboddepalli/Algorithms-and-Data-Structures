//https://leetcode.com/problems/find-all-anagrams-in-a-string/
class FindAnagrams {
    public List<Integer> findAnagrams(String s2, String s1) {
        int length = s1.length();
        int low = 0, high = 0;
        int[] count = new int[26]; 
        int i=0;
        while (i < length) {
            count[s1.charAt(i)-'a']++;
            i++;
        }
        List<Integer> res = new ArrayList<Integer>();
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
                if (high-low+1 == length) {
                    res.add(low);
                    count[s2.charAt(low)-'a']++;
                    low++;
                }
            }
            high++;
        }
        return res;
    }
}
