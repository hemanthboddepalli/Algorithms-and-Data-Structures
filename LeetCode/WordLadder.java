//https://leetcode.com/problems/word-ladder/
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();        
        HashSet<String> wordSet = new HashSet<String>();
        for (String word : wordList) {
            wordSet.add(word);
        }        
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                String node = queue.remove();
                if (node.equals(endWord)) {
                    return level+1;
                }
                for (int i=0; i<node.length(); i++) {
                    List<String> nodeList = getNodeList(wordSet, node, i, visited);
                    for (String word: nodeList) {
                        queue.add(word);
                    }
                }
                size--;
            }
            level++;
        }
        return 0;
    }
    public List<String> getNodeList(HashSet<String> wordSet, String node, int index, HashSet<String> visited) {
        List<String> list = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            StringBuilder sb = new StringBuilder(node);
            sb.setCharAt(index, c);
            String word = sb.toString();
            if (!visited.contains(word) && wordSet.contains(word)) {
                list.add(word);
                visited.add(word);
            }
        }
        return list;
    }
}
