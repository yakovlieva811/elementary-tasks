package fibonacci;

import envelope.Output;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumFounder<df> {

    private List<Integer> row = new ArrayList<>();


    public List<Integer> getNums() {
        return row;
    }


    public boolean checkInput(String[] args) {
        try {
            for (String a : args) {
                Integer.parseInt(a);
                if (Integer.parseInt(a) < 0) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean find(String[] args) {
        if (checkInput(args)) {
            if (args.length == 2) {
                calculateFromTo(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                if (row.isEmpty()) {
                    OutputConsole.printToConsole(" В данном диапазоне не найденны числа Фибаначчи.");
                    return false;
                }
                return true;
            } else if (args.length == 1) {
                if (Integer.parseInt(args[0]) > 20) {
                    Output.print("Слишком большое количество цифр");
                    return false;
                }
                calculateByAmountOfNums(Integer.parseInt(args[0]));
                return true;
            }
        } else {
            OutputConsole.printToConsole(" Параметры введены не правильно.");
            return false;
        }
        return false;
    }


    private boolean calculateFromTo(int from, int to) {
        row.clear();
        int prev = 1;
        int next = 1;
        int number;
        for (int i = 3; i <= to; i++) {
            number = prev + next;
            if (number > from && number < to) {
                row.add(number);
            }
            prev = next;
            next = number;
        }
        return true;
    }

    private boolean calculateByAmountOfNums(int amount) {
        row.clear();
        int number;
        int next = 1;
        int prev = 1;
        for (int i = 3; ; i++) {
            number = prev + next;
            if (((int) Math.log10(number) + 1) == amount) {
                row.add(number);
            } else if (((int) Math.log10(number) + 1) > amount) {
                break;
            }
            prev = next;
            next = number;
        }
        return true;
    }

}
