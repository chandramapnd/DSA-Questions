class Solution {
    public List<String> generateParenthesis(int n) 
    {
        List<String> ans=new ArrayList<>();
        parantheses(ans,new StringBuilder(),0,0,n);
        return ans;
        
    }
    public void parantheses(List<String> ans,StringBuilder cur,int open, int close,int n)
    {
        if(cur.length()==n*2)
        {
            ans.add(cur.toString());
            return;
        }

        if(open<n)
        {
            parantheses(ans,cur.append("("),open+1,close,n);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close<open)
        {
            parantheses(ans,cur.append(")"),open,close+1,n);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}