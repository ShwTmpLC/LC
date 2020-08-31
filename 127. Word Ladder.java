class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        boolean[] used = new boolean[wordList.size()];
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            count++;
            int queue_size = queue.size();
            for (int i = 0; i < queue_size; i++) {
                String srcStr = queue.poll();
                // found matched
                if(srcStr.equals(endWord)) {
                    return count;
                }
                // not found: keep doing bfs
                for(int index = 0; index < wordList.size(); index++) {
                    String dstStr = wordList.get(index);
                    if(used[index] == false && calcDist(srcStr, dstStr) == 1) {
                        queue.offer(dstStr);
                        used[index] = true;
                    }
                }
                
            }  
        }  
        return 0;
    }
    
    private int calcDist(String a, String b) {
        int dist = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}



T:
O(wordList_size * wordList_size * word_len)

S: 
O(N)
