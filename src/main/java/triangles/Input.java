package triangles;

import java.util.Scanner;

public class Input {

    static Scanner scanner = new Scanner(System.in);

    static String readInput(){
        return  scanner.nextLine();
    }
    
    static boolean readAnswer(){
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"); //?
    }



}
