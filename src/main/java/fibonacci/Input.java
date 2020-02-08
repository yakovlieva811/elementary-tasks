package fibonacci;

public class Input {


    static boolean checkNums(String[] args) {
        try {
            for (String num : args) {
                int begin = Integer.parseInt(num);
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static int[] checkByValue(String[] args) {
        int[] fromTo = new int[2];
        try {
            if (args.length == 2) {
                if (Integer.parseInt(args[0]) > Integer.parseInt(args[1])) {
                    fromTo[0] = Integer.parseInt(args[1]);
                    fromTo[1] = Integer.parseInt(args[0]);
                } else {
                    fromTo[0] = Integer.parseInt(args[0]);
                    fromTo[1] = Integer.parseInt(args[1]);
                }
            } else if (args.length == 1) {
                fromTo[0] = Integer.parseInt(args[0]);
            }
            return fromTo;
        } catch (NumberFormatException ex) {
            return fromTo;
        }
    }


}
