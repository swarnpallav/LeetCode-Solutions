// https://leetcode.com/problems/unique-paths/

class Solution {
    public int uniquePaths(int m, int n) {
        int a[] = new int[n];
        
        for(int i = 1; i < n; i++)
        a[i] = 1;
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                a[j] = (j == 0) ? 1 : a[j] + a[j-1];
            }
        }
        
        return (n == 1) ? 1 : a[n-1];
    }
}




