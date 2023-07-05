class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;        // left pointer
        int zeros = 0;       // number of zeros in the current window
        int maxLen = 0;      // maximum length of a subarray containing only ones

        int n = nums.length;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0)
                zeros++;

            // Shrink the window if there are more than one zeros
            while (zeros > 1) {
                if (nums[left] == 0)
                    zeros--;
                left++;
            }

            // Update the maximum length
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
