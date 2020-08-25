class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qFSValue = new int[queries.length];
        int[] wFSValue = new int[words.length];
        
        int[] result = new int[qFSValue.length];
        
        for (int i = 0; i < queries.length; i++) qFSValue[i] = funcF(queries[i]);
        for (int i = 0; i < words.length; i++) wFSValue[i] = funcF(words[i]);
        
        Arrays.sort(wFSValue);
        for (int i = 0; i < qFSValue.length; i++) {
            // binary search qFSValue[i] in wFSValue
            int start = 0;
            int end = wFSValue.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (wFSValue[mid] <= qFSValue[i]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            result[i] = wFSValue.length - start;
        }
        return result;
    }
    
    private int funcF(String s) {
        int count = 0;
        char smallest = 'z';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < smallest) {
                count = 1;
                smallest = c;
            } else if (c == smallest) {
                count++;
            }
        }
        return count;
    }
}
