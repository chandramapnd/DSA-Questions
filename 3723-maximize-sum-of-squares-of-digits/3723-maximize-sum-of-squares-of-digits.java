class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) return "";
        int nines = sum / 9;
        int rest = sum % 9;
        StringBuilder sb = new StringBuilder();
        while(nines > 0){
            sb.append("9");
            nines--;
        }
        sb.append(rest);
        
        for(int i=0;i<num;i++){
            sb.append("0");
        }

        return sb.substring(0, num).toString();
    }
}