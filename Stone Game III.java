class Solution {
    public int  solve(int[] stones,int [] dp,int i)
    {
        if(i>=stones.length)
            return 0;
        if(dp[i]!=Integer.MAX_VALUE)
            return dp[i];
        
        int minOne=stones[i]-solve(stones,dp,i+1);

        int minTwo=Integer.MIN_VALUE;
        
        if(i+1<stones.length)
            minTwo=stones[i]+stones[i+1]-solve(stones,dp,i+2);
        
        int minThree=Integer.MIN_VALUE;
        if(i+2<stones.length)
            minThree=stones[i]+stones[i+1]+stones[i+2]-solve(stones,dp,i+3);
            
        return dp[i]=Math.max(minOne,Math.max(minTwo,minThree));
    }
    
    public String stoneGameIII(int[] stoneValue) {
        int dp[]=new int[stoneValue.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
         int val=solve(stoneValue,dp,0);
        if(val>0)
            return "Alice";
        else if(val<0)
            return "Bob";
        else
            return "Tie";
        
    }
}
