package LEETCODE.SLIDING_WINDOW.E1652;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r1 = s.decrypt(new int[]{5, 7, 1, 4}, 3);
        int[] r2 = s.decrypt(new int[]{1, 2, 3, 4}, 0);
        int[] r3 = s.decrypt(new int[]{2, 4, 9, 3}, -2);
        print(r1);
        print(r2);
        print(r3);
    }

    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) return result;

        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % code.length];
                }
            } else {
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + code.length) % code.length];
                }
            }
            result[i] = sum;
        }
        return result;
    }
}