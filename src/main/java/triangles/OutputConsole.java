package triangles;

import java.util.List;

public class OutputConsole {

    public static void printHint() {
        System.out.println(" Введите треугольник:  (пример: имя, 5.6 , 4.3 , 2.1) ");
    }


    public static void printDemand() {
        System.out.println(" Введите треугольник:");
    }


    public static void printExeption() {
        System.out.println("Треугольник не записан, пожалуйста, вводите параметры правильно.");
    }

    public static void toContinue() {
        System.out.println("Записать еще один треуольник?. (y/yes --> продолжить || любая буква --> вывести результат)");
    }

    public static void cannotExist() {
        System.out.println("Треугольник не может существоввать с такими параметрами");
    }

    public static void printResult(List<Triangle> triangles) {
        for (Triangle tr : triangles) {
            System.out.println("[имя: " + tr.name + "] area: " + tr.area());
        }
    }

    public static void hasBeenCreated() {
        System.out.println("Треугольник создан");
    }
}

