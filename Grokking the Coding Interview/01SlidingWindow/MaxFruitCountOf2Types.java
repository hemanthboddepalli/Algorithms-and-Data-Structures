class MaxFruitCountOf2Types {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int start = 0; int max = 0; int end=0;
        while (end<tree.length) {
            int fruit = tree[end];
            if (hm.get(fruit) != null) {
                hm.put(fruit, hm.get(fruit) + 1);
            }
            else {
                hm.put(fruit, 1);
            }
            while (hm.size() > 2) {
                max = Math.max(max, end-start);
                fruit = tree[start];
                hm.put(fruit, hm.get(fruit) - 1);
                if (hm.get(fruit) == 0) {
                    hm.remove(fruit);
                }
                start++;
            }
            end++;
        }
        max = Math.max(max, end-start);
        return max;
    }
}
