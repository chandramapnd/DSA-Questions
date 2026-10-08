class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<int[]> st = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {

            int start = i;

            while (!st.isEmpty() && st.peek()[0] > heights[i]) {

                int[] prev = st.pop();

                int height = prev[0];
                int index = prev[1];

                int width = i - index;

                max = Math.max(max, height * width);

                start = index;
            }

            st.push(new int[]{heights[i], start});
        }

        while (!st.isEmpty()) {

            int[] prev = st.pop();

            int height = prev[0];
            int index = prev[1];

            int width = heights.length - index;

            max = Math.max(max, height * width);
        }

        return max;
    }
}