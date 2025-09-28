package SS.P141PROJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final char[][] matrix = new char[4][4];

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS/P141PROJ/input2.txt"));
        Scanner sc = new Scanner(System.in);
        input(sc);
        boolean canDraw = solve();
        output(canDraw);
    }

    private static void output(boolean canDraw) {
        System.out.println(canDraw ? "YES" : "NO");
    }

    private static boolean solve() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (check(i, j)) return true;
            }
        }
        return false;
    }

    private static boolean check(int x, int y) {
        char value = matrix[x][y];
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (matrix[x + i][y + j] == value) count++;
            }
        }
        return count >= 3;
    }

    private static void input(Scanner sc) {
        String line;
        for (int i = 0; i < 4; i++) {
            line = sc.nextLine();
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }
}
