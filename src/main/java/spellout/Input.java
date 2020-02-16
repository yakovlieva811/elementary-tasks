package spellout;

import java.util.Scanner;

public class Input {

    public static String readStr() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.replaceAll(" ","");
    }

    public static boolean doContinue() {
        String answer = readStr();
        return answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes");
    }
}