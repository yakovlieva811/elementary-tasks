package FiguersTask2and3;

import java.util.ArrayList;
import java.util.List;

public class Output { //выводит в консоль значения todo or abstract class ut // or rename console

    public static void printHint(){
        System.out.println(" Введите треугольник:  (пример: имя, 5.6 , 4.3 , 2.1) ");
    }


    public static void printDemand(){
        System.out.println(" Введите треугольник:");
    }


    public static void printExeption(){
        System.out.println("Треугольник не записан, пожалуйста, вводите параметры правильно.");
    }

    public static void toContinue(){
        System.out.println("Записать еще один треуольник?. (y/yes --> продолжить || любая буква --> вывести результат)");
    }

    public static void cannotExist(){
        System.out.println("Треугольник не может существоввать с такими параметрами");
    }
    public static void printResult(  List<Triangle> triangles )
    { // вывод листа
        for (Triangle tr:triangles) {
            System.out.println("[имя: " + tr.name + "] area: " + tr.area());

           //    String dfg = "ff";     dfg.join();
        }
    }


    public static void hasBeenCreated(){
        System.out.println("Треугольник создан");
    }
}

