class Solution {

    int index = 0;

    public String reverseParentheses(String s) {
        return solve(s).toString();
    }

    public StringBuilder solve(String s) {
        StringBuilder res = new StringBuilder();

        while (index < s.length()) {

            char ch = s.charAt(index);

            if (ch == '(') {
                index++; 

                StringBuilder temp = solve(s);

                res.append(temp.reverse());

            } 
            else if (ch == ')') {
                index++; 
                return res;
            } 
            else {
                res.append(ch);
                index++;
            }
        }

        return res;
    }
}