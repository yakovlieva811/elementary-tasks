package envelope;

public class Controller {

    public void go() {
        while (true) {
            Output.print("Конверт 1");
            Envelope envelope1 = new Envelope(checkSide(), checkSide());
            Output.print("Конверт 2");
            Envelope envelope2 = new Envelope(checkSide(), checkSide());
            Output.print(Model.getAnswer(envelope1, envelope2));
            if (!doContinue()) {
                break;
            }
        }
    }


    private double checkSide() {
        double side;
        Output.print("Введите сторону:");
        while (true) {
            try {
                side = Double.parseDouble(Input.readInput());
                if (side > 0) {
                    break;
                } else if (side == 0) {
                    Output.print("ОШИБКА: Сторона конверта должна быть больше нуля");
                } else {
                    Output.print("ОШИБКА: Сторона конверта должна быть положительным числом");
                }
            } catch (NumberFormatException ex) {
                Output.print("ОШИБКА: Сторона конверта измеряется только в числах.");
            } catch (NullPointerException ex) {
                Output.print("ОШИБКА: Без стороны конерта, невозможно выполнить расчет.");
            }
        }
        return side;
    }

    private boolean doContinue() {
        Output.print(" Хотите продолжить ? (y,yes / no )");
        String answer = Input.readInput();
        return ( answer.trim().equalsIgnoreCase("y") ||  answer.trim().equalsIgnoreCase("yes"));
    }
}
