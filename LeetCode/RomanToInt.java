// Roman to Integer
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
class RomanToInt {
    public int romanToInt(String s) {
        if (s.length() < 1) {
            return 0;
        }
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1); hm.put('V', 5); hm.put('X', 10);
        hm.put('L', 50); hm.put('C', 100); hm.put('D', 500);
        hm.put('M', 1000);
        int res = 0; 
        char prev = s.charAt(s.length()-1);
        res = res + hm.get(prev);
        for (int i=s.length()-2; i>=0; i--) {
            char next = s.charAt(i);
            if (hm.get(next) >= hm.get(prev)) {
                res = res + hm.get(next);
            }
            else {
                res = res - hm.get(next);
            }
            prev = next;
        }
        return res;
    }
}
