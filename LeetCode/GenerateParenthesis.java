//https://leetcode.com/problems/generate-parentheses/
class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, new ArrayList<String>(), 0, 0, "");
    }
    public List<String> generateParenthesis(int n, List<String> res, int open, int close, String str) {
        if (str.length() == n*2) {
            res.add(new String(str));
            return res;
        }
        if (open < n) {
            generateParenthesis(n, res, open+1, close, str+'(');
        }
        if (close < open) {
            generateParenthesis(n, res, open, close+1, str+')');
        }
        return res;
    }
    
}
