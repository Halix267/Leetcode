import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;

    public int solve(Tree root) {
        
        if(root==null) return 0;
        int max = root.val;
        int min = root.val;
        preorder(root,max,min);
        
       // Collections.sort(lst);
        return ans;
    }

    void preorder(Tree root,int max,int min){

        if(root == null) return;
        
        
        
        ans = Math.max(ans,Math.max(Math.abs(max-root.val),Math.abs(min-root.val)));
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        preorder(root.left,max,min);
        preorder(root.right,max,min);

    }
}
