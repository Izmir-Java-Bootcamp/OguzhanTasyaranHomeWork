package Week1HomeWork2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();
        while (true) {
            System.out.print("Enter the word you'd like to test: ");
            String inputString = scanner.nextLine();
            if (inputString.equals("exit")) {
                return;
            } else {
                if (doesPatternMatch(pattern, inputString)) {
                    System.out.println(pattern + " occurs in " + inputString);
                } else {
                    System.out.println(pattern + " does NOT occur in " + inputString);
                }
            }
        }
    }

    public static boolean doesPatternMatch(String pattern, String input) {
        char[] modifiedInput = pattern.replace("*", "").toCharArray();
        ArrayList<Integer> occurenceList = new ArrayList<>();
        for (int i = 0; i < modifiedInput.length; i++) {
            int index = input.indexOf(modifiedInput[i]);
            if (index == -1) {
                return false;
            } else {
                occurenceList.add(pattern.indexOf(modifiedInput[i]));
            }
        }
        return occurenceList.stream().sorted().collect(Collectors.toList()).equals(occurenceList);
    }
}