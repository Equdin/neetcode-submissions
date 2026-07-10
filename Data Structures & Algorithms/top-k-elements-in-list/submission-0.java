class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            -> 1. Sort the given array
            -> 2. Count the occurrences of integers in array and store it in a HashMap
            -> 3. To return the Max element from the HashMap
                -> i. Create a for loop for k times that calls maxElementInHashMap() function
                -> ii. create a function that takes the hashmap as parameter and returns the element with max occurrences and pops it
                
        */
        int[] array = nums;
        Arrays.sort(array);

        int[] result = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // // Define sorting logic using a lambda expression: compare priorities
        // PriorityQueue<HashMap<Integer, Integer>> elementQueue = new PriorityQueue<>(Collections.reverseOrder(), (t1, t2) -> Integer.compare(t1.elementCount, t2.elementCount));

        // elementQueue.offer(new Element(1, 2));
        // elementQueue.offer(new Element(2, 1));
        // elementQueue.offer(new Element(3, 3));

        for (int i = 0; i < k; i++) {
            result[i] = getMaxElement(map);
        }

        return result;
    }


    // This function takes a map as argument and finds the element with maximum occurrences and returns it. Also removes it from the map
    int getMaxElement(HashMap<Integer, Integer> map) {

        int maxElement = 0;
        int maxValue = 0;
        for (int i : map.keySet()) {
            if (map.get(i) >= maxValue) {
                maxValue = map.get(i);
                maxElement = i;
            }
        }

        map.remove(maxElement);
        return maxElement;
    }
}
