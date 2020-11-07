Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true

Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.

 

Constraints:

    1 <= name.length <= 1000
    1 <= typed.length <= 1000
    The characters of name and typed are lowercase letters.


####################################################SOLUTION ####################################################################################

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        int i = 0,j=0;
        typed = typed;
        int m=name.length(),n=typed.length();
        
        while(i<m &&j<n){
            int count1=0,count2=0;
            char c1 = name.charAt(i),c2=typed.charAt(j);
            if(name.charAt(i)!=typed.charAt(j)){
                return false;
            }
            
            while(i<m && name.charAt(i)==c1){
                count1++;
                i++;
            }
            
            while(j<n && typed.charAt(j)==c2){
                count2++;
                j++;
            }
            
            if(count2<count1) return false;
        
        }
        return i==m && j==n;
    
}
}
