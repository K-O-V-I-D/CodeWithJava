class Solution {

    public int longestSubsequence(int[] arr, int difference) {

        HashMap<Integer,Integer> dp = new HashMap<Integer,Integer>();

        int ans = 0;

        for(int i = 0;i<arr.length;i++){

            dp.put(arr[i],dp.getOrDefault(arr[i]-difference,0)+1);

            ans = Math.max(ans,dp.get(arr[i]));

        }

        return ans;

    }

}
