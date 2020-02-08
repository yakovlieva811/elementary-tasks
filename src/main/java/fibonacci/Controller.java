package fibonacci;

import FiguersTask2and3.Output;

public class Controller {     //отвечает за связь между классом, где выполняется расчет, отправляет на печать, принимает input

    public  void init(String[] args){
        Calculator calculator =new Calculator();
        if(Input.checkByValue(args).length==0){
            OutputConsole.printEx();
        }else if(calculator.go(Input.checkByValue(args))){
            OutputConsole.printList(calculator.getNums());
        }else{
            OutputConsole.printNotFound();
        }


    }
}
