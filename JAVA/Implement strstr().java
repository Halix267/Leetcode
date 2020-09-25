Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Constraints:

haystack and needle consist only of lowercase English characters.

############################################################################# SOLUTION ##########################################################################
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 && needle.length()==0) {
            return 0;
        }
        
        if(!haystack.contains(needle)) { return -1; }
        
        for(int i=0;i<=haystack.length()-needle.length();i++) {
            if(haystack.substring(i,i+needle.length()).equals(needle)) {
                return i;
            }
        }
        
        return -1;
        
    }
}
###################################################################################SOLLLLLLUTION ################################################################
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 && needle.length()==0) {
            return 0;
        }
        
        if(needle.isEmpty()) { return 0;}
        
        for(int i=0;i<haystack.length();i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int index=i;
                boolean flag=true;
                for(int j=1;j<needle.length();j++) {
                    i++;
                    if(i>=haystack.length()) { return -1;}
                    if(i<haystack.length() && haystack.charAt(i)!=needle.charAt(j)) { flag=false;
                                                                                      break; }
                    }
                
                if(flag) { return index;}
                i=index;
            }        
        }
        return -1;    
    }
}
