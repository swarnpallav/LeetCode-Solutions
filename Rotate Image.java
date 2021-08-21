// https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top_left[] = {0,0}, top_right[] = {0,n-1}, bot_left[] = {m-1, 0}, bot_right[] = {m-1, n-1};
        int i = 0;
        int M = m;
        while(top_left[1] < top_right[1])
        {
            while(top_left[1] < M - 1)
            {
                int values[] = {matrix[top_left[0]][top_left[1]], matrix[top_right[0]][top_right[1]],
                           matrix[bot_right[0]][bot_right[1]], matrix[bot_left[0]][bot_left[1]]};
            
            
                matrix[top_left[0]][top_left[1]] = values[3];
                matrix[top_right[0]][top_right[1]] = values[0];
                matrix[bot_left[0]][bot_left[1]] = values[2];
                matrix[bot_right[0]][bot_right[1]] = values[1];
                
                top_left[1] += 1;
                top_right[0] += 1;
                bot_left[0] -= 1;
                bot_right[1] -= 1;
            }
            M--;
            i++;
            bot_left[1] = top_right[0] = top_left[0] = top_left[1] = i;
            bot_right[1] = top_right[1] = n - i -1;
            bot_right[0] = bot_left[0] = m - i - 1;
        }
    }
}
