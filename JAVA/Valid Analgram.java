Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

#################################################### using array #############################################################
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr=t.toCharArray();
        char[] arr2 =s.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr,arr2);

        
    }
};

######################################################## HAsh Table ###########################################################
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        
        if(s.length()!=t.length()) { return false;}
        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
    }
        for(int i:arr) {
            if(i!=0) { return false;}
            
        }
        return true;
    }
};
