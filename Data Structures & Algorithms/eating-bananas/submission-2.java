class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);    
        }
        
        int result = max;
        int low = 0;
        int high = max - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int time = 0;

            for (int i : piles) {
                time += Math.ceil(1.0 * i / mid);
            }

            if (time <= h) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else if (time > h){
                low = mid + 1;
            }
        }

        return result;
    }
}
