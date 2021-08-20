// https://leetcode.com/problems/set-matrix-zeroes/

// Attached solutions of three different approaches of different complexities

// Time - O(MN)  Space - O(M+N)
class Solution {
    public void setZeroes(int[][] matrix) {
        int row[] = new int [matrix[0].length];
        int col[] = new int [matrix.length];
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    row[j] = 1;
                    col[i] = 1;
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(col[i] == 1 || row[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
}


// Time - O(MN)  Space - O(MN)
class Solution {
    class Pair{
        int x, y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public void setZeroes(int[][] matrix) {
        
        List<Pair> map = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                    map.add(new Pair(i,j));
            }
        }
        for(Pair pair: map)
            setzero(matrix, pair.x, pair.y);
    }
    
    void setzero(int [][]a, int m, int n)
    {
        for(int i = 0; i < a.length; i++)
            a[i][n] = 0;
        for(int i = 0; i < a[0].length; i++)
            a[m][i] = 0;
    }
}

// Time - O(MN)  Space - O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        
        int row = 0, col = 0;
        
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0) { col = 1; break; }   
        }
        
        for(int i = 0; i < matrix[0].length; i++)
        {
            if(matrix[0][i] == 0) { row = 1; break; }
        }
        
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                    matrix[0][j] = matrix[i][0] = 0;
            }
        }
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        if(col == 1)
        for(int i = 0; i < matrix.length; i++)
            matrix[i][0] = 0;
        
        if(row == 1)
        for(int i = 0; i < matrix[0].length; i++)
            matrix[0][i] = 0;
    }
}
