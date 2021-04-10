import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        //int max=0;
        int n = nums.length;
        if(n==0||k==0)return 0;

        int[] dp = new int[n];
        dp[0]=nums[0];
        int max = nums[0];
        //int start =0,end=0;

        for(int i=1;i<n;i++){

            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max= Math.max(dp[i],max);
        }

        int sum =0;

        for(int i:nums){
            sum+=i;
        }

        int total = sum *(k-2);

        if(k==1)return max;
        Arrays.fill(dp,0);
        dp[n-1] = nums[n-1];
        int tmp=nums[n-1],tmp2=nums[0];
        for(int i= n-2;i>=0;i--){
            dp[i]= dp[i+1]+nums[i];
            tmp= Math.max(dp[i],tmp);
            
        }
       
        
        Arrays.fill(dp,0);
        dp[0] = nums[0];
        
        for(int i= 1;i<n;i++){
            dp[i]= dp[i-1]+nums[i];
            tmp2 = Math.max(tmp2,dp[i]);
            
        }
      
        
        System.out.println(tmp+" "+tmp2+" "+total+" "+max);
        return Math.max(max,tmp+tmp2+total);

    }
}
