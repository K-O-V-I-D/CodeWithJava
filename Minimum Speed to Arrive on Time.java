class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l=1;
        int r=10000000;

        int minSpeed=-1;
        while(l<=r){
            int midSpeed=l+(r-l)/2;
            if(possible(dist ,midSpeed)<=hour){
                minSpeed=midSpeed;
                r=midSpeed-1;
            }else{
                l=midSpeed+1;
            }
        }
        return minSpeed;
    }

    public double possible(int [] dist, int midSpeed){
        double time=0.0;
        for(int i=0; i<dist.length-1; i++){
            double t=(double)dist[i]/(double)midSpeed;
            time=time + Math.ceil(t);
        }
        time = (double) dist[dist.length-1]/(double) midSpeed +time;

        return time;
    }
}
