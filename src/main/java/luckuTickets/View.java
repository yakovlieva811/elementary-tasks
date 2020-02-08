package luckuTickets;

import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);
    public Integer readCommand(){
        return sc.nextInt();
    }

    public static String getNumbers(){
        System.out.println(" Input tickets numbers (in example: 121212 565656)");
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        return numbers ;
    }

    public void printMenu(){
        System.out.println("0 - Exit \n1 - Start");
    }

    public void printResult(String res){
        System.out.println(res);
    }
}
