/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] dockIn = new int[n];
        int[] dockOut = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            dockIn[i] = intervals.get(i).start;
            dockOut[i] = intervals.get(i).end;
        }
        Arrays.sort(dockIn);
        Arrays.sort(dockOut);

        int in = 0;
        int out = 0;
        int curr = 0;
        while (out < n && in < n) {
            if (dockIn[in] < dockOut[out]) {
                curr++; 
                in++;
            } else {
                curr--;
                out++;
            }

            result = Math.max(result, curr);
        }

        return result;
    }
}
