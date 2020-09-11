Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

################################################################################# SOLUTION #######################################################################
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        maxval=nums[0]
        imax,imin=1,1
        for i in range(len(nums)):
            if nums[i]<0:
                imax,imin=imin,imax
            imax=max(imax*nums[i],nums[i])
            imin=min(imin*nums[i],nums[i])
            maxval=max(maxval,imax)
        return maxval
