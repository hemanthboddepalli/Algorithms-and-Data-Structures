//https://leetcode.com/problems/word-squares/
class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        Map<String, List<String>> hm = new HashMap<String, List<String>>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(c);
                String key = sb.toString();
                if (!hm.containsKey(key)) {
                    hm.put(key, new ArrayList<String>());
                }
                hm.get(key).add(word);
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        for (String word : words) {
            list.add(word);
            wordSquares(hm, list, res, word.length());
            list.clear();
        }
        return res;
    }
    
    private void wordSquares(Map<String, List<String>> hm, List<String> list, List<List<String>> res, int length) {
        if (list.size() == length) {
            res.add(new ArrayList<String>(list));
            return;
        }
        int index = list.size();
        StringBuilder prefix = new StringBuilder();
        for (String word : list) {
            prefix.append(word.charAt(index));
        }
        String key = prefix.toString();
        if (hm.containsKey(key)) {
            List<String> words = hm.get(key);
            for (String word : words) {
                list.add(word);
                wordSquares(hm, list, res, length);
                list.remove(list.size()-1);
            }
        }
    }
}
