class Solution {
    Boolean[][] dp;   

    
    public boolean isMatch(String s, String p) 
    {
        int m = s.length();
        int n = p.length();

        dp = new Boolean[m][n];   

        return matching(s, p, m-1, n-1);
    }

    private boolean matching(String s, String p, int i, int j)
    {
        
        if(i < 0 && j < 0)
            return true;

        
        if(i >= 0 && j < 0)
            return false;

       
        if(i < 0 && j >= 0)
        {
            for(int k = 0; k <= j; k++)
                if(p.charAt(k) != '*')
                    return false;

            return true;
        }

        
        if(dp[i][j] != null)
            return dp[i][j];

        boolean ans;

        
        if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')
        {
            ans = matching(s, p, i-1, j-1);
        }
        else if(p.charAt(j) == '*')
        {
            ans = matching(s, p, i-1, j) 
                  || matching(s, p, i, j-1);
        }
        else
        {
            ans = false;
        }

        
        dp[i][j] = ans;

        return ans;
    }
}