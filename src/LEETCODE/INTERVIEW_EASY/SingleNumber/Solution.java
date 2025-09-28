package LEETCODE.INTERVIEW_EASY.SingleNumber;

class Solution {
    public int singleNumber(int[] nums) {
        final int MAX = 3 * 10000;
        int[] counts = new int[2 * MAX + 1];
        for (int num : nums) {
            counts[num + MAX]++;
        }
        for (int i = 0; i <= 2 * MAX + 1; i++) {
            if (counts[i] == 1) return i - MAX;
        }
        return -1;
    }
}