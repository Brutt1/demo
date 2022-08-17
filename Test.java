import java.util.InputMismatchException;

public class Test {
    public static String calc(String input)  {
        System.out.println("Input:");
        System.out.println(input);

        String[] str = input.split(" ");
        if (str.length > 3) {
            throw new ArrayIndexOutOfBoundsException(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        String symbol1 = str[0];
        String symbol2 = str[2];
        String operation = str[1];

        int numb1;
        int numb2;
        boolean numIsRim;

        System.out.println("Output");

        try {
            numb1 = rimNumb(symbol1);
            numb2 = rimNumb(symbol2);
            numIsRim = true;
        } catch (Exception e) {
            numb1 = Integer.parseInt(str[0]);
            numb2 = Integer.parseInt(str[2]);
            numIsRim = false;
        }

        int result = getResult(operation, numb1, numb2);

        if (numIsRim) {
            return resultRim(result);
        } else {
            return String.valueOf(result);
        }

    }


    private static int getResult(String operation, int first, int secondRim) {
        String a = "+";
        String b = "-";
        String c = "*";
        String d = "/";
        int result;

        if (operation.equals(a)) {
            result = addition(first, secondRim);
        } else if (operation.equals(b)) {
            result = subtraction(first, secondRim);
        } else if (operation.equals(c)) {
            result = multiplication(first, secondRim);
        } else if (operation.equals(d)) {
            result = division(first, secondRim);
        } else {
            throw new InputMismatchException("операция может быть только +,-,*,/");
        }
        return result;
    }

    private static int addition(int a, int b) {
        return a + b;
    }

    private static int subtraction(int a, int b) {
        return a - b;
    }

    private static int multiplication(int a, int b) {
        return a * b;
    }

    private static int division(int a, int b) {
        return a / b;
    }

    private static int rimNumb(String rom) {
        if (rom.equals("I")) {
            return 1;
        } else if (rom.equals("II")) {
            return 2;
        } else if (rom.equals("III")) {
            return 3;
        } else if (rom.equals("IV")) {
            return 4;
        } else if (rom.equals("V")) {
            return 5;
        } else if (rom.equals("VI")) {
            return 6;
        } else if (rom.equals("VII")) {
            return 7;
        } else if (rom.equals("VIII")) {
            return 8;
        } else if (rom.equals("IX")) {
            return 9;
        } else if (rom.equals("X")) {
            return 10;
        } else {
            throw new InputMismatchException("Калькулятор должен принимать на вход числа от 1 до 10");
        }
    }

    private static String resultRim(int resultRim)  {
        if (resultRim > 0) {
            String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

            return rim[resultRim - 1];
        } else {
            throw new ArrayIndexOutOfBoundsException("римские числа не могут быть отрицательными");
        }
    }
}
