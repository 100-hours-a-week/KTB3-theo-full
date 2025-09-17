import java.util.Scanner;

public class Cinema_Util {
    protected static Scanner s = new Scanner(System.in);

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

    public static String getUserStringInput() {
        return s.next();
    }
}
