package spellout;

import java.util.InputMismatchException;

public class Controller {
    public static void init() {


        while (true) {
            try {
                NumberReader numberReader = new NumberReader();
                numberReader.setNumber(Input.readNum());
                Output.printStrBuilder(numberReader.getNumberInWords());
                Output.printString(" Продолжить?");
                if (Input.readStr().equalsIgnoreCase("out") ) { //|| !Input.readStr().equalsIgnoreCase("yes")
                    System.out.println("не продолжю ");
                    break;

                }
                System.out.println(" продолжю ");
                continue;

            } catch (InputMismatchException | ArrayIndexOutOfBoundsException ex) {
                Output.printExeption();
            }
        }

    }


}


