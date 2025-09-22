package SS.PROB01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int x;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS.PROB01/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            input(sc);
            solve();
            output(i);
        }
        sc.close();
    }

    private static void output(int tc) {
        System.out.println("#"+tc+" "+x);
    }

    private static void solve() {
        while (x >=10) {
            x = x/10 + x%10;
        }
    }

    private static void input(Scanner sc) {
        x = sc.nextInt();
    }
}
