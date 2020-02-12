package spellout;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class NumberReader {

    private BigInteger number;
    private StringBuilder numberInWords = new StringBuilder(" ");
    private ArrayList segments = new ArrayList();

    public void setNumber(BigInteger number) {
        this.number = number;
    }

    public StringBuilder getNumberInWords() {
        go();
        return numberInWords;
    }

    private String[][] nums1 = {
            {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"}};
    private String[] nums11 = {"", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};
    private String[] nums10 = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private String[] nums100 = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private String[][] forms = {
            {"тысяча", "тысячи", "тысяч", ""},
            {"миллион", "миллиона", "миллионов", "0"},
            {"миллиард", "миллиарда", "миллиардов", "0"},
            {"триллион", "триллиона", "триллионов", "0"},
            {"квадриллион", "квадриллионa", "квадриллионов", "0"},
            {"квинтиллион", "квинтиллиона", "квинтиллионов", "0"},
            {"секстиллион", "секстиллиона", "секстиллионов", "0"},
            {"септиллион", "септиллиона", "септиллионов", "0"},
            {"октиллион", "октиллиона", "октиллионов", "0"},
            {"нониллион", "нониллиона", "нониллионов", "0"},
            {"дециллион", "дециллиона", "дециллионов", "0"},
            {"ундециллион", "ундециллиона", "ундециллионов", "0"},
            {"дуодециллион", "дуодециллиона", "дуодециллионов", "0"},
            {"тредециллион", "тредециллиона", "тредециллионов", "0"},
            {"кватуордециллион", "кватуордециллиона", "кватуордециллионов", "0"},
            {"квиндециллион", "квиндециллиона", "квиндециллионов", "0"},
            {"сексдециллион", "сексдециллиона", "сексдециллионов", "0"},
            {"септендециллион", "септендециллиона", "септендециллионов", "0"},
            {"октодециллион", "октодециллиона", "октодециллионов", "0"},
            {"новемдециллион", "новемдециллиона", "новемдециллионов", "0"},
            {"вигинтиллион", "вигинтиллиона", "вигинтиллионов", "0"},
            {"унвигинтиллион", "унвигинтиллиона", "унвигинтиллионов", "0"},
            {"дуовигинтиллион", "дуовигинтиллиона", "дуовигинтиллионов", "0"},
            {"тревигинтиллион", "тревигинтиллиона", "тревигинтиллионов", "0"},
            {"кватуорвигинтиллион", "кватуорвигинтиллиона", "кватуорвигинтиллионов", "0"},
            {"квинвигинтиллион", "квинвигинтиллиона", "квинвигинтиллионов", "0"},
            {"сексвигинтиллион", "сексвигинтиллиона", "сексвигинтиллионов", "0"},
            {"септенвигинтиллион", "септенвигинтиллиона", "септенвигинтиллионов", "0"},
            {"октовигинтиллион", "октовигинтиллиона", "октовигинтиллионов", "0"},
            {"новемвигинтиллион", "новемвигинтиллиона", "новемвигинтиллионов", "0"},
            {"тригинтиллион", "тригинтиллиона", "тригинтиллионов", "0"},
            {"унтригинтиллион", "унтригинтиллиона", "унтригинтиллионов", "0"},
            {"дуотригинтиллион", "дуотригинтиллиона", "дуотригинтиллионов", "0"},
    };

    private StringBuilder go() {
        if (number.compareTo(BigInteger.valueOf(0)) == 0) {
            numberInWords.append("ноль");
        } else if ((number.compareTo(BigInteger.valueOf(0))) == -1) {
            setNumber(number.abs());
            segments();
            numberInWords.append("минус ");
            analyzer();
        } else {
            segments();
            analyzer();
        }
        return numberInWords;
    }


    private void segments() {

        while ((number.compareTo(BigInteger.valueOf(999))) == 1) {      // если наше число больше 999
            BigInteger seg = number.divide(BigInteger.valueOf(1000));      //разбиваем: 56 111 222 / 1000 = 56 111
            segments.add(number.subtract(seg.multiply(BigInteger.valueOf(1000))));     //56 111 222 - (56 111 000) = 222
            number = seg; // уменьшили на число на один сегмент
        }

        segments.add(number);   // записали последний сегмент
        Collections.reverse(segments);
    }


    private void analyzer() {

        int amountOfSegments = segments.size();
        for (int i = 0; i < segments.size(); i++) {                 // todo попробывать изменить луп
            int currentGender = Integer.parseInt(forms[amountOfSegments][3]);
            int currentSegment = Integer.parseInt(segments.get(i).toString());
            if (currentSegment == 0 && amountOfSegments > 1) {     // 56 000 454 ---> 000 пропускаем
                amountOfSegments--;
                continue;
            }

            String segmentString = String.valueOf(currentSegment);
            /* добавляем нули так как крашилось при получении цифр*/
            if (segmentString.length() == 1) {
                segmentString = "00" + segmentString;
            } else if (segmentString.length() == 2) {
                segmentString = "0" + segmentString;
            }

            /* получаем цифры из сегмета*/
            int num1 = Integer.parseInt(segmentString.substring(0, 1));    // первая цифра
            int num2 = Integer.parseInt(segmentString.substring(1, 2));    // вторая цифра
            int num3 = Integer.parseInt(segmentString.substring(2, 3));    // третья цифра
            int num23 = Integer.parseInt(segmentString.substring(1, 3));   // вторая и третья для двузначных

            System.out.println("1) num23 = " + num23);
            /* читаем цифры*/
            if (currentSegment > 99) {         // сотни
                numberInWords.append(nums100[num1]).append(" ");
            }
            if (num23 > 20) {
                numberInWords.append(nums10[num2]).append(" ");    //десятки
                numberInWords.append(nums1[currentGender][num3]).append(" ");   //единицы
            } else if (num23 > 9) {   //[10;20]
                numberInWords.append(nums11[num23 - 9]).append(" "); //-9 так как nums11.length=12 last nums11[11]
            } else {
                numberInWords.append(nums1[currentGender][num3]).append(" ");
            }

            /*добавляем названия разрядов*/
            if ((amountOfSegments - 2) > -1) {
                numberInWords.append(analyzeWordsForm(num23, forms[amountOfSegments - 2][0], forms[amountOfSegments - 2][1], forms[amountOfSegments - 2][2])).append(" ");
            }
            amountOfSegments--;
        }
    }


    private String analyzeWordsForm(int currentSegment, String wordFormFor1, String wordFormFor24, String wordFormFor5AndMore) {
        System.out.println("currentSegment = " + currentSegment);
        if (currentSegment > 10 && currentSegment < 21) {
            int num = currentSegment;
            System.out.println("num = " + num);

            return wordFormFor5AndMore;
        } else {
            int num = currentSegment % 10;
            System.out.println("num = " + num);
            if (num > 1 && num < 5) {
                return wordFormFor24;
            } else if (num == 1) {
                return wordFormFor1;
            }
            return wordFormFor5AndMore;

        }
    }
}



