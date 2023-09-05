class Solution {
    public int[] runningSum(int[] nums) {
        int l = nums.length;
        int[] input = new int[l];
        int[] input2 = new int[l];
        input = nums;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            input2[i] = input[i] + sum;
            sum = input[i] + sum;
        }
        return input2;
    }
}