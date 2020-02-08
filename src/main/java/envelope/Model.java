package envelope;

public class Model {


    static String getAnswer(Envelope first, Envelope second) {
        if (first.putTo(second)) {
            return "Первый конверт может поместиться во второй";
        } else if (second.putTo(first)) {
            return "Второй конверт может поместиться в первый";
        } else if (first.putWithAngleIn(second)) {
            return "Первый конверт может поместиться во второй под углом";
        } else if (second.putWithAngleIn(first)) {
            return "Второй конверт может поместиться в первый под углом";
        } else {
            return "Нельзя вложить один конверт в другой";
        }
    }
}
