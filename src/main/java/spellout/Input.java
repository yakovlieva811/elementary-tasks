package spellout;

import java.math.BigInteger;
import java.util.Scanner;

public class Input {

    public static BigInteger readNum() {
        System.out.println(" Введите число: [максимум 99 нулей] "); //todo чё оно nn делает ?
        Scanner scanner = new Scanner(System.in);
        BigInteger input = scanner.nextBigInteger();
        return input;
    }

    public static String readStr() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private boolean checking() {
        return false;
    }
}