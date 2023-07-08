class Solution {
    public long putMarbles(int[] w, int k) {
        if(k==w.length)return 0;
        int n=w.length;
        long[] ans=new long[n-1];
        for(int i=0;i<n-1;i++){
            ans[i]=w[i]+w[i+1];
        }
        Arrays.sort(ans);long res=0;
        for(int i=0;i<k-1;i++){
            res+=ans[n-2-i]-ans[i];
        }
        return res;
    }
}
