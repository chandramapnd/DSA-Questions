class Solution {
    public int maxDepth(String s) {
        int open = 0;
        int max = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
                max = Math.max(max, open);
            }else if(ch == ')'){
                open--;
            }
        }
        return max;

    }
}