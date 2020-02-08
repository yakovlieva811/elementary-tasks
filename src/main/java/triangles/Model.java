package triangles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {

    List<Triangle> triangles =  new ArrayList<>();

    public void run(){
        OutputConsole.printHint();
        String input=Input.readInput();
        creation(input);
        boolean done = false;
        while(!done){
            OutputConsole.toContinue();
            if(Input.readAnswer()){
                OutputConsole.printDemand();
                input=Input.readInput();
                creation(input);
            }else{
                sort();
                OutputConsole.printResult(triangles);
                done=true;
            }
        }
    }


    private void creation(String input){
        if(Validator.checkInput(input)){
            if(newTriangle(input)){
               OutputConsole.hasBeenCreated();
            }else{
                OutputConsole.cannotExist();
            }
        }else{
            OutputConsole.printExeption();
        }
    }


    private void sort(){
        Collections.sort(triangles);
    }

    private boolean newTriangle(String input){
        String[] data = input.split(",");
        if(data.length==2){
            Triangle triangle = new Triangle(data[0],Double.parseDouble(data[1]));
            return addTR(triangle);
        }else{
            Triangle triangle = new Triangle(data[0],Double.parseDouble(data[1]),Double.parseDouble(data[2]),Double.parseDouble(data[3]));
            return addTR(triangle);
        }
    }


    private boolean addTR(Triangle tr){
        if(tr.canBeExist()){
        triangles.add(tr);
        return true;
        }else{
            return false;
        }
    }






}
