Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.


##################################################### SOLUTION #####################################################################
class Solution {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a,String b) {
            String str1=a+b;
            String str2 = b+a;
            return str2.compareTo(str1);
        }
    }
    
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++) {
            arr[i]=String.valueOf(nums[i]);
            //System.out.println(arr[i]);
        }
        
        Arrays.sort(arr, new LargerNumberComparator());
        
        if(arr[0].equals("0")) {
            return "0";
        }
        
        String Number = new String();
        for(String numa:arr) {
            Number +=numa;
        }
       return Number;
    }
    
}

################################################################ SOLUTION ##########################################################################
class Solution {
    public String largestNumber(int[] nums) {
        sort(nums, 0, nums.length);

        // If the first element is 0, the result itself is 0
        if (nums[0] == 0) return "0";

        StringBuilder result = new StringBuilder();
        for (int num : nums) result.append(num);

        return result.toString();
    }

    // We can use string comparator
    // (b + a).compareTo(a + b)
    // However, concatenating strings and comparing takes more time
    // So, use the above logic but using number
    private boolean compare(int a, int b) {
        long aLong = a * 10, bLong = b * 10;
        int x = a, y = b;

        while ((x /= 10) > 0) bLong *= 10;
        while ((y /= 10) > 0) aLong *= 10;

        return (aLong + b) > (bLong + a);
    }        

    // The array is of primitive, so we cannot pass comparator
    // This is a compact version of merge sort
    private void sort(int[] nums, int l, int r) {
        if (l >= r - 1) return ;
        int m = l + (r - l) / 2;

        sort(nums, l, m);
        sort(nums, m, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] aux = new int[r - l];

        for (int i = l, j = m, k = 0; i < m || j < r;) {
            if (i < m && (j == r || compare(nums[i], nums[j]))) aux[k++] = nums[i++];
            else if (j < r) aux[k++] = nums[j++];
        }

        for (int i = 0; l < r; ++i) nums[l++] = aux[i];
    }
}
