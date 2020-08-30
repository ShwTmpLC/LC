class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }
        List<String> curResult = new ArrayList<>();
        
        backtrack(s, 0, curResult, result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> curResult, List<List<String>> result) {
        if(start == s.length()) {
            result.add(new ArrayList<String>(curResult));
            return;
        }
        
        for(int len = 1; len <= s.length() - start; len++) {
            String candidate = s.substring(start, start + len);
            if(ifPalindrome(candidate)) {
                curResult.add(candidate);
                backtrack(s, start + len, curResult, result);
                curResult.remove(curResult.size() - 1);
            }
        }
    }
    
        
    private boolean ifPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
