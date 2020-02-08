package LuckuTickets;

public class Model {
    int counterMos;
    int counterPiter; // обновление 0 , не void
    int counterThree;

    private void setZero(){
        counterMos=0;
        counterThree=0;
        counterPiter=0;
    }
    public int[] readNums(String input) {

        String[] numsArray = input.trim().split("\\.|,| ");
        int length = numsArray.length;
        int[] ticketsNums=new int[length];                           //несколько билетов
        try{
            if(numsArray.length>1){
                for(int i =0; i<length;i++){
                    ticketsNums[i]=Integer.parseInt(numsArray[i]);  //перевели номера билетов в int
                }
                ticketsNums = sortIncome(ticketsNums);              //убрали лишние билеты (оставили 2: min + max)
            }else if(numsArray.length==1){                          //если ввели один билет проверяем один
                ticketsNums[0] =Integer.parseInt(input);
            }
        }catch(NumberFormatException ex){
          //  System.out.println("Please, input numbers"); //
        }
        return ticketsNums;
    }



    public int[] sortIncome( int[] ticketNum){
        int[] ticketReduced =new int[2];
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < ticketNum.length-1; i++) {
                if(ticketNum[i] > ticketNum[i+1]){
                    isSorted = false;
                    buf = ticketNum[i];
                    ticketNum[i] = ticketNum[i+1];
                    ticketNum[i+1] = buf;
                }
            }
        }
        ticketReduced[0]=ticketNum[0];
        ticketReduced[1]=ticketNum[ticketNum.length-1];
        return ticketReduced;
    }

    public String getResult(){
        return "Amount of lucky tickets is: \n -- By Moskow method: " + counterMos+ "\n -- By Piter method: " + counterPiter +"\n -- By new method: " + counterThree;
    }

    public void checkLuck(int[] ticket){
        if(ticket.length==1){
            char[] isolatedNum = String.valueOf(ticket).toCharArray();
            int[] isolatedNumInt = new int[isolatedNum.length];
            moskowMethod(isolatedNumInt);
            piterMethod(isolatedNumInt);
            thirdMethod(isolatedNumInt);
        } else if(ticket.length>1){
            for (int i = ticket[0]; i <= ticket[1]; i++) {
                //System.out.println(" билет № " +  i );
                char[] isolatedNum = String.valueOf(i).toCharArray();
                int[] isolatedNumInt = new int[isolatedNum.length];
                for (int j = 0; j < isolatedNum.length; j++) {
                    isolatedNumInt[j] = Character.getNumericValue(isolatedNum[j]);
                }
                moskowMethod(isolatedNumInt);
                piterMethod(isolatedNumInt);
                thirdMethod(isolatedNumInt);
            }
        }

    }

    private void thirdMethod(int[] ticket) {
        int sum1 = 0;
        int sum2  = 0;
        for (int i = 0; i < ticket.length; i++) {
            if (ticket[i] % 2 == 0) {
            sum1 = sum1 + ticket[i];
            } else if (ticket[i] % 2 != 0) {
            sum2 = sum2 + ticket[i];
            }
        }
        if (sum1 == sum2) {
        counterThree++;
        }
    }


    private void moskowMethod(int[] ticket) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < ticket.length; i++) {
            if (i <= 2) {
            sum1 = sum1 + ticket[i];
            } else if (i > 2) {
            sum2 = sum2 + ticket[i];
            }
        }
        if (sum1 == sum2) {
        counterMos++;
        }
    }

    public void piterMethod(int[] ticket) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < ticket.length; i++) {
            if (i % 2 == 0) {
            sum1 = sum1 + ticket[i];
            } else if (i % 2 != 0) {
            sum2 = sum2 + ticket[i];
            }
        }
        if (sum1 == sum2) {
            counterPiter++;
        }
    }
}
