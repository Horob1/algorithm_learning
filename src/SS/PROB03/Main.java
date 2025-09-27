package SS.PROB03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int H, W, M, N;
    private static int[][] matrix;
    private static long max;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS/PROB03/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            input(sc);
            solve();
            output(i);
        }
    }

    private static void output(int tc) {
        System.out.println("#" + tc + " " + max);
    }

    private static void solve() {
        max = 0;
        int maxX = M - H, maxY = N - W;
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                long sum = calc(i, j);
                if (sum > max) {
                    max = sum;
                }
            }
        }
    }

    private static long calc(int x, int y) {
        long sum = 0;
        for (int i = x; i <= x + H - 1; i++) {
            for (int j = y; j <= y + W - 1; j++) {
                if (isInBound(x, y, i, j) && matrix[i][j] % 2 == 0) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    private static boolean isInBound(int x, int y, int i, int j) {
        return x == i || i == x + H - 1 || y == j || j == y + W - 1;
    }

    private static void input(Scanner sc) {
        H = sc.nextInt();
        W = sc.nextInt();
        M = sc.nextInt();
        N = sc.nextInt();

        matrix = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
}
