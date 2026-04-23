class Solution:
    def smallestRepunitDivByK(self, k):
        # If k is divisible by 2 or 5, no repunit (1, 11, 111...) 
        # can ever be divisible by k.
        if k % 2 == 0 or k % 5 == 0:
            return -1
        
        remainder = 0
        # The maximum number of unique remainders modulo k is k.
        # By Pigeonhole Principle, if we don't find 0 within k steps, 
        # we never will (but our check above handles the impossible cases).
        for length in range(1, k + 1):
            # Form the next repunit remainder: (previous_remainder * 10 + 1) % k
            remainder = (remainder * 10 + 1) % k
            
            if remainder == 0:
                return length
                
        return -1