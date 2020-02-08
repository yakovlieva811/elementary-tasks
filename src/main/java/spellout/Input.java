package spellout;

import java.math.BigInteger;
import java.util.Scanner;

public class Input {

    public static BigInteger read() {
        System.out.println(" Введите число: [максимум 99 нулей] ");
        Scanner scanner = new Scanner(System.in);
        BigInteger input = scanner.nextBigInteger();
        return input;
    }

    private boolean checking() {
        return false;
    }
}