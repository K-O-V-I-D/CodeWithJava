class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE,pro=0;
        for(int i:prices)
        {
            if(i<min)
                min=i;
            pro=(int)Math.max(pro,i-min);
        }
        return pro;
    }
}
