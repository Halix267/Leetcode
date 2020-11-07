Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]


################################## SOLUTION #############################################################

class Solution {
    public int[] sortedSquares(int[] A) {   
        int N=A.length;
        int j=0;
        int[] arr = new int[N];
        
        while(j<N && A[j]<0) {
            j++;
            }
        int i=j-1;
        int a=0;
        while(i>=0 && j<N) {
            if(A[i]*A[i]<A[j]*A[j]) {
                arr[a++] = A[i] * A[i];
                i--;
           
            }else {
                arr[a++] = A[j] * A[j];
                j++;
    
            }
        }
        while(i>=0) {
            arr[a++]=A[i]*A[i];  
            i--;
        }
        while(j<N) {
            arr[a++] =A[j]*A[j];
            j++;
        }
        
        return arr;
        
    }
}
