// https://leetcode.com/problems/word-search/
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res=false;
        int wordfreq[][] = new int[26][26];
        int boardfreq[][] = new int[26][26];
        
        for(int i = 0; i < word.length(); i++)
        {
            if(Character.isUpperCase(word.charAt(i)))
                wordfreq[1][word.charAt(i) -'A']++;
            else
                wordfreq[0][word.charAt(i) - 'a']++;
        }
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(Character.isUpperCase(board[i][j]))
                    boardfreq[1][board[i][j]-'A']++;
                else
                    boardfreq[0][board[i][j] - 'a']++;
            }
        }
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 26; j++)
            {
                if(boardfreq[i][j] < wordfreq[i][j])
                    return false;
            }
        }
        
        int dp[][] = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    res = solve(board, word, i, j, new ArrayList<ArrayList<Integer>>());
                    if(res == true) break;
                }
            }
            if(res == true) break;
        }
        return res;
    }
    boolean solve(char[][] board, String word, int i, int j, ArrayList<ArrayList<Integer>> visited)
    {
        if( i == -1 || i == board.length || j == -1 || j == board[0].length)
            return false;
        
        if(board[i][j] != word.charAt(0)) return false;
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i); list.add(j);
        
        for(ArrayList<Integer> loop : visited)
        {
            if(loop.equals(list))
            {
                return false;
            }
        }
        
        if(word.length() == 1)
            return true;
        
        visited.add(list);
        
        boolean up = solve(board, word.substring(1), i - 1, j, visited);
        boolean down = solve(board, word.substring(1), i + 1, j, visited);
        boolean left = solve(board, word.substring(1), i, j - 1, visited);
        boolean right = solve(board, word.substring(1), i, j + 1, visited);
        
        visited.remove(visited.size() - 1);
        
        return (up || down || left || right);
    }
}
