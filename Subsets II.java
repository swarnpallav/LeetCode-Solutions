// https://leetcode.com/problems/subsets-ii/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        solve(nums, 0, set, new ArrayList<Integer>());
        
        return new ArrayList<>(set);
    }
    void solve(int[] nums, int idx, Set<List<Integer>> list, List<Integer> temp)
    {
        if(idx == nums.length)
        {
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(nums, idx + 1, list, temp);
        temp.remove(temp.size()-1);
        solve(nums, idx + 1, list, temp);
    }
}
