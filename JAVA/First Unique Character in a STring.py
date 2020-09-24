Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.

########################################################################## SOLUTION #####################################################################################
Using Hash Map
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> Mymap = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++) {
            if(Mymap.containsKey(s.charAt(i))){
                Mymap.put(s.charAt(i),Mymap.get(s.charAt(i))+1);
            }
            if(!Mymap.containsKey(s.charAt(i))){
                Mymap.put(s.charAt(i),1);
            }
        }
        
        for(int i=0;i<s.length();i++) {
            if(Mymap.get(s.charAt(i))==1)
                return i;
        }
        return -1;
        
    }
}

#####################################################################Using Arrray (Faster than 96%)####################################################################################
class Solution {
    public int firstUniqChar(String s) {
        int[] arr= new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(arr[c-'a']==1) {
                return i;
            }
        }
        return -1;
}
};
