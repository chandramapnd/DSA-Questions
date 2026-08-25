class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int removals = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // Overlap → remove current interval
                removals++;
            } else {
                // No overlap → keep current interval
                end = intervals[i][1];
            }
        }

        return removals;
    }
}