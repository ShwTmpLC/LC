class Solution {
    public int numSplits(String s) {
        int left[] = new int[26];
        int right[] = new int[26];
        int numOfDistinctLeft = 0;
        int numOfDistinctRight = 0;
        
        int result = 0;
  
        for (int i = 0; i < s.length(); i++) {
            right[s.charAt(i) - 'a']++;
            if (right[s.charAt(i) - 'a'] == 1) {
                numOfDistinctRight++;
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            left[s.charAt(i) - 'a']++;
            if (left[s.charAt(i) - 'a'] == 1) {
                numOfDistinctLeft++;
            }
            
            right[s.charAt(i) - 'a']--;
            if (right[s.charAt(i) - 'a'] == 0) {
                numOfDistinctRight--;
            }
            
            if (numOfDistinctLeft == numOfDistinctRight) {
                result++;
            }
        }
        return result;
    }
}
