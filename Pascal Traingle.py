Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

############################################################SOLUTION##################################################################
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        
        if numRows==0:
            return []
        l=[[1]]
        for i in range(1,numRows):
            r=[1]
            for j in range(1,i+1):
                ro=r[-1]* (i-j+1)//j
                r.append(ro)
                
            l.append(r)
        return l
