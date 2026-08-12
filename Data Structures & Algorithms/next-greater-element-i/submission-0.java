class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> indexMap = new HashMap<>(n);
        Deque<Integer> stack = new ArrayDeque<>(n);
        
        // Initialise
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            indexMap.put(nums1[i], i);
        }

        for (int i = 0; i < m; i++) {
            int num = nums2[i];

            if (indexMap.containsKey(num)) {
                stack.push(num);
            }

            while (!stack.isEmpty() && num > stack.peek()) {
                result[indexMap.get(stack.peek())] = num;
                stack.pop();
            }
        }
        
        return result;
    }
}

/*
0. initialise result to -1s
1. create a hashmap that maps the nums1 elements with their index: {element of nums1, index of element in nums2}
2. traverse nums2
    - if nums2[i] not in numsMap
        -- continue
    - while (!stack.isEmpty() && nums2[i] > stack.peek())
        -- result[numsMap.get(nums2[i])] = i
        -- stack.pop()

    - stack.push(nums2[i])
3. return result
*/