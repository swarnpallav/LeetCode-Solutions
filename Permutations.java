// https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();
        solve(nums, 0, answer);
        return answer;
    }
    
    void solve(int a[], int idx, List<List<Integer>> ans)
    {
        if(idx == a.length)
        {
            List<Integer> temp = new ArrayList<>();
            
            for(int val: a)
                temp.add(val);
            
            ans.add(new ArrayList<>(temp));
            return;
        }   
        
        for(int i = idx; i < a.length; i++)
        {
            swap(a, idx, i);
            solve(a, idx + 1, ans);
            swap(a, idx, i);
        }
    }
    
    void swap(int a[], int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

