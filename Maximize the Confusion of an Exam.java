class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i = 0, j = 0, T = 0, count1 = 0, count2 = 0, l = 0, m = 0, F = 0;
        char[] c = answerKey.toCharArray();
        while(i < c.length){
            if(c[i++] == 'F') T++;

            if(T > k){
                count1 = Math.max(count1, i - j - 1);
                while(c[j] != 'F'){
                    j++;
                }
                j++; T--;
            }else{
                count1 = Math.max(count1, i - j);
            }


        if(c[l++] == 'T') F++;

            if(F > k){
                count2 = Math.max(count2, l - m - 1);
                while(m < c.length && c[m] != 'T'){
                    m++;
                }
                m++; F--;
            }else{
                count2 = Math.max(count2, l - m);
            } 
        }

        return Math.max(count1, count2);
    }
}
