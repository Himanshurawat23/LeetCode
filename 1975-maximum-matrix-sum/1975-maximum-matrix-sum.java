class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0; // Total sum of absolute values
        int negativeCount = 0; // Count of negative numbers
        int minAbsValue = Integer.MAX_VALUE; // Minimum absolute value in the matrix
        
        // Traverse the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                
                // Add the absolute value of the current element to the sum
                sum += Math.abs(value);
                
                // Count negatives
                if (value < 0) {
                    negativeCount++;
                }
                
                // Update the minimum absolute value
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }
        
        // If the count of negative numbers is odd, adjust the result
        if (negativeCount % 2 == 1) {
            sum -= 2 * minAbsValue; // Subtract twice the smallest absolute value
        }
        
        return sum;
    }
}
