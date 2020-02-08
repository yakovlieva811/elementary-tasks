package FiguersTask2and3;

public class Figure {
    double width;
    double height;
    double thirdSide;

    public static void main (String[]args){
        double width =5;
        double height  = 6;
        double thirdSide=7;

        double p = (width+height+thirdSide)/2;

        System.out.println(  ( Math.sqrt(p*(p-width)*(p-height))));
    }



}
