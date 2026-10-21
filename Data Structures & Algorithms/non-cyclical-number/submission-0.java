class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        while (n != 1) {
            if (map.containsKey(n)) {
                return false;
            } else {
                int sum = findSum(n);
                map.put(n, sum);
                n = sum;
            }
        }

        return true;
    }

    public int findSum(int k) {
        int sum = 0;
        while (k > 0) {
            sum += Math.pow(k % 10, 2);
            k /= 10;
        }

        return sum;
    }
}
