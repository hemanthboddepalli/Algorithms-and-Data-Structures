//https://leetcode.com/problems/sliding-puzzle/
class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        int[][] directions = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>();
        String input = "";
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                input += board[i][j];
            }
        }
        queue.add(input);
        hs.add(input);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                String node = queue.remove();
                if (target.equals(node)) return res;
                int zero_index = node.indexOf("0");
                for (int direction : directions[zero_index]) {
                    String nextNode = swap(node, zero_index, direction);
                    if (!hs.contains(nextNode)) {
                        queue.add(nextNode);
                        hs.add(nextNode);
                    }
                }
                size--;
            }
            res++;
        }
        return -1;
    }
    
    public String swap(String node, int i, int j) {
        StringBuffer sb = new StringBuffer(node);
        sb.setCharAt(i, node.charAt(j));
        sb.setCharAt(j, node.charAt(i));
        return sb.toString();
    }
}
