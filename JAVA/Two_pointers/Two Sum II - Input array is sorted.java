Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]

Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]

#############################################################################SOLUTION #######################################################################

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        int[] arr = new int[2];
        while(i<j){
            if(numbers[i]+numbers[j]<target){
                i++;
                
            }
            else if(numbers[i]+numbers[j]>target){
                j--;
            }
            else{
                arr[0]=i+1;
                arr[1]=j+1;
                break;
            }
        }
        return arr;
    }
}