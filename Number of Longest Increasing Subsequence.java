class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] c = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(c, 1);
        int max = 1;
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j]+1){
                        c[i] = c[j];
                        dp[i] = dp[j]+1;
                    }
                    else if (dp[i] == dp[j]+1){
                        c[i] += c[j];
                    }
                }
                max = Math.max(dp[i], max);
            }
        }
        int res = 0;
        for (int i=0; i<nums.length; i++){
            if (dp[i] == max){
                res += c[i];
            }
        }
        return res;
    }
}
