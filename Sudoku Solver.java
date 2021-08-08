// https://leetcode.com/problems/sudoku-solver/

class Solution {
    public void solveSudoku(char[][] board) {
        // Created seperate function to solve because needed 
        // a return value to stop further modification in matrix
        // if sudoku is solved already
        solve(board); 
    }
    int solve(char [][] board)
    {
        int i=0, j=0;
        
        // To check the first dotted value place(i,j)
        for(i = 0; i < board.length; i++)
        {
            for(j = 0; j < board.length; j++)
            {
                if(board[i][j] == '.')
                {
                    break;
                }
            }
            if(j != board.length)
                break;
        }
        
        //if there is a column with dot
        if(i != board.length)
        {
            // try all the values from 1 to 9
            for(char k = '1'; k <= '9'; k++)
            {
                if(isvalid(board, i, j, k))
                {
                    board[i][j] = k;
                    int flag_value=solve(board);
                    
                    // if solved already then return 1
                    if(flag_value == 1)
                        return 1;
                }
            }
            
            // if none of the values from 1-9 can be filled 
            // then fill the current cell with dot and return 0
            board[i][j] = '.';
            return 0;
        }
        
        // if all the cells have values then return 1
        return 1;
    }
    
    //function to check whether 'ch' can be filled at a[m][n] or not
    boolean isvalid(char [][]a, int m, int n, char ch)
    {
        // check for the particular row and column
        for(int i = 0; i < 9; i++)
        {
            //if 'ch' is already present in any cell
            if(a[m][i] == ch || a[i][n] == ch) return false;
        }
        
        int row, col;
        
        //calculate which 3x3 matrix should be checked
        row = (m / 3) * 3;
        col = (n / 3) * 3;
        for(int i = row; i < row + 3; i++)
        {
            for(int j = col; j < col + 3; j++)
            {
                //if 'ch' is already present in any cell
                if(a[i][j] == ch) return false;
            }
        }
        
        return true;
    }
}
