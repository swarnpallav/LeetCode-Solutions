// https://leetcode.com/problems/palindrome-partitioning/

class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        List<String> help = new ArrayList<>();
        helpart(s, help, result);
        return result;
    }
    
    void helpart(String s, List<String> help, List<List<String>> result)
    {
        if(s.length() == 1)
        {
            help.add(s);
            result.add(new ArrayList<String>(help));
            help.remove(help.size()-1);
            return;
        }
        
        for(int i = 1; i < s.length(); i++)
        {
            if(ispal(s.substring(0,i)))
            {
                help.add(s.substring(0,i));
                helpart(s.substring(i),help, result);
                help.remove(help.size()-1);
            }
        }
        if(ispal(s))
        {
            help.add(s);
            result.add(new ArrayList<String>(help));
            help.remove(help.size()-1);
        }
    }
    
    boolean ispal(String st)
    {
        if(st.length() == 1) return true;
        StringBuffer sbr = new StringBuffer(st);
        sbr.reverse();
        return st.equals(sbr.toString());
    }
}
