class Solution {
    public int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : nums) {
            int tmp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + tmp;
        }
        return Math.max(prevNo, prevYes);
    }
}


T: O(n)
S: O(1)
