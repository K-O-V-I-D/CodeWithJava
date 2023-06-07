class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int i=0;
        int diff=arr[i+1]-arr[i];
        while(i<arr.length-1){
            if((arr[i+1]-arr[i])==diff){
                i++;
            }else{
                return false;
            }
        }
        return true;
    }
}
