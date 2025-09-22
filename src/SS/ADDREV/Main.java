package SS.ADDREV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int x,y;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS.ADDREV/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            input(sc);
            solve();
            output();
        }
        sc.close();
    }

    private static void output() {
    }

    private static void solve() {
        int rX = rv(x);
        int rY = rv(y);

        int result = rX + rY;
        System.out.println(rv(result));

    }

    private static int rv(int x) {
        int result = 0;
        while(x >= 1) {
            result *= 10;
            result += x%10;
            x /= 10;
        }
        return result;
    }

    private static void input(Scanner sc) {
        x = sc.nextInt();
        y = sc.nextInt();
    }
}
