// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        
        String ans = "", pal1 = "", pal2 = "";
        int l = 0, r = 0;
        
        for(int i = 1; i < s.length(); i++)
        {
            l = i - 1; r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                l--; r++;
            }
            pal1 = s.substring(l+1, r);
            if(ans.length() < pal1.length())
                ans = pal1;
            pal1 = "";
        }
        for(int i = 0; i < s.length() - 1; i++)
        {
            l = i; r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                l--; r++;
            }
            pal1 = s.substring(l+1, r);
            if(ans.length() < pal1.length())
                ans = pal1;
            pal1 = "";
        }
        return ans;
    }
}
