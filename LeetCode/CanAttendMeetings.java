// https://leetcode.com/problems/meeting-rooms/
// Meeting Rooms
class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] interval = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            if (interval[1] > intervals[i][0]) {
                return false;
            }
            else {
                interval = intervals[i];
            }
        }
        return true;
    }
}
