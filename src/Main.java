public class Main {

    public static void main(String[] args) {
        simplifyFraction(0, 3);
        simplifyFraction(1, 3);
        simplifyFraction(37, 24);
        simplifyFraction(356, 568);
        simplifyFraction(173,8);
        simplifyFraction(173,9);
    }

    public static void simplifyFraction(int integerPart, int periodPart) {
        // Проверка на ноль в знаменателе
        if (periodPart == 0) {
            System.out.println("Знаменатель не может быть нулем");
            return;
        }

        // Преобразование периодической дроби в обыкновенную дробь
        int periodLength = String.valueOf(periodPart).length(); // вычисляем длину периода через преобразование в строку
        int numerator = integerPart * (int) Math.pow(10, periodLength) + periodPart - integerPart;
        int denominator = (int) Math.pow(10, periodLength) - 1;

        System.out.println("Исходная дробь: " + numerator + "/" + denominator);
        fractionReduction(numerator, denominator);
    }

    //сокращение дроби
    private static void fractionReduction(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        while (gcd != 1) {
            numerator /= gcd;
            denominator /= gcd;
            System.out.println("Сокращенная дробь: " + numerator + "/" + denominator);
            gcd = gcd(numerator, denominator);
        }
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