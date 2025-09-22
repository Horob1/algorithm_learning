package SS.SMPDIV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int n,x,y;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SS.SMPDIV/input.txt"));
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
        for(int i = 2; i < n; i++) {
            if(i%x==0 && i%y!=0) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    private static void input(Scanner sc) {
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
    }
}
