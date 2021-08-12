// https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        solve(nums, 0, list, new ArrayList<Integer>());
        return list;
    }
    void solve(int[] nums, int idx, List<List<Integer>> list, List<Integer> temp)
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
