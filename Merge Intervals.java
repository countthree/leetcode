/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare (Interval i1, Interval i2) {
                if (i1.start != i2.start)
                    return i1.start - i2.start;
                
                return i1.end - i2.end;
            } 
        });
        
        ArrayList<Interval> res = new ArrayList<Interval>();
        
        Interval current = null;
        
        for (int i = 0; i < intervals.size(); ++i) {
            Interval it = intervals.get(i);

            if (current == null) {
                current = it;
            } else {
                if (current.start == it.start) {
                    current.end = it.end;
                } else if (current.end < it.start) {
                    res.add(current);
                    current = it;
                } else if (current.end < it.end) {
                    current.end = it.end;
                }
            }
        }
        
        if (current != null)
            res.add(current);
        
        return res;
    }
}