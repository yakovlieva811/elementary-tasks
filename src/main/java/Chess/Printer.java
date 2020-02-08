package Chess;

public class Printer {
    static void printDesk(int length, int height){
        StringBuilder line = new StringBuilder();
        for(int i=0;i<length;i++){
            if(i%2==0){
                line.insert(i," ");
            }else{
                line.insert(i,"*");
            }
        }
        for (int j=0; j<height;j++){
            if (j%2==0){
                System.out.println(line);
            }else{
                System.out.println(" "+line);
            }

        }

    }
}
