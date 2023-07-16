class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (e1, e2) -> {
            return e1[1] - e2[1];
        });

        // states represent max value at k after n events.
        int[][] dp = new int[k + 1][events.length];
        for (int i = 1; i <= k; i++) {
            dp[i][0] = events[0][2];
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < events.length; j++) {
                int[] event = events[j];
                int value = event[2];

                int attend = value; // value when attending this event.
                int lastEventAttendable = binarySearch(events, j);
                if (lastEventAttendable != -1) {
                    // if we can attend this event as well as last event,
                    // then add value to the max after attending last event.
                    attend = value + dp[i - 1][lastEventAttendable];
                }

                // when skipping this event, value is the max of last event.
                int skip = dp[i][j - 1];

                // get the max of the 2.
                dp[i][j] = Math.max(attend, skip);
            }
        }

        return dp[k][events.length - 1];
    }

    private int binarySearch(int[][] events, int idx) {
        // find the last event with end day less than the start day idx.
        int l = 0, r = idx - 1;
        int startDay = events[idx][0];

        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int endDay = events[mid][1];

            if (endDay < startDay) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}
