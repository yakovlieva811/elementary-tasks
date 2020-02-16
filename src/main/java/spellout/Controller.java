package spellout;

public class Controller {
    public static void init() {
        NumberReader numberReader = new NumberReader();
        while (true) {
            Output.printString("Введите число: [максимум 102 символа]");
            String input = Input.readStr();
            if (Validator.checkInput(input)) {
                if (Validator.checkLength(input, numberReader.amountOfNamesForSegments())) {
                    numberReader.translateNumber(input);
                    Output.printStrBuilder(numberReader.getResult());
                    Output.printString(" Продолжить?");
                    if (!Input.doContinue()) {
                        break;
                    }
                } else {
                    Output.printString("Введите число поменьше.");
                }
            } else {
                Output.printString("Пожалуйста, введите число.");
            }
        }
    }
}


