 public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval temp = newInterval;
        ArrayList<Interval> lst = new ArrayList<Interval>();
        
        for (Interval i : intervals) {
            if (i.end < temp.start) {
                lst.add(i);
            } else if (i.start > temp.end) {
                lst.add(temp);
                temp = i;
            } else {
                temp = new Interval(Math.min(temp.start, i.start), Math.max(temp.end, i.end));
            }
        }
        
        lst.add(temp);
        
        return lst;
    }
}