package domain;

public class Checker {

    static boolean isEmptyString(String naam) {
        return naam == null || naam.trim().isEmpty();
    }

    public static boolean isNegative(double prijs) {
        return prijs < 0;
    }
}
