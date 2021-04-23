import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Palindrome {
    private static long number;

    public static void setNumber() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                System.out.printf("\nВведите число (%d...%d): ", 0, Long.MAX_VALUE);
                number = in.nextLong();

                if (number >= 0)
                {
                    break;
                } else
                {
                    ColorPrint.red("Неверный формат числа.");
                }
            } catch (InputMismatchException e) {
                ColorPrint.red("Неверный формат числа.");
                in.next();
            }
        }
    }

    private static char[] longToChar(long l, int numberOfDigits) {
        char[] arr = new char[numberOfDigits];

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = (char) ('0' + (l % 10));
            l /= 10;
        }

        return arr;
    }

    private static long charToLong(char[] arr) {
        long l = 0;

        for (int i = 0; i < arr.length; i++) {
            l += Character.digit(arr[arr.length - i - 1], 10) * Math.round(Math.pow(10, i));
        }

        return l;
    }

    private static void flipCenter(char[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            arr[arr.length - i - 1] = arr[i];
        }
    }

    private static char[] addToCenterDigits(char[] arr, int add) {
        char[] newArr = arr.clone();

        newArr[newArr.length / 2] = (char) ('0' + Character.digit(newArr[newArr.length / 2], 10) + add);

        if (newArr.length / 2 == 0) {
            newArr[newArr.length / 2 - 1] = (char) ('0' + Character.digit(newArr[newArr.length / 2 - 1], 10) + add);
        }

        return newArr;
    }

    public static long findPalindrome() {
        int numberOfDigits = (int) (Math.log10(number) + 1);;
        char [] cNumber1 = longToChar(number, numberOfDigits);

        flipCenter(cNumber1);

        if (charToLong(cNumber1) == number) return number;

        char [] cNumber2 = charToLong(cNumber1) > number ?
                addToCenterDigits(cNumber1, -1) : addToCenterDigits(cNumber1, 1);

        if (Math.abs(number - charToLong(cNumber1)) < Math.abs(number - charToLong(cNumber2))) {
            return charToLong(cNumber1);
        } else {
            return charToLong(cNumber2);
        }
    }

    public static void main(String[] args) {
        while (true) {
            setNumber();
            System.out.println("Ближайший палиндром: " +
                    (Math.abs(number) < 10 ? number : findPalindrome()));
        }
    }
}
