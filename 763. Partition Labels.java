class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0){
            return null;
        }
        
        List<Integer> result = new ArrayList<>();
        
        // to record the last index of each character
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            lastIndexMap.put(c, i);
        }
        
        int start = 0;
        int last = 0;
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            last = Math.max(last, lastIndexMap.get(c));
            if (i == last){
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        return result;
    }
}
