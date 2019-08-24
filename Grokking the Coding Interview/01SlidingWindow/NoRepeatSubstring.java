class NoRepeatSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<Character>();
        int start = 0; int end = 0; int max = -1;
        while (end < s.length()) {
            char last = s.charAt(end);
            if (hs.contains(last)) {
                max = Math.max(max, end-start);
                char first = s.charAt(start);
                while (first != last) {
                    hs.remove(first);
                    start++;
                    first = s.charAt(start);
                }
                start++;
            }
            hs.add(last);
            end++;
        }
        max = Math.max(max, end-start);
        return max;
    }
}
