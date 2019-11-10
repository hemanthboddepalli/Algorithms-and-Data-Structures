//https://leetcode.com/problems/top-k-frequent-words/
class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if (o1.count.compareTo(o2.count) == 0) {
					return o1.word.compareTo(o2.word);
				}
				return o2.count.compareTo(o1.count);
			}
            
        });
        
        Set<String> set = hm.keySet();
        for (String str : set) {
            queue.add(new Node(str, hm.get(str)));
        }
        List<String> res = new ArrayList<String>();
        for (int i=0; i<k; i++) {
        	res.add(queue.remove().word);
        }
		return res;
    }
}
class Node {
    String word;
    Integer count;
    public Node(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
