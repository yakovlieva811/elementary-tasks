package fibonacci;

import java.util.List;

public class OutputConsole {


    static void printToConsole(String output){
        System.out.println(output);
    }
    static void printList(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + "  ");

        }
    }

}
