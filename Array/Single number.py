Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

##################################### My SOlution ############################################## 
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        dicto= defaultdict(int)
        for i in range(len(nums)):
            dicto[nums[i]] +=1
         
        for i,j in dicto.items():
            if j == 1:
                return i
                
##################################################### Effective and sexy solution #############################################

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        a = 0
        for i in nums:
            a ^= i
        return a
