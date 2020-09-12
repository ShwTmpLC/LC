public class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        Map<Character, Integer> needMap = new HashMap<>();
        for(char c : t.toCharArray()){
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        // needCount
        int needCount = needMap.size();
        
        int left = 0, right = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        
        while (right < s.length()) {
            char rightC = s.charAt(right);
            if (needMap.containsKey(rightC)) {
                needMap.put(rightC, needMap.get(rightC) - 1);
                if (needMap.get(rightC) == 0) {
                    needCount--;
                }
            }
            right++;
            
            while (needCount == 0) {
                char leftC = s.charAt(left);
                if (needMap.containsKey(leftC)){
                    needMap.put(leftC, needMap.get(leftC) + 1);
                    if (needMap.get(leftC) > 0){
                        needCount++;
                    }
                }
                if (right - left == t.length()) {
                    result.add(left);
                }
                left++;
            }
        }
        return result;
    }
}
