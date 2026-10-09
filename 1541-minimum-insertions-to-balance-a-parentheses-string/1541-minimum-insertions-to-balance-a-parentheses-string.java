class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int close = 0;
        int add = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(close != 0){
                    if(close % 2 == 1){
                        close++;
                        add += 1;
                    }
                    if((open * 2 - close) < 0){
                        int a = close - open * 2;
                        add += a / 2;
                        open = 0;
                    }else{
                        open -= close / 2;
                    }
                    close = 0;
                }
                open++;
            }else{
                close++;
            }
        }

        if(close != 0){
            if(close % 2 == 1){
                close++;
                add += 1;
            }
            if((open * 2 - close) < 0){
                int a = close - open * 2;
                add += a / 2;
                open = 0;
            }else{
                open -= close / 2;
            }
        }
        
        if(open > 0){
            add += open * 2;
        }
        return add;
    }
}