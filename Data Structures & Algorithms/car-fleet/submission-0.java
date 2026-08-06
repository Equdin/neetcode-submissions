class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        Deque<Double> stack = new ArrayDeque<>(n);

        // 1. Initialise the car's position and speed
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // 2. Sorting the cars
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        // 3. For each car
        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            if (stack.size() < 1) {
                stack.push(time);
            } else {
                double previous = stack.peek();

                if (time > previous) {
                    stack.push(time);
                }
            }
        }

        return stack.size();
    }
}
