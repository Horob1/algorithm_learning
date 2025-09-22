package SS.PROB02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int N, M;
    private static char[][] matrix;
    private static int[] results;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS.PROB02/input.txt"));
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for(int i = 1; i <= TC; i++) {
            input(scanner);
            solve();
            output(i);
        }
    }

    private static void output(int tc) {
        System.out.print("#"+tc);
        for(int i = 0; i < 5; i++) {
            System.out.print(" "+results[i]);
        }
        System.out.println();
    }

    private static void solve() {
        results = new int[5];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                results[getType(i,j)]++;
            }
        }
    }

    private static int getType(int i, int j) {
        int type = 0;
        for(int k = 0; k < 4; k++) {
            if(matrix[5*i+1+k][5*j+1] == '.') {
                break;
            }
            type++;
        }
        return type;
    }

    private static void input(Scanner scanner) {
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();
        matrix = new char[N*5+1][M*5+1];
        for(int i = 0; i < N*5+1; i++) {
            String line = scanner.nextLine();
            for(int j = 0; j < M*5+1; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }
}
