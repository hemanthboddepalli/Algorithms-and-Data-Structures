//LRU Cache
//https://leetcode.com/problems/lru-cache/
class LRUCache {
    Node head, tail;
    Map<Integer, Node> hm;
    int capacity;
    public LRUCache(int capacity) {
        hm = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = hm.get(key);
        if (node != null) {
            updateNode(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = hm.get(key);
        if (node == null) {
            if (hm.size() >= capacity) {
                Node prev = tail.prev;
                removeNode(prev);
                hm.remove(prev.key);
            }
            Node curr = new Node(key, value);
            hm.put(key, curr);
            addNode(curr);
        }
        else {
            node.value = value;
            updateNode(node);
        }
    }
    
    private void addNode(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    private void updateNode(Node node) {
        removeNode(node);
        addNode(node);
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
