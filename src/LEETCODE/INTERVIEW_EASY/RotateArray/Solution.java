package LEETCODE.INTERVIEW_EASY.RotateArray;

class Solution {
    public void rotate(int[] nums, int k) {

        int realK = k % nums.length;
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[(i - realK + nums.length) % nums.length];
        }
        System.arraycopy(tmp, 0, nums, 0, nums.length);
    }
}