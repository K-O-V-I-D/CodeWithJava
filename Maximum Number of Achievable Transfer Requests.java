class Solution {
    int ans = 0;
    void maxRequest(int[][] requests, int[] arr, int n, int i, int count) {
        if (i == requests.length) {
            for (int j = 0; j < n; j++) {
                if (arr[j] != 0) {
                    return;
                }
            }
            ans = Math.max(ans, count);
            return;
        }
        arr[requests[i][0]]--;
        arr[requests[i][1]]++;
        maxRequest(requests, arr, n, i + 1, count + 1);
        arr[requests[i][0]]++;
        arr[requests[i][1]]--;
        maxRequest(requests, arr, n, i + 1, count);
    }
    
    public int maximumRequests(int n, int[][] requests) {
        int[] arr = new int[n];
        maxRequest(requests, arr, n, 0, 0);        
        return ans;
    }
}
