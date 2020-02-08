package luckuTickets;

public class Controller {
        View view = new View();
        Model model =new Model();

        public void runController(){

        while(true) {
            view.printMenu();
            Integer command = view.readCommand();
            if (command.equals(0)) // exit P S F TODO
            {
                break;
            } else if (command.equals(1)) { // start
                model.checkLuck(model.readNums(view.getNumbers()));
                view.printResult(model.getResult());

            }
        }


    }


    }
