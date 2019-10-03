//https://leetcode.com/problems/minimum-window-substring/
class MinWindow {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        int min_distance = Integer.MAX_VALUE; 
        int min_index = 0;
        int left = 0; int count = 0;
        for (int right=0; right<s.length(); right++) {
            char c = s.charAt(right);
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) - 1);
                if (hm.get(c) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < min_distance) {
                        min_distance = right - left + 1;
                        min_index = left;
                    }
                    c = s.charAt(left);
                    if (hm.containsKey(c)) {
                        hm.put(c, hm.get(c) + 1);
                        if (hm.get(c) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        return min_distance == Integer.MAX_VALUE ? "" : s.substring(min_index, min_index + min_distance);
    }
}
