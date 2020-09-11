You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11


############################################################ MY SOLUTION############################################################
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sums: int) -> int:
        self.count=0
        self.helper(root,sums)
        return self.count
    
    def helper(self,root,sums):
        if root is None:
            return 0
        self.test(root,sums)
        self.helper(root.left,sums)
        self.helper(root.right,sums)
        
    def test(self,root,sums):
        if root is None:
            return 0
        if root.val==sums:
            self.count+=1
        self.test(root.left,sums-root.val)
        self.test(root.right,sums-root.val)
        
        
########################################################### EFFECTIVE ONE (Uses dict) #########################################################
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        mp = collections.defaultdict(int)
        mp[0] = 1
        return self.helper(root, mp, 0, sum)
    
    
    def helper(self, root, mp, rsum, target):
        if root is None:
            return 0
        rsum += root.val
        calc = rsum - target
        total = mp[calc]
        mp[rsum] += 1
        total += self.helper(root.left, mp, rsum, target)
        total += self.helper(root.right, mp, rsum, target)
        mp[rsum] -= 1
        return total
