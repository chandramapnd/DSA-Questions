class Solution {
    public boolean checkValidString(String s) 
    {
        int max=0;
        int min=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                max++;
                min++;
            }
            else if(s.charAt(i)==')')
            {
                max--;
                min--;
            }
            else if(s.charAt(i)=='*')
            {
                max++;
                min--;
            }
            if(max<0)
            return false;
            if(min<0)
            min=0;
        }
        return min==0;
    }
}