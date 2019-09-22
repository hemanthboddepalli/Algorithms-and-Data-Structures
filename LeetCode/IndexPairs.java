//https://leetcode.com/problems/index-pairs-of-a-string/
class IndexPairs {
	Trie trie = new Trie();
    public int[][] indexPairs(String text, String[] words) {
    	for (String str : words) {
    		Trie node = trie;
    		for (int i=0; i<str.length(); i++) {
    			char c = str.charAt(i);
    			if (node.children[c-'a'] == null) {
    				node.children[c-'a'] = new Trie();
    			}
    			node = node.children[c-'a'];
    		}
    		node.isEnd = true;
    	}
    	List<int[]> resList = new ArrayList<int[]>();
    	int length = text.length();
    	for (int i=0; i<length; i++) {
    		Trie curr = trie;
    		char c = text.charAt(i);
    		int j = i;
    		while (curr.children[c-'a'] != null) {
    			curr = curr.children[c-'a'];
    			if (curr.isEnd) {
    				resList.add(new int[]{i,j});
    			}
    			j++;
    			if (j == length) break;
    			c = text.charAt(j);
    		}
    	}
        int[][] res = new int[resList.size()][2];
        int i=0;
        for (int[] pair : resList) {
        	res[i] = pair;
        	i++;
        }
        return res;
    }
    class Trie {
    	Trie[] children;
    	boolean isEnd;
    	public Trie() {
    		children = new Trie[26];
    	}
    }
}
