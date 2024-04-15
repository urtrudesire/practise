package Code;

public class ToRoman {
    public static void main(String[] args) {
        ToRoman t = new ToRoman();
        System.out.println(t.intToRoman(400));
    }

    public String intToRoman(int num) {
        if (num == 0){
            return "";
        }
        if(num == 1)
            return "I";
        if(num == 9){
            return "IX";
        }
        if (num == 4){
            return "IV";
        }
       if(num > 999){
           num = num - 1000;
           return "M" + intToRoman(num);
       } else if (num > 899) {
           num = num - 900;
           return "CM" + intToRoman(num);
       } else if (num > 499) {
           num = num - 500;
           return "D" + intToRoman(num);
       } else if (num > 399) {
           num = num - 400;
           return "CD" + intToRoman(num);
       } else if (num > 99) {
           num = num - 100;
           return "C" + intToRoman(num);
       } else if (num > 89) {
           num = num - 90;
           return "XC" + intToRoman(num);
       }else if (num > 49) {
           num = num - 50;
           return "L" + intToRoman(num);
       } else if (num > 39) {
           num = num - 40;
           return "XL" + intToRoman(num);
       } else if (num > 9) {
           num = num - 10;
           return "X" + intToRoman(num);
       } else if (num > 4) {
           num = num - 5;
           return "V" + intToRoman(num);
       } else if (num > 1) {
           num = num - 1;
           return "I" + intToRoman(num);
       }
       return "";
    }
}
