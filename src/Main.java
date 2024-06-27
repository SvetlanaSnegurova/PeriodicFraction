public class Main {

    public static void main(String[] args) {
        simplifyFraction(1, 3);
        simplifyFraction(0, 3);
        simplifyFraction(37, 24);
    }

    public static void simplifyFraction(int integerPart, int period) {
        // Проверка на ноль в знаменателе
        if (period == 0) {
            System.out.println("Знаменатель не может быть нулем");
            return;
        }

        int numerator = integerPart * period + 1;
        int denominator = period;

        // Упрощение дроби
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        System.out.println("Упрощенная дробь: " + numerator + " и " + denominator);
    }

    // Нахождения наибольшего общего делителя
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}