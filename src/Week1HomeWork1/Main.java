package Week1HomeWork1;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder result = new StringBuilder(String.join("", Collections.nCopies(n, "*")));
        result.append("\n");
        for (int i = 1; i < n - 1; i++) {
            result.append("*");
            if (i % 2 == 1) {
                result.append(String.join("", Collections.nCopies(n / 2, "+ ")));
            } else {
                result.append(String.join("", Collections.nCopies(n / 2, " +")));
            }
            result.append("*\n");
        }
        result.append(String.join("", Collections.nCopies(n, "*")));
        System.out.println(result.toString());
    }
}