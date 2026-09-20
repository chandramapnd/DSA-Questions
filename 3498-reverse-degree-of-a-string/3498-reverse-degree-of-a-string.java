class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        for(int i=1;i<=s.length();i++){
            int ind = 26 - (s.charAt(i-1) - 'a');
            res += ind * i;
        }
        return res;
    }
}