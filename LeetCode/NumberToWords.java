//https://leetcode.com/problems/integer-to-english-words/
class NumberToWords {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int quo = num / 1000000000;
        if (quo != 0) { 
            sb.append(convert(quo)).append(" Billion ");
        }
        num = num % 1000000000;
        quo = num / 1000000;
        if (quo != 0) { 
            sb.append(convert(quo)).append(" Million ");
        }
        num = num % 1000000;
        quo = num / 1000;
        if (quo != 0) { 
            sb.append(convert(quo)).append(" Thousand ");
        }
        num = num % 1000;
        if (num != 0) { 
            sb.append(convert(num));
        }
        return sb.toString().trim();
    }
    public String convert(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "One"); hm.put(2, "Two"); hm.put(3, "Three");
        hm.put(4, "Four"); hm.put(5, "Five"); hm.put(6, "Six");
        hm.put(7, "Seven"); hm.put(8, "Eight"); hm.put(9, "Nine");
        hm.put(10, "Ten"); hm.put(11, "Eleven"); hm.put(12, "Twelve");
        hm.put(13, "Thirteen"); hm.put(14, "Fourteen"); hm.put(15, "Fifteen");
        hm.put(16, "Sixteen"); hm.put(17, "Seventeen"); hm.put(18, "Eighteen");
        hm.put(19, "Nineteen"); hm.put(20, "Twenty"); hm.put(30, "Thirty");
        hm.put(40, "Forty"); hm.put(50, "Fifty"); hm.put(60, "Sixty");
        hm.put(70, "Seventy"); hm.put(80, "Eighty"); hm.put(90, "Ninety");
        while (num != 0) {
            if (num >= 1 && num <= 19) {
                sb.append(hm.get(num)+" ");
                break;
            }
            else if (num >= 20 && num <= 99) {
                int quo = num / 10;
                sb.append(hm.get(quo*10)+" ");
                num = num % 10;
            }
            else {
                int quo = num / 100;
                sb.append(hm.get(quo)+" Hundred ");
                num = num % 100;
            }
        }
        return sb.toString().trim();
    }
}
