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
        """
        Time complexity: O(n)
        Space: O(n)
        
        """
        count = 0
        k = sum
        diff_map = defaultdict(int)
        def pre_order(node: 'TreeNode', curr_sum) -> None:
            nonlocal count
            if not node:
                return
            # current prefix sum
            curr_sum += node.val
            
            # here is the sum we are looking for
            if curr_sum == k:
                count +=1
            
            # number of times the curr_sum − k has occurred already, 
            # determines the number of times a path with sum k 
            # has occurred up to the current node
            count += diff_map[curr_sum-k]
            
            diff_map[curr_sum] +=1
             # process left subtree
            pre_order(node.left, curr_sum)
            # process right subtree
            pre_order(node.right, curr_sum)
            
            # remove the current sum from the hashmap
            # in order not to use it during 
            # the parallel subtree processing
            diff_map[curr_sum] -= 1
            
        pre_order(root, 0)
        return count
