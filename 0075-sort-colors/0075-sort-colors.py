class Solution:
    def sortColors(self, nums):

        low = 0
        mid = 0
        high = len(nums) - 1

        while mid <= high:

            # If element is 0
            if nums[mid] == 0:
                nums[low], nums[mid] = nums[mid], nums[low]
                low += 1
                mid += 1

            # If element is 1
            elif nums[mid] == 1:
                mid += 1

            # If element is 2
            else:
                nums[mid], nums[high] = nums[high], nums[mid]
                high -= 1