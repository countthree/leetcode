public class Solution {
    public int findK(int[] A, int[] B, int sa, int sb, int k) {
        if (A.length - sa > B.length - sb)
            return findK(B, A, sb, sa, k);
        
        if (A.length == sa)
            return B[sb + k - 1];
            
        int i = Math.min(k / 2 + sa, A.length - 1);
        int j = k - 1 - (i - sa) + sb;
        
        int Ai_1 = ((i == sa) ? Integer.MIN_VALUE : A[i-1]);
        int Bj_1 = ((j == sb) ? Integer.MIN_VALUE : B[j-1]);
        int Ai   = ((i == A.length) ? Integer.MAX_VALUE : A[i]);
        int Bj   = ((j == B.length) ? Integer.MAX_VALUE : B[j]);
        
        if (Ai >= Bj_1 && Ai <= Bj)
            return A[i];
            
        if (Bj >= Ai_1 && Bj <= Ai)
            return B[j];
            
        if (Ai > Bj)
            return findK(A, B, sa, j + 1, k - (j - sb + 1));
        else
            return findK(A, B, i + 1, sb, k - (i - sa + 1));
    }
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        
        if ((m + n) % 2 == 1)
            return (double) findK(A, B, 0, 0, (m + n) / 2 + 1);
        else
            return (findK(A, B, 0, 0, (m + n) / 2) + findK(A, B, 0, 0, (m + n) / 2 + 1)) / 2.0;
    }
}