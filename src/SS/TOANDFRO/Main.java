package SS.TOANDFRO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static String inputLine;
    private static String resultLine;
    private static int N;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS/TOANDFRO/input.txt"));
        Scanner sc = new Scanner(System.in);
        while(true) {
            boolean isEnd = input(sc);
            if(isEnd) {
                break;
            }
            solve();
        }
    }

    private static void solve() {
        int M =inputLine.length() / N;
        char [][] matrix = new char[M][N];
        int idx = 0;
        for(int i = 0; i < M; i++) {
            if(i%2==0)
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = inputLine.charAt(idx++);
                }
            else
                for(int j = N-1; j >= 0; j--) {
                    matrix[i][j] = inputLine.charAt(idx++);
                }


        }
        for(int i = 0; i < N; i++) {
            for(int j= 0; j < M; j++) {
                System.out.print(matrix[j][i]);
            }
        }
        System.out.println();
    }

    private static boolean input(Scanner sc) {
        N = sc.nextInt();
        if(N == 0) {
            return true;
        }
        sc.nextLine();
        inputLine = sc.nextLine();
        return false;
    }
}
