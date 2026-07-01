class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int num : asteroids) {

            if (num > 0) {
                st.push(num);
            } else {

                while (!st.isEmpty() &&
                       st.peek() > 0 &&
                       st.peek() < -num) {
                    st.pop();
                }

                if (!st.isEmpty() &&
                    st.peek() > 0 &&
                    st.peek() == -num) {
                    st.pop();
                }
                else if (st.isEmpty() || st.peek() < 0) {
                    st.push(num);
                }
            }
        }

        int[] ans = new int[st.size()];
        for (int i = 0; i < st.size(); i++)
            ans[i] = st.get(i);

        return ans;
    }
}