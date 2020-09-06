class Solution {
    
    int maxLength = 0;
    int start = 0;
    
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length();) {
            i = extendBothSides(s, i);
        }
        return s.substring(start, start + maxLength);
    }
    
    private int extendBothSides(String s, int i) {
        // skip same
        int j = i;
        int k = i;
        while (k < s.length() - 1 && s.charAt(k) == s.charAt(k + 1)) {
            k++;
        }
        int nextI = k + 1;
        
        // extend
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        
        // update
        int curLength = (--k) - (++j) + 1;
        if (curLength > maxLength) {
            start = j;
            maxLength = curLength;
        }     
        
        return nextI;
    }
}

T: O(N^2)
S: O(1)
