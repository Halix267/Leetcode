Given a positive integer, return its corresponding column title as appear in an Excel sheet.
Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB, … ZZ, AAA, AAB ….. etc. In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA” and so on.

Example 1:

Input:
N = 28
Output: AB
Explanation: 1 to 26 are A to Z.
Then, 27 is AA and 28 = AB.

â€‹Example 2:

Input: 
N = 13
Output: M
Explanation: M is the 13th character of
alphabet.


Your Task:
You don't need to read input or print anything. Your task is to complete the function colName() which takes the column number N as input and returns the column name represented as a string.
 

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N <= 4294967295
  
  
  
  
  ######################################################### SOLUTION ###########################################################
  
  class Sol
{
    String colName (long n)
    {
        // your code here
        
        StringBuilder ans = new StringBuilder();
        
        while(n>0){
            
            int rem = (int)n%26;
            
            if(rem==0){
                ans.append('Z');
                n=n/26-1;
            }else{
                ans.append((char)((rem-1) + 'A'));
                n/=26;
            }
        }
        
        return ans.reverse().toString();
    }
}