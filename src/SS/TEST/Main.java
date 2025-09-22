package SS.TEST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int i =  sc.nextInt();
            if(i==42) break;
            System.out.println(i);
        }
    }
}
