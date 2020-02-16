package spellout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberReader {

    public StringBuilder getResult() {
        return result;
    }
public int amountOfNamesForSegments(){
        return forms.length;
}
    private List<String> segments;
    private StringBuilder result;
    private String number;

    private String[][] nums1 = {
            {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"}};
    private String[] nums11 = {"", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};
    private String[] nums10 = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private String[] nums100 = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private String[][] forms = {
            {"тысяча", "тысячи", "тысяч"},
            {"миллион", "миллиона", "миллионов"},
            {"миллиард", "миллиарда", "миллиардов"},
            {"триллион", "триллиона", "триллионов"},
            {"квадриллион", "квадриллионa", "квадриллионов"},
            {"квинтиллион", "квинтиллиона", "квинтиллионов"},
            {"секстиллион", "секстиллиона", "секстиллионов"},
            {"септиллион", "септиллиона", "септиллионов"},
            {"октиллион", "октиллиона", "октиллионов"},
            {"нониллион", "нониллиона", "нониллионов"},
            {"дециллион", "дециллиона", "дециллионов"},
            {"ундециллион", "ундециллиона", "ундециллионов"},
            {"дуодециллион", "дуодециллиона", "дуодециллионов"},
            {"тредециллион", "тредециллиона", "тредециллионов"},
            {"кваттуордециллион", "кваттуордециллиона", "кваттуордециллионов"},
            {"квиндециллион", "квиндециллиона", "квиндециллионов"},
            {"сексдециллион", "сексдециллиона", "сексдециллионов"},
            {"септендециллион", "септендециллиона", "септендециллионов"},
            {"октодециллион", "октодециллиона", "октодециллионов"},
            {"новемдециллион", "новемдециллиона", "новемдециллионов"},
            {"вигинтиллион", "вигинтиллиона", "вигинтиллионов"},
            {"унвигинтиллион", "унвигинтиллиона", "унвигинтиллионов"},
            {"дуовигинтиллион", "дуовигинтиллиона", "дуовигинтиллионов"},
            {"тревигинтиллион", "тревигинтиллиона", "тревигинтиллионов"},
            {"кватуорвигинтиллион", "кватуорвигинтиллиона", "кватуорвигинтиллионов"},
            {"квинвигинтиллион", "квинвигинтиллиона", "квинвигинтиллионов"},
            {"сексвигинтиллион", "сексвигинтиллиона", "сексвигинтиллионов"},
            {"септенвигинтиллион", "септенвигинтиллиона", "септенвигинтиллионов"},
            {"октовигинтиллион", "октовигинтиллиона", "октовигинтиллионов"},
            {"новемвигинтиллион", "новемвигинтиллиона", "новемвигинтиллионов"},
            {"тригинтиллион", "тригинтиллиона", "тригинтиллионов"},
            {"унтригинтиллион", "унтригинтиллиона", "унтригинтиллионов"},
            {"дуотригинтиллион", "дуотригинтиллиона", "дуотригинтиллионов"}};


    public void translateNumber(String number) {
        segments = new ArrayList<>();
        result = new StringBuilder(" ");
        this.number = number;
        if ((number.startsWith("-"))) {
            this.number = number.substring(1);
            result.append("минус ");
        }
        if (areAllZeros()) {
            result = new StringBuilder("ноль");
        } else {
            segment();
            Collections.reverse(segments);
            analyzer();
        }

    }

    private boolean areAllZeros() {
        for (int i = number.length(); i >= 1; i--) {
            if (Integer.parseInt(number.substring(i - 1, i)) != 0) {
                return false;
            }
        }
        return true;
    }

    private void segment() {
        int i = number.length();
        while (true) {
            if (i - 3 > 0) {
                segments.add(number.substring(i - 3, i));
                i = i - 3;
            } else {
                segments.add(number.substring(0, i));
                break;
            }
        }
    }

    private void readNumsFromSegment(String segmentString, int currentGender) {
        /* получаем цифры из сегмета*/
        int num1 = Integer.parseInt(segmentString.substring(0, 1));    // первая цифра
        int num2 = Integer.parseInt(segmentString.substring(1, 2));    // вторая цифра
        int num3 = Integer.parseInt(segmentString.substring(2, 3));    // третья цифра
        int num23 = Integer.parseInt(segmentString.substring(1, 3));   // вторая и третья для двузначных

        /* читаем цифры*/
        if (Integer.parseInt(segmentString) > 99) {         // сотни
            result.append(nums100[num1]).append(" ");
        }

        if (num23 > 20) {
            result.append(nums10[num2]).append(" ");    //десятки
            result.append(nums1[currentGender][num3]).append(" ");   //единицы
        } else {
            if (num23 > 9) {   //[10;20]
                result.append(nums11[num23 - 9]).append(" "); //-9 так как nums11.length=12 last nums11[11]
            } else {
                result.append(nums1[currentGender][num3]).append(" ");
            }
        }
    }

    private void analyzer() {
        int amountOfSegments = segments.size();
        for (String segment : segments) {
            int currentGender;
            if (amountOfSegments == 2) {
                currentGender = 0;
            } else {
                currentGender = 1;
            }

            if (Integer.parseInt(segment) == 0 && amountOfSegments > 1) {     // 56 000 454 ---> 000 пропускаем
                amountOfSegments--;
                continue;
            }

            /* добавляем нули так как крашилось при получении цифр*/
            if (segment.length() == 1) {
                segment = "00" + segment;
            } else if (segment.length() == 2) {
                segment = "0" + segment;
            }

            readNumsFromSegment(segment, currentGender);

            /*добавляем названия разрядов*/
            if (amountOfSegments > 1) {
                addNames(segment, amountOfSegments);
            }
            amountOfSegments--;
        }
    }

    private void addNames(String segmentString, int amountOfSegments) {
        result.append(endingOfSegmentName(Integer.parseInt(segmentString.substring(1, 3)), forms[amountOfSegments - 2][0], forms[amountOfSegments - 2][1], forms[amountOfSegments - 2][2])).append(" ");
    }

    private String endingOfSegmentName(int currentSegment, String wordFormFor1, String wordFormFor24, String wordFormFor5AndMore) {
        int num = currentSegment % 10;
        if (currentSegment > 10 && currentSegment < 20) {
            return wordFormFor5AndMore;
        } else if (num > 1 && num < 5) {
            return wordFormFor24;
        } else if (num == 1) {
            return wordFormFor1;
        } else {
            return wordFormFor5AndMore;
        }
    }


}





