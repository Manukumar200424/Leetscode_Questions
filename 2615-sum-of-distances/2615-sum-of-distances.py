from collections import defaultdict

class Solution:
    def distance(self, nums):
        n = len(nums)
        arr = [0] * n
        
        # 1. Group all indices by their value
        # Example: {1: [0, 2, 3], 3: [1], 2: [4]}
        indices_map = defaultdict(list)
        for i, val in enumerate(nums):
            indices_map[val].append(i)
        
        # 2. Process each group of identical values
        for val in indices_map:
            indices = indices_map[val]
            k = len(indices)
            
            # If a number appears only once, distance is 0 (already in arr)
            if k <= 1:
                continue
            
            # 3. Use Prefix Sum logic to calculate distances in O(k) time
            total_sum = sum(indices)
            prefix_sum = 0
            
            for i, idx in enumerate(indices):
                # Count of elements to the left is 'i'
                # Count of elements to the right is '(k - 1 - i)'
                
                # Left side: (count * current_idx) - (sum of previous indices)
                left_dist = (i * idx) - prefix_sum
                
                # Right side: (sum of remaining indices) - (count * current_idx)
                right_sum = total_sum - prefix_sum - idx
                right_dist = right_sum - ((k - 1 - i) * idx)
                
                # Store the combined result
                arr[idx] = left_dist + right_dist
                
                # Update prefix_sum for the next element in the group
                prefix_sum += idx
                
        return arr