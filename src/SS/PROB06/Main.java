package SS.PROB06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static int M, N;
    static int total;

    static List<int[]> clients;

    static int[][] matrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void input(Scanner sc) {
        String [] tokens = sc.nextLine().split(" ");
        M = Integer.parseInt(tokens[0]);
        N = Integer.parseInt(tokens[1]);
        matrix = new int[M][N];
        String line;
        clients = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                char temp = line.charAt(j);
                if(temp == 'C') {
                    calcNode(i, j, 3);
                } else if(temp == 'B') {
                    calcNode(i, j, 2);
                } else if(temp == 'A') {
                    calcNode(i, j, 1);
                } else if(temp == 'H') {
                    clients.add(new int[] {i, j});
                }
            }
        }
    }

    private static void calcNode(int x, int y, int w) {
        matrix[x][y] = 1;
        for(int i = 1; i <= w; i++) {
            for(int j = 0; j <4; j++) {
                int x1 = x + dx[j]*i;
                int y1 = y + dy[j]*i;
                if(isInMap(x1,y1)) {
                    matrix[x1][y1] = 1;
                }
            }
        }
    }

    private static boolean isInMap(int x, int y) {
        return x < M && y < N && x >= 0 && y >= 0;
    }


    static void solve() {
        total = 0;
        for (int[] client : clients) {
            if (matrix[client[0]][client[1]] == 0) {
                total++;
            }
        }
    }

    static void output(int tc) {
        System.out.println("#" + tc + " " + total);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS/PROB06/input.txt"));
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= tc; i++) {
            input(sc);
            solve();
            output(i);
        }
    }
}