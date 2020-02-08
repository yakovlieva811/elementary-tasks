package FiguersTask2and3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Model {

    List<Triangle> triangles =  new ArrayList<>();

    public void run(){
        Output.printHint();
        String input=Input.readInput();
        creation(input);
        boolean done = false;
        while(!done){
            Output.toContinue();
            boolean answer =Input.readAnswer();
            if(answer){
                Output.printDemand();
                input=Input.readInput();
                creation(input);
            }else{
                sort();
                Output.printResult(triangles);
                done=true;
            }
        }
    }


    private void creation(String input){
        if(Validator.checkInput(input)){
            if(newTriangle(input)){
               Output.hasBeenCreated();
            }else{
                Output.cannotExist();
            }
        }else{
            Output.printExeption();
        }
    }


    private void sort(){
        Collections.sort(triangles);
    }

    private boolean newTriangle(String input){ // проверяет может ли существовать треугольник + создает и добавляет
        String[] data = input.split(","); //todo вынести в общий и если валидаор ок то вынести
        if(data.length==2){
            Triangle triangle = new Triangle(data[0],Double.parseDouble(data[1]));
            return addTR(triangle);
        }else{
            Triangle triangle = new Triangle(data[0],Double.parseDouble(data[1]),Double.parseDouble(data[2]),Double.parseDouble(data[3]));
            return addTR(triangle);
        }
    }


    private boolean addTR(Triangle tr){
        if(tr.canBeExcist()){
        triangles.add(tr);
        return true;
        }else{
            return false;
        }
    }






}
