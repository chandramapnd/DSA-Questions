class Solution {
    public int maxProduct(int n) {
        int max = 0;
        int smax = 0;
        while(n>0){
            int rem = n % 10;
            if(rem > max){
                smax = max;
                max = rem;
            }else if(smax<rem){
                smax = rem;
            }
            n /= 10;
        }
        return smax * max;
    }
}