package triangles;

public class Validator {

    static boolean checkInput(String input){
        try{
            String[] data = input.split(",");
            if(data.length==2){
               return checkNums(data[1]);
            }else if (data.length==4){
                for (int i =1;i<data.length;i++){
                    checkNums(data[i]);
                }
                return true;
            }else{
                return false;
            }
        }catch(NullPointerException | NumberFormatException | ArrayIndexOutOfBoundsException ex){
            return false;
        }
    }

    static boolean checkNums(String num){
        try{
            double doubleNum = Double.parseDouble(num);
            return doubleNum > 0;
        }catch(NumberFormatException ex){
            return false;
        }
    }



}
