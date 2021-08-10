// https://leetcode.com/problems/decode-ways/

class Solution {
    
    int ans = 0;
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++)
            dp[i] = Integer.MIN_VALUE;
        
        solve(s.toCharArray(), 0, dp);
        return ans;
    }
    void solve(char []s, int idx, int dp[])
    {
        if(idx != dp.length && dp[idx] != Integer.MIN_VALUE)
        {
            ans += dp[idx];
            return;
        }
        if(idx > s.length) return; 
            
        if(idx < s.length && s[idx] == '0') return;
        
        if(idx == s.length) { ans++; return; }
        
        int temp = ans;
        
        solve(s, idx + 1, dp);
        
        if((idx < s.length - 1) && (s[idx] == '1' || (s[idx] == '2' && s[idx + 1] < '7')))
            solve(s, idx + 2, dp);
        
        dp[idx] = ans - temp;
    }
}

