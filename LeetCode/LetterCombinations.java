// LetterCombinations
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class LetterCombinations {
    Map<Character, String> hm = new HashMap<Character, String>();
    public List<String> letterCombinations(String digits) {
        hm.put('2',"abc"); hm.put('3',"def"); hm.put('4',"ghi");
        hm.put('5',"jkl"); hm.put('6',"mno"); hm.put('7',"pqrs");
        hm.put('8',"tuv"); hm.put('9',"wxyz");
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() < 1) {
            return res;
        }
        letters(digits, 0, res, "");
        return res;
    }
    
    public List<String> letters(String digits, int index, List<String> res, String str) {
        if (str.length() == digits.length()) {
            res.add(new String(str));
            return res;
        }
        for (int i=index; i<digits.length(); i++) {
            char c = digits.charAt(i);
            String s = hm.get(c);
            for (int j=0; j<s.length(); j++) {
                str = str + s.charAt(j);
                letters(digits, i+1, res, str);
                str = str.substring(0, str.length()-1);
            }
        }
        return res;
    }
}
