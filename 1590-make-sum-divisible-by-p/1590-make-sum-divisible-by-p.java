import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) total += num;
        
        int r = (int)(total % p);
        if (r == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        long prefix = 0;
        int minLen = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            
            int target = (int)((prefix - r + p) % p);
            
            if (map.containsKey(target)) {
                minLen = Math.min(minLen, i - map.get(target));
            }
            
            map.put((int)prefix, i);
        }
        
        return minLen == nums.length ? -1 : minLen;
    }
}