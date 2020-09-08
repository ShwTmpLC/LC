class Solution {
    
    public boolean validPalindrome(String s) {
        int d = 1; // at most delete d char
        return valid(s, 0, s.length() - 1, d);
    }
    
    private boolean valid(String s, int l, int r, int d) {
        if (l >= r) {
            return true;
        }
        else if (s.charAt(l) == s.charAt(r)) {
            return valid(s, l + 1, r - 1, d);
        }
        else {
            return d > 0 && (valid(s, l + 1, r, d - 1) || valid(s, l, r - 1, d - 1));
        }
    }
}
