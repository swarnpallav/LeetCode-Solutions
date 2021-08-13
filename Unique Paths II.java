// https://leetcode.com/problems/unique-paths-ii/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        
        int a[] = new int[n];
        
        a[0] = 1;
        
        for(int i = 1; i < n; i++)
            a[i] = (obstacleGrid[0][i] == 1) ? 0 : a[i - 1];
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(obstacleGrid[i][j] == 1)
                    a[j] = 0;
                else if(j != 0)
                    a[j] = a[j] + a[j-1];
            }
        }
        
        return a[n - 1];
    }
}



