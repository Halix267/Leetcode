Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

####################################################### Solution #####################################################################################
from operator import add
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)==0 or len(nums2)==0:
            return []
        result=[]
        dicto=defaultdict(int)
        ficto = defaultdict(int)
        if len(nums1)>len(nums2):
            nums1,nums2=nums2,nums1
        for i in range(len(nums1)):
            dicto[nums1[i]]+=1
        for j in range(len(nums2)):
            ficto[nums2[j]]+=1
        
        for i in dicto:
            if i in ficto:
                a=0
                a=min(dicto[i],ficto[i])
                result.append([i]*a)
        
        if len(result)==0:
            return []
        else:
            result=reduce(add ,result)
     
     
        return result
