//https://leetcode.com/problems/lfu-cache/
class LFUCache {
    //key and node
    HashMap<Integer, Node> nodeMap = new HashMap<Integer, Node>();
    //frequency and DLL Node
    HashMap<Integer, DLLNode> freqMap = new HashMap<Integer, DLLNode>();    
    
    int capacity = 0, min = 0;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (nodeMap.get(key) != null) {
            Node node = nodeMap.get(key);
            updateFrequency(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = nodeMap.get(key);
        if (node != null) {
            node.value = value;
            updateFrequency(node);
        }
        else {
            DLLNode dllNode = null;
            if (nodeMap.size() >= capacity) {
                dllNode = freqMap.get(min);
                node = dllNode.removeLast();
                nodeMap.remove(node.key);
            }
            node = new Node(key, value);
            dllNode = freqMap.getOrDefault(node.count, new DLLNode());
            dllNode.add(node);
            nodeMap.put(key, node);
            freqMap.put(node.count, dllNode);
            min = 1;
        }
    }
    
    private void updateFrequency(Node node) {
        int count = node.count;
        // updating nodeMap
        node.count++;
        // removing from freqMap
        DLLNode dllNode = freqMap.get(count);
        dllNode.remove(node);
        // updating min
        if (min == count && dllNode.size == 0) min++;
        // adding to freqMap 
        dllNode = freqMap.getOrDefault(node.count, new DLLNode());
        dllNode.add(node);
        freqMap.put(node.count, dllNode);
    }
}

class Node {
    int count, key, value;
    Node next, prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.count = 1;
    }
}

class DLLNode {
    Node head, tail;
    int size = 0;
    public DLLNode() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        size++;
    }
    
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    
    public Node removeLast() {
        Node node = tail.prev;
        remove(node);
        return node;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
