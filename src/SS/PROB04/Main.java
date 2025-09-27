package SS.PROB04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int MAX_NM = 120;
    private static int N,M;
    private static char [][] matrix = new char[MAX_NM][MAX_NM];
    private static int result;
    private static boolean[] isHasGuardCol;
    private static boolean[] isHasGuardRow;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS/PROB04/input.txt"));
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for (int i = 1; i <= TC; i++) {
            input(sc);
            solve();
            output(i);
        }
    }

    private static void output(int tc) {
        System.out.println("#"+tc + " "+result);
    }

    private static void solve() {
        result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] == '1') continue;
                if(isHasGuardCol[j] && isHasGuardRow[i]) continue;
                result++;
            }
        }
    }

    private static void input(Scanner sc) {
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new char[N][M];
        isHasGuardCol = new boolean[M];
        isHasGuardRow = new boolean[N];
        String line = sc.nextLine();
        for (int i = 0; i < N; i++) {
            line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                char ch = line.charAt(j);
                matrix[i][j] = ch;
                if(ch == '1') {
                    isHasGuardRow[i] = true;
                    isHasGuardCol[j] = true;
                }
            }
        }
    }
}
