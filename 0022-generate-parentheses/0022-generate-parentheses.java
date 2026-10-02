class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve(n, n, new StringBuilder());
        return res;
    }
    public void solve(int open, int close, StringBuilder sb){
        if(open == 0 && close == 0){
            res.add(new String(sb));
        }

        if(open > 0){
            sb.append("(");
            solve(open-1, close, sb);
            sb.deleteCharAt(sb.length() - 1);

            if(close > open){
                sb.append(")");
                solve(open, close-1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }else if(open == 0 && close > 0){
            sb.append(")");
            solve(open, close-1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}