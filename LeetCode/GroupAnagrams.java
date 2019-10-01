//https://leetcode.com/problems/group-anagrams/
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if (hm.get(key) != null) {
                List<String> groupList = hm.get(key);
                groupList.add(str);
                hm.put(key, groupList);
            }
            else {
                List<String> groupList = new ArrayList<String>();
                groupList.add(str);
                hm.put(key, groupList); 
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> value : hm.values()) {
            res.add(value);
        }
        return res;
    }
}
