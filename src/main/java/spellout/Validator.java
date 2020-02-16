package spellout;

public class Validator {


    public static boolean checkInput(String number) {
        try {
            if ((number.startsWith("-"))) {
                number = number.substring(1);
            }

            for (int i = number.length(); i >= 1; i--) {
                Integer.parseInt(number.substring(i - 1, i));
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }

    }

    public static boolean checkLength(String number, int amountOfNamesForSegments) {
        return number.length() <=amountOfNamesForSegments*3+3;
    }

}
