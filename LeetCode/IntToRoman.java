//Integer to Roman
//https://leetcode.com/problems/integer-to-roman/submissions/
class IntToRoman {
    public String intToRoman(int num) {
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hun = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tho = {"", "M", "MM", "MMM"};
        return tho[num/1000] + hun[(num%1000)/100] + ten[(num%100)/10] + one[num%10];
    }
}
