// https://leetcode.com/problems/n-queens/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        // To store single matrix
        List<String> mat = new ArrayList<>();
        
        //Initialize matrix with dots
        for(int i =0; i < n; i++)
        {
            String s = "";
            for(int j = 0; j < n; j++)
                s += ".";
            mat.add(s);
        }
        
        // To store the final answer
        List<List<String>> ans = new ArrayList<>();
        
        // Seperate function to solve problem
        solve(mat, 0, n, ans);
        return ans;
    }
    
    // mat - current matrix
    // idx - current row index
    // n - size of nxn matrix
    // ans - to store final answer
    void solve(List<String> mat, int idx, int n, List<List<String>> ans)
    {
        // idx equals to n means all the rows are filled with queens
        // store the current matrix to ans and return to prev row
        if(idx == n)
        {
            ans.add(new ArrayList<>(mat));
            return;
        }
        
        // Try to place 'Q' to every cell at 'idx' row in matrix
        // If 'Q' can be placed at any cell then place it and go for next row
        for(int i = 0; i < n; i++)
        {
            if(isValid(mat, idx, i))
            {
                String s = mat.get(idx), st;
                st = s;
                s = s.substring(0,i) + "Q" + s.substring(i + 1);
                mat.set(idx, s);
                solve(mat, idx + 1, n, ans);
                // Backtrack and remove 'Q' inserted at ith cell of idx row
                mat.set(idx, st);
            }
        }
    }
    
    // Check whether the current cell can be filled with 'Q' or not
    boolean isValid(List<String> mat, int row, int col)
    {
        // Check for particular row and column
        for(int i = 0; i < mat.size(); i++)
        {
            if(mat.get(row).charAt(i) == 'Q' || mat.get(i).charAt(col) == 'Q')
                return false;
        }
        
        // Check for the diagonals
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            if(mat.get(i).charAt(j) == 'Q')
                return false;
        }
        
        for(int i = row + 1, j = col + 1; i < mat.size() && j < mat.size(); i++, j++)
        {
            if(mat.get(i).charAt(j) == 'Q')
                return false;
        }
        
        for(int i = row - 1, j = col + 1; i >= 0 && j < mat.size(); i--, j++)
        {
            if(mat.get(i).charAt(j) == 'Q')
                return false;
        }
        
        for(int i = row + 1, j = col - 1; i < mat.size() && j >= 0; i++, j--)
        {
            if(mat.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
    
}
