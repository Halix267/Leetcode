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


########################################################### Solution ##################################################################################
class Solution {
public:
    int reverse(int x) {
        int num =0;
        while(x!=0) {
            int a=x%10;
            x=x/10;
            if (num > INT_MAX/10 || (num == INT_MAX/10 && a>7)) { return 0;}
            if (num<INT_MIN/10 || (num == INT_MIN/10 && a<-8)) { return 0;}
            num = num * 10 + a;          
        }
        return num;
        
        
    }
};
