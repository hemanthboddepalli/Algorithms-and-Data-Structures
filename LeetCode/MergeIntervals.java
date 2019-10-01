//https://leetcode.com/problems/merge-intervals/
class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> res = new ArrayList<int[]>();
        int[] interval = new int[2];
        interval[0] = intervals[0][0];
        interval[1] = intervals[0][1];
        res.add(interval);
        for (int i=1; i<intervals.length; i++) {
            if (interval[1] >= intervals[i][0]) {
                interval[1] = Math.max(interval[1], intervals[i][1]);
            }
            else {
                interval = new int[2];
                interval[0] = intervals[i][0];
                interval[1] = intervals[i][1];
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
