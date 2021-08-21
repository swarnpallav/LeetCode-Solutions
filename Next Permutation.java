// https://leetcode.com/problems/next-permutation/

class Solution {
    void swap(int []a, int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    void reverse(int a[], int i, int j)
    {
        while(i < j)
            swap(a, i++, j--);
    }
    public void nextPermutation(int[] nums) {
        int i;
        for(i = nums.length - 2; i >= 0; i--)
        {
            if(nums[i] < nums[i + 1])
            {
                int j = i + 1;
                while(j <  nums.length && nums[i] < nums[j])
                    j++;
                swap(nums, i, j-1);
                reverse(nums, i + 1, nums.length - 1);
                break;
            }
        }
        if(i == -1)
            Arrays.sort(nums);
    }
}

