class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();

        q.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int step = 0;
        while(!q.isEmpty()){
            int n = q.size();
            
            for(int k=0;k<n;k++){
                int []cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                if((i==0 || i==maze.length-1 || j == 0 || j == maze[0].length-1) && !(i == entrance[0] && j == entrance[1])){
                    return step;
                }

                if(i-1 >=0 && maze[i-1][j]=='.'){
                    q.add(new int[]{i-1, j});
                    maze[i-1][j] = '+';
                }
                if(i+1 < maze.length && maze[i+1][j]=='.'){
                    q.add(new int[]{i+1, j});
                    maze[i+1][j] = '+';
                }
                if(j-1 >=0 && maze[i][j-1]=='.'){
                    q.add(new int[]{i, j-1});
                    maze[i][j-1] = '+';
                }
                if(j+1 < maze[0].length && maze[i][j+1]=='.'){
                    q.add(new int[]{i, j+1});
                    maze[i][j+1] = '+';
                }
                
            }
            step++;
        }
        return -1;
    }
}