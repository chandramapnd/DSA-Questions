class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for(int price : prices){
            if(price < min){
                smin = min;
                min = price;
            }else if(price < smin){
                smin = price;
            }
        }
        if(min + smin <= money){
            return money - min - smin;
        }else{
            return money;
        }
    }
}