class Solution {
    public int calPoints(String[] operations) {

        int[] scores = new int[operations.length];
        int k = 0;
        int sum = 0;

        for (int i = 0; i < operations.length; i++) {
            String opr = operations[i];

            if (opr.equals("+")) {
                scores[k] = scores[k - 1] + scores[k - 2];
                sum += scores[k];
                k++;
            } else if (opr.equals("D")) {
                scores[k] = 2 * scores[k - 1];
                sum += scores[k];
                k++;
            } else if (opr.equals("C")) {
                sum -= scores[k - 1];
                scores[k - 1] = 0;
                k--;
            } else {
                scores[k] = Integer.valueOf(opr);
                sum += scores[k];
                k++;
            }
        }

        return sum;
    }
}