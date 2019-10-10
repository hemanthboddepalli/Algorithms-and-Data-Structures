//https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/
class NumKLenSubstrNoRepeats {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int res = 0;
        if (s == null || s.length() == 0) return res;
        HashSet<Character> hs = new HashSet<Character>();
        int j = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (hs.contains(c)) {
                char p = s.charAt(j);
                while (c != p) {
                    hs.remove(p);
                    j++;
                    p = s.charAt(j);
                }
                hs.remove(p);
                j++;
            }
            hs.add(c);
            if (hs.size() == k) {
                res++;
                char p = s.charAt(j);
                hs.remove(p);
                j++;
            }
        }
        return res;
    }
}
