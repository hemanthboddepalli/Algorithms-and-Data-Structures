//https://leetcode.com/problems/time-based-key-value-store/
class TimeMap {
    HashMap<String, TreeMap<Integer, String>> hm = null;
    /** Initialize your data structure here. */
    public TimeMap() {
        hm = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!hm.containsKey(key)) {
            hm.put(key, new TreeMap<Integer, String>());
        }
        hm.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        String res = null;
        Integer floor_key = null;
        if (hm.containsKey(key)) {
            TreeMap<Integer, String> tree = hm.get(key);
            floor_key = tree.floorKey(timestamp);
            if (floor_key != null) {
                res = tree.get(floor_key);
            }
        }
        return res == null ? "" : res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
