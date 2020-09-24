Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

############################################################## SOLUTION #########################################################################################################
class Solution {
    public int reverse(int x) {
    
        long flag=0,num=0;
        if(x<0) {
            flag=1;
            x=(-1)*x;
        }
        while(x!=0) {
            int a=x%10;
            x=x/10;
            num=num *10 +a;
            
    }
     if (num > Integer.MAX_VALUE || num<Integer.MIN_VALUE) { return 0;}
    
    if (flag!=0) { return (-1)*(int)num;}
    else { return (int)num;}
    }
}
