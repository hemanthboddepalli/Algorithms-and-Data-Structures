//https://leetcode.com/problems/meeting-rooms-ii/
class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int length = intervals.length;
        int[] start = new int[length];
        int[] end = new int[length];
        for (int i=0; i<length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        for (int i=0,j=0; i<length; i++) {
            if (start[i] < end[j]) {
                count++;
            }
            else {
                j++;
            }
        }
        return count;
    }
}
