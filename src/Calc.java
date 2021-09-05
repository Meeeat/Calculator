
import java.util.TreeMap;

public class Calc {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    String number1;
    String number2;
    String operator;

    boolean isArabic;
    //private Object IOException;

    public Calc(String number1, String operator, String number2, boolean isArabic) {
        this.number1 = number1;
        this.operator = operator;
        this.number2 = number2;
        this.isArabic = isArabic;
    }

    public String getCalculate() {
        int n1 = convertToArabic(number1);
        int n2 = convertToArabic(number2);
        if (operator.equals("+")) {
            return selector(n1 + n2);
        }
        if (operator.equals("-")) {
            return selector(n1 - n2);
        }
        if (operator.equals("*")) {
            return selector(n1 * n2);
        }
        if (operator.equals("/")) {
            return selector(n1 / n2);
        }
        return null;
    }

    private String selector(int input) {
        if (isArabic) {
            return String.valueOf(input);
        }
        return convertToRomanic(input);
    }

    private int convertToArabic(String input) {
        String[] dictionary = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        //int output;
        for (int i = 0; i < 10; i++) {
            if (input.equals(dictionary[i])) {
                //output = i + 1;
                return i + 1;
            }
        }
        //return (int) Integer.parseInt(input);
            if ((int) Integer.parseInt(input) > 10 || (int) Integer.parseInt(input) < 1) {
                throw new ArithmeticException("error");
            }
            return (int) Integer.parseInt(input);
    }

    private String convertToRomanic(int input) {
        int l = map.floorKey(input);
        if (input == l) {
            return map.get(input);
        }
        return map.get(l) + convertToRomanic(input - l);
    }

//    private int add(int num1, int num2) {
//        return num1 + num2;
//    }
//
//    private int sub(int num1, int num2) {
//        return num1 - num2;
//    }
//
//    private int mult(int num1, int num2) {
//        return num1 * num2;
//    }
//
//    private int div(int num1, int num2) {
//        return num1 / num2;
//    }
}


