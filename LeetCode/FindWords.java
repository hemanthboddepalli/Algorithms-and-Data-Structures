//https://leetcode.com/problems/word-search-ii/
class FindWords {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        TrieNode root = getTrieNode(words);
        int rows = board.length, columns = board[0].length;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                dfs(board, rows, columns, i, j, root, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int rows, int columns, int i, int j, TrieNode node, List<String> res) {
        if (node.value != null) {
            res.add(node.value);
            node.value = null;
        }
        if (i < 0 || j < 0 || i >= rows || j >= columns) {
            return;
        }
        char c = board[i][j];
        if (c == '#' || node.children[c-'a'] == null) {
            return;
        }
        TrieNode tempNode = node.children[c-'a'];
        board[i][j] = '#';
        dfs(board, rows, columns, i+1, j, tempNode, res);
        dfs(board, rows, columns, i-1, j, tempNode, res);
        dfs(board, rows, columns, i, j+1, tempNode, res);
        dfs(board, rows, columns, i, j-1, tempNode, res);
        board[i][j] = c;
    }
    
    public TrieNode getTrieNode(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c-'a'] == null) {
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.value = word;
        }
        return root;
    }
}
class TrieNode {
    TrieNode[] children;
    String value;
    public TrieNode() {
        children = new TrieNode[26];
        value = null;
    }
}
