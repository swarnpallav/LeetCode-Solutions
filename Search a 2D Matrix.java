// https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int ub = colbinarySearch(matrix, 0, matrix.length - 1, target);
        
        if(ub == matrix.length) return false;
        
        return (Arrays.binarySearch(matrix[ub], target) >= 0) ? true : false;
    }
    
    int colbinarySearch(int a[][], int lb, int ub, int target)
    {
        int n = a[0].length - 1;
        while(lb <= ub)
        {
            int mid = (lb + ub) / 2;
            
            if(a[mid][n] == target)
            {
                lb = mid; break;
            }
            if(a[mid][n] > target)
                ub = mid - 1;
            else
                lb = mid + 1;
        }
        return lb;
    }
}
