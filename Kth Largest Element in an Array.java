// https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k + 1;
        int waste = solve(nums, k, 0, nums.length-1);
        return nums[k-1];
    }
    int solve(int []nums, int k, int lb, int ub)
    {
        int idx = Partition(nums, lb, ub);
        if(idx == k-1)
            return nums[idx];
        
        if(k - 1 < idx)
            solve(nums, k, lb, idx - 1);
        else
            solve(nums, k, idx + 1, ub);
        return 0;
    }
    
    void swap(int []a, int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    void randompivot(int nums[], int lb,int ub)
    {
        int range = ub - lb + 1;
        int pivot = ((int)(Math.random() * range) + lb);
        swap(nums, pivot, lb);
    }
    
    int Partition(int nums[], int lb, int ub)
    {
        if(lb == ub) return lb;
        
        randompivot(nums, lb, ub);
        
        int pivot = lb;
        
        int start = lb + 1, end = ub;
        
        while(start <= end)
        {
            while(start <= end && nums[start] <= nums[pivot])
                start++;
            while(end >= start && nums[end] > nums[pivot])
                end--;
            if(start > end)
                swap(nums, pivot, end);
            else
                swap(nums, start, end);
            
        }
        
        return end;
    }
}
