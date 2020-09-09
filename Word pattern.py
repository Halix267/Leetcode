Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false

########################SOLUTION###########################

class Solution:
    def wordPattern(self, pattern: str, string: str) -> bool:
        words = string.split()
        if len(pattern) != len(words):
            return False
        wordToPattern =  {}
        for i , word in enumerate(words):
            if word not in wordToPattern:
                if pattern[i] in wordToPattern.values():
                    return False
                wordToPattern[word] = pattern[i]
            else:
                if wordToPattern[word] != pattern[i]:
                    return False
        return True
            
