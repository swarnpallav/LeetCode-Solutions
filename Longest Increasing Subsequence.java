// https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int help[] = new int [nums.length + 1];
        
        for(int i = 1; i < help.length; i++)
            help[i] = Integer.MAX_VALUE;
        help[0] = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            int idx = lower_bound(help, nums[i]);
            help[idx + 1] = nums[i];
        }
        return lower_bound(help, Integer.MAX_VALUE);
    }
    
    int lower_bound(int a[], int key)
    {
        int lb = 0, ub = a.length - 1, mid = 0;
        
        while(lb <= ub)
        {
            mid = (lb + ub) / 2;
            if((mid - 1 >= 0) && (a[mid] >= key && a[mid - 1] < key))
            {
                ub = mid - 1;
                break;
            } 
            
            if(a[mid] >= key)
                ub = mid - 1;
            else lb = mid + 1;
        }
        return ub;
    }
}
