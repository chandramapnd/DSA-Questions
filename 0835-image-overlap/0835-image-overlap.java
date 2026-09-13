class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max = 0;
        for(int r=-n+1;r<n;r++){
            for(int c=-n+1;c<n;c++){
                max = Math.max(max, count(img1, img2, r, c));
            }
        }

        return max;
    }
    public int count(int [][]a, int [][]b, int r, int c){
        int count = 0;
        int n = a.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int ind1 = i + r;
                int ind2 = j + c;

                if(ind1 >=0 && ind1 < n && ind2 >=0 && ind2 <n && a[ind1][ind2] == 1 && b[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}