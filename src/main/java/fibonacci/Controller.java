package fibonacci;

public class Controller {

    public void init(String[] args) {
        FibonacciNumFounder numFounder = new FibonacciNumFounder();
        if (numFounder.find(args)) {
            OutputConsole.printList(numFounder.getNums());
        }

    }
}
