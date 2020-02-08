package fibonacci;

import java.util.ArrayList;

public class Calculator {
   private  ArrayList<Integer> nums = new ArrayList<Integer>();

    public boolean go(int [] input){
       try{
           calculateFromTo(input[0],input[1]);
           return true;
       }catch (ArrayIndexOutOfBoundsException ex){
           return false;
       }
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }


    private boolean calculateFromTo(int from, int to){
        int n0 = 1;
        int n1 = 1;
        int n2;
        for(int i = 3; i <=to; i++){
            n2=n0+n1;
            if(n2>from&&n2<to){
                nums.add(n2);
            }
            n0=n1;
            n1=n2;
        }
        return true;
    }






}
