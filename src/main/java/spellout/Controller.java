package spellout;

import java.util.InputMismatchException;

public class Controller {
    public static void init() {
        NumberReader numberReader = new NumberReader();
        boolean done = false;
        while (!done) {
            try {
                numberReader.setNumber(Input.read());
                Output.print(numberReader.getNumberInWords());
                done = true;
            } catch (InputMismatchException ex) {
                Output.printExeption();
            } catch (ArrayIndexOutOfBoundsException ex) {
                Output.printExeption();
            }
        }

    }


}


