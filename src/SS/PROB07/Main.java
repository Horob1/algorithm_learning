package SS.PROB07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    private static final int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
    private static int M;
    private static int N;
    private static char[][] matrix;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS/PROB07/input.txt"));
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int i = 1; i <= TC; i++) {
            input(sc);
            System.out.println("Case #" + i + ": " + solve());
        }
    }


    private static void input(Scanner sc) {
        M = sc.nextInt();
        N = sc.nextInt();

        matrix = new char[M][N];

        String line = sc.nextLine();
        for (int i = 0; i < M; i++) {
            line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }

    private static int solve() {
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '.') count += countBombCell(i, j);
            }
        }
        return count;
    }

    private static int countBombCell(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isInMap(newX, newY) && matrix[newX][newY] == '*') count++;
        }
        return count;
    }

    private static boolean isInMap(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
