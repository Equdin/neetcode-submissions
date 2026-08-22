class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Find the minimum arrray
        int[] A, B;
        int m, n;
        if (nums1.length < nums2.length) {
            A = nums1;
            m = nums1.length;
            B = nums2;
            n = nums2.length;
        } else {
            A = nums2;
            m = nums2.length;
            B = nums1;
            n = nums1.length;
        }

        int total = m + n;
        int half = total / 2;

        // Find the correct parition
        int left = 0;
        int right = m - 1;
        while (true) {
            int midA = (int) Math.floor((left + right) / 2.0); // partition for A
            // OR int midA = Math.floorDiv(left + right, 2);
            int midB = half - midA - 2; // partition for B

            // if (low < 0) {
            //     double Aleft = Integer.MIN_VALUE;
            // } else {
            //     double Aleft = A[midA];
            // } OR
            int aLeft = (midA >= 0) ? A[midA] : Integer.MIN_VALUE;
            int aRight = ((midA + 1) < m) ? A[midA + 1] : Integer.MAX_VALUE;

            int bLeft = (midB >= 0) ? B[midB] : Integer.MIN_VALUE;
            int bRight = ((midB + 1) < n) ? B[midB + 1] : Integer.MAX_VALUE;
            
            // If partition is correct
            if (aLeft <= bRight && bLeft <= aRight) {    
                // if total is odd
                if (total % 2 != 0) {
                    return 1.0 * Math.min(aRight, bRight);
                }
                
                return ((double) Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
            } else if (aLeft > bRight) {
                right = midA - 1;
            } else {
                left = midA + 1;
            }
        }
    }
}

/*
1. find the smaller array
2. Find Correct partition:
    i. To find partition
    ii. To find whether partition is correct or not
3. return mid
    i. if total is odd return min(a + 1, b + 1)
    ii. else return {max(a, b) + min(a + 1, b + 1)} / 2
*/
