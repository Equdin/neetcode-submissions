class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // count the no. of occurreces
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // sort the occurrences into a bucket
        List<Integer>[] bucket = new ArrayList[n + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        // create the result array
        int[] res = new int[k];
        int index = 0;

        for (int freq = n; freq >= 1 && index < k; freq--) {
            if (bucket[freq] != null) {
                for (int num : bucket[freq]) {
                    res[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}
