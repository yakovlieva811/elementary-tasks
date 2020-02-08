package fibonacci;

import java.util.ArrayList;

public class OutputConsole {    // отвечает за вывод данных в консоль


    static void printNotFound(){
        System.out.println(" В данном диапазоне не найденный числа");
    }

    static void printEx(){
        System.out.println(" Параметры введены некорректно");
    }

    static void printList(ArrayList<Integer> nums){
        for (Integer num: nums) {
            System.out.println(num + ", ");
        }
        System.out.println(" Параметры введены некорректно");
    }

}
