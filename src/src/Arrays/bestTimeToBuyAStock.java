package Arrays;

public class bestTimeToBuyAStock {

    public int maxProfitByLeetCode(int[] prices) {
        int max = 0;
        int i = 0; 
        int j = 1;
        while(j < prices.length) {
            if(prices[i] < prices[j]) {
                int diff = prices[j] - prices[i];
                max = Math.max(diff, max);
            } else {
                i = j;
            }
            j++;
            
        }
        return max;
    }
    public int maxProfitByMe(int[] prices) {
            int minElement = 10000;
            int maxProfitSoFar = 0;
            int maxProfitEndingHere = 0;
            //Kadane's algorithm
    
            for (int i = 0 ; i < prices.length ; i++){
                if(prices[i] < minElement)
                minElement = prices[i];
    
                maxProfitEndingHere = prices[i] - minElement;
                if(maxProfitEndingHere > maxProfitSoFar)
                maxProfitSoFar = maxProfitEndingHere;
    
            }
            return maxProfitSoFar;
     }

}