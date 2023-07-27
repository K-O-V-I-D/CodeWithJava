class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long totalSum = 0, low = 0;
        for(int battery : batteries){
            totalSum += battery;
            low = Math.min(low, battery);
        }
        long high = (totalSum / n )+ 1;
        long ans = -1;
        while(low < high){
            long mid = low + (high - low) / 2;
            if(isPossible(n, mid, batteries)){
                ans = mid;
                low = mid + 1;
            }else high = mid;
        }
        return ans;
        
    }
    private boolean isPossible(int n, long timeSpan, int[] batteries){
        long currSum = 0;
        long targetSum = n * timeSpan;

        for(int battery : batteries){
            if(battery < timeSpan) currSum += battery;
            else currSum += timeSpan;
            if(currSum >= targetSum) return true;
        }
        return currSum >= targetSum;
    }
    
}
