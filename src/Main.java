import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            processor(input);
        }
    }

    public static void processor(String input) {
        String regex = "^(\\S+)([+*/\\-])(\\S+)";
        String regexGroup1 = input.replaceAll(regex, "$1").trim();
        String regexGroup2 = input.replaceAll(regex, "$2").trim();
        String regexGroup3 = input.replaceAll(regex, "$3").trim();
        Calc calc = new Calc(regexGroup1, regexGroup2, regexGroup3, isArabic(regexGroup1, regexGroup3));
        System.out.println(calc.getCalculate());
    }

    public static boolean isArabic(String input1, String input2) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher(input1);
        Matcher m2 = pattern.matcher(input2);
        return (m.find() && m2.find());
    }
}