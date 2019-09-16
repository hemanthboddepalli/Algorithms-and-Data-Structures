//Reverse Words in a String
//https://leetcode.com/problems/reverse-words-in-a-string/
class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder(); 
        int length = s.length();
        int i = length-1;
        int j = length-1;
        while (i>=0) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (i != j) {
                    if (res.length() != 0) {
                        res.append(" ");
                    }
                    res.append(s.substring(i+1, j+1));
                    j = i;
                }
                j--;
            }
            i--;
        }
        if (i != j) {
            if (res.length() != 0) {
                res.append(" ");
            }
            res.append(s.substring(i+1, j+1));
            j = i;
        }
        return res.toString();
    }
}
