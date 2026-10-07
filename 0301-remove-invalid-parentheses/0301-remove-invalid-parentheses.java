class Solution {
    int max = 0;
    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        solve(s, 0, 0, new StringBuilder());

        return new ArrayList<>(set);
    }

    public void solve(String s, int i, int count, StringBuilder cur) {

        if (count < 0) {
            return;
        }

        if (i >= s.length()) {
            if (count == 0) {
                int len = cur.length();

                if (len > max) {
                    max = len;
                    set.clear();
                    set.add(cur.toString());
                } 
                else if (len == max) {
                    set.add(cur.toString());
                }
            }
            return;
        }

        char ch = s.charAt(i);

        if (ch != '(' && ch != ')') {
            cur.append(ch);
            solve(s, i + 1, count, cur);
            cur.deleteCharAt(cur.length() - 1);
            return;
        }

        cur.append(ch);

        if (ch == '(') {
            solve(s, i + 1, count + 1, cur);
        } else {
            solve(s, i + 1, count - 1, cur);
        }

        cur.deleteCharAt(cur.length() - 1);

        solve(s, i + 1, count, cur);
    }
}