public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int []res = new int[2];
        
        for (int i = 0; i < numbers.length; ++i) {
            if (map.get(target-numbers[i]) != null) {
                res[0] = 1 + map.get(target-numbers[i]);
                res[1] = 1 + i;
                return res;
            }
            
            map.put(numbers[i], i);
        }
        
        return res;
    }
}