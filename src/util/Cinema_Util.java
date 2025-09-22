package util;

import java.util.Scanner;

public class Cinema_Util {
    private static Scanner s = new Scanner(System.in);

    public static int getUserIntegerInput() {
        int input = 0;
        boolean isInteger = false;
        while (!isInteger) {
            if (s.hasNextInt()) {
                return s.nextInt();
            } else {
                UI.REQUIRE_INTEGER_INPUT.linePrint();
                s.next();
            }
        }
        return input;
    }

    public static String getUserSeatInput() {
        String input = "";
        boolean isString = false;
        while (!isString) {
            input = s.next();

            if (input.matches("^[A-Z][1-9]$")) {
                return input;
            } else {
                UI.REQUIRE_SEAT_INPUT.print();
            }
        }
        return input;
    }

    public void closeScanner() {
        s.close();
    }
    public static boolean isNull(Object t) {
        return t == null;
    }
}
