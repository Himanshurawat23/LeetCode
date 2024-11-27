import java.util.Arrays;

class Solution {
    public int BinarySearch(int l, int r, int[][] ls, int w, int h) {
        int idx = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ls[mid][1] >= h) {
                idx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return idx;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[][] ls = new int[envelopes.length][2];
        ls[0][0] = envelopes[0][0];
        ls[0][1] = envelopes[0][1];
        int len = 1;

        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][0] > ls[len - 1][0] && envelopes[i][1] > ls[len - 1][1]) {
                ls[len][0] = envelopes[i][0];
                ls[len][1] = envelopes[i][1];
                len++;
            } else {
                int idx = BinarySearch(0, len - 1, ls, envelopes[i][0], envelopes[i][1]);
                ls[idx][0] = envelopes[i][0];
                ls[idx][1] = envelopes[i][1];
            }
        }

        return len;
    }
}
