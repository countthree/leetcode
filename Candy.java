public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int sum = 1;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            } else if (ratings[i] < ratings[i-1]) {
                candy[i] = 1;
                
                int j = i;
                while (j >= 1 && ratings[j-1] > ratings[j] && candy[j] == candy[j-1]) {
                    ++sum;
                    ++candy[j-1];
                    --j;
                }
            } else {
                candy[i] = 1;
            }
            
            sum += candy[i];
        }
        
        return sum;
    }
}