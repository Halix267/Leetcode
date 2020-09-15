
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


############################################################################ SOlution ########################################################
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        self.sums=0
        self.find(root,0)
        return self.sums
        
    def find(self,node,side):
        if not node:
            return 0
        value=node.val
        left=self.find(node.left,-1)
        right=self.find(node.right,1)
        if node.left==None and node.right==None:
            if side==-1:
                self.sums+=value
            
        
