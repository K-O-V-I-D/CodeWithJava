class Solution {
    double ch(double[][] a,int s,int j,int[]v){
        v[s]=1;
        
        for(int i=0;i<a.length;i++){
            if(i==j && a[s][i]!=0) return a[s][i];
            if(a[s][i]!=0 && v[i]==0){
                double x = ch(a,i,j,v);
                if(x!=-1)
                return x*a[s][i];
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,Integer> hm = new HashMap<>();
        int c=0;
        for(int i=0;i<values.length;i++){
            if(hm.get(equations.get(i).get(0))==null)
            hm.put(equations.get(i).get(0),c++);
            if(hm.get(equations.get(i).get(1))==null)
            hm.put(equations.get(i).get(1),c++);
        }
        double[][] ad = new double[c][c];
        for(int i=0;i<values.length;i++){
            ad[hm.get(equations.get(i).get(0))][hm.get(equations.get(i).get(1))] = values[i];
            
            ad[hm.get(equations.get(i).get(1))][hm.get(equations.get(i).get(0))] = 1/values[i];
            

        }
        int[] v = new int[c];
        double[] ans = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            Arrays.fill(v,0);
            if(hm.get(queries.get(i).get(0))==null || hm.get(queries.get(i).get(1))==null) ans[i]=-1;
            else
            ans[i] = ch(ad,hm.get(queries.get(i).get(0)),hm.get(queries.get(i).get(1)),v);
    }
           
       return ans;
    }
}
