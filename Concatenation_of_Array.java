class Solution {
    public int[] getConcatenation(int[] nums) {
        int l = nums.length;
        int[] sec = new int[l * 2];
        int k = 0;
        int g = 0;
        for (int i = 0; i < l; i++) {
            sec[i] = nums[i];
            k++;
        }
        for (int j = k; j < sec.length; j++) {
            sec[j] = nums[g];
            g++;
        }
        return sec;
    }
}