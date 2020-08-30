class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curResult = new ArrayList<>();
        
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, used, curResult, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> curResult, List<List<Integer>> result) {
        if (curResult.size() == nums.length){
            result.add(new ArrayList<>(curResult));
            return;
        }
        
        for (int i = 0; i < nums.length; i++){ 
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue; 
            curResult.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, curResult, result);
            curResult.remove(curResult.size() - 1);
            used[i] = false;
        }
    } 
}
