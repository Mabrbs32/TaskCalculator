package TaskCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    public static String romanOperandFirst;
    public static String romanOperandSecond;
    public static char[] chars;
    public static char operator;

    public static void defineOperator() {
        ArrayList<Character> temp = new ArrayList<>();
        for (char ch : chars) {
            if (ch == '/' || ch == '*' || ch == '-' || ch == '+') {
                temp.add(ch);
            }
        }
        if (temp.size() == 1) {
            operator = temp.get(0);
        } else {
            System.out.println("Формат математической операции не удовлетворяет заданию");
            throw new IllegalArgumentException();
        }
    }

    public static void defineSubstrings(String string) {
        int i = string.indexOf(operator);
        romanOperandFirst = string.substring(0, i).trim();
        romanOperandSecond = string.substring(i + 1).trim();
    }

    public static int setArabianOperand(String string) {
        switch (string.toUpperCase()) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                System.out.println("Формат математической операции не удовлетворяет заданию");
                throw new IllegalArgumentException();
        }
    }

    public static int calculate(int a, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a / b;
            case '*':
                return a * b;
            default:
                System.out.println("Формат математической операции не удовлетворяет заданию");
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите арифметическую операцию, используя римские или арабские числа от 1 до 10 включительно,\n" +
                "например: V + III, X - V, 2 * 4, 9 / 2");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        chars = input.toCharArray();
        defineOperator();
        defineSubstrings(input);
        if (Character.isLetter(chars[0]) && Character.isLetter(chars[chars.length - 1])) {

            int result = calculate(setArabianOperand(romanOperandFirst), setArabianOperand(romanOperandSecond));
            if (result > 0) {
                String resultRoman = null;
                String[] strArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                        "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                        "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                        "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII",
                        "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI",
                        "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII",
                        "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                        "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
                for (int i = 0; i != result; i++) {
                    resultRoman = strArray[i];
                }
                System.out.println("Результат: " + resultRoman);
            } else {
                System.out.println("Формат математической операции не удовлетворяет заданию");
                throw new IllegalArgumentException();
            }

        } else if (Character.isDigit(chars[0]) && Character.isDigit(chars[chars.length - 1])) {

            if (Integer.parseInt(romanOperandFirst) > 0 && Integer.parseInt(romanOperandFirst) < 11 &&
                    Integer.parseInt(romanOperandSecond) > 0 && Integer.parseInt(romanOperandSecond) < 11) {
                System.out.println("Результат: " + calculate(Integer.parseInt(romanOperandFirst), Integer.parseInt(romanOperandSecond)));
            } else {
                System.out.println("Формат математической операции не удовлетворяет заданию");
                throw new IllegalArgumentException();
            }
        } else {
            System.out.println("Формат математической операции не удовлетворяет заданию");
            throw new IllegalArgumentException();
        }
    }
}













