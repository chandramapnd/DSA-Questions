class Solution {

    static class Result {
        long weight;
        List<Integer> indices;

        Result(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    Result[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        for (int i = 0; i < n; i++) {
            intervals.get(i).add(i);
        }

        Collections.sort(intervals, (a, b) -> {
            int cmp = Integer.compare(a.get(0), b.get(0));

            if (cmp != 0) {
                return cmp;
            }

            return Integer.compare(a.get(1), b.get(1));
        });

        dp = new Result[n + 1][5];

        Result ans = solve(intervals, 0, 4);

        Collections.sort(ans.indices);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    public Result solve(List<List<Integer>> intervals, int i, int k) {

        int n = intervals.size();

        if (i >= n || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        Result notTake = solve(intervals, i + 1, k);

        int next = search(intervals, i);

        Result nextResult = solve(intervals, next, k - 1);

        List<Integer> takeIndices = new ArrayList<>();

        takeIndices.add(intervals.get(i).get(3));
        takeIndices.addAll(nextResult.indices);

        Result take = new Result(
            (long) intervals.get(i).get(2) + nextResult.weight,
            takeIndices
        );

        if (take.weight > notTake.weight) {
            return dp[i][k] = take;
        }

        if (take.weight < notTake.weight) {
            return dp[i][k] = notTake;
        }

        Collections.sort(take.indices);
        Collections.sort(notTake.indices);

        if (isLexicographicallySmaller(take.indices, notTake.indices)) {
            return dp[i][k] = take;
        }

        return dp[i][k] = notTake;
    }

    public int search(List<List<Integer>> intervals, int i) {

        int end = intervals.get(i).get(1);

        int low = i + 1;
        int high = intervals.size() - 1;

        int ans = intervals.size();

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (intervals.get(mid).get(0) > end) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean isLexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}