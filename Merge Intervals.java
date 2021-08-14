// https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> list = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int start = intervals[0][0], end = intervals[0][1];
        
        for(int []loop : intervals)
        {
            if(loop[0] >= start && loop[0] <= end)
            {
                end = Math.max(end, loop[1]);
            }
            else
            {
                list.add(new int[]{start, end});
                start = loop[0];
                end = loop[1];
            }
        }
        list.add(new int[]{start, end});
        
        return list.toArray(new int[0][]);
    }
}
