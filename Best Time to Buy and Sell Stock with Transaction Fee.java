class Solution {
public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int bsp = prices[0];
    int ssp =0;
    //minimise bought state profit/buy at minimum price, 
    //maximise selling state profit/sell at maximum price
    for(int i =1;i<n;i++){
        int  nbsp = Math.min(bsp, prices[i]-ssp);
        int  nssp = Math.max(ssp,prices[i] - bsp - fee);
        
        bsp = nbsp;
        ssp = nssp;
    }
    
   return ssp;
 }
}
