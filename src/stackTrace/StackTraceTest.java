package stackTrace;

import java.util.Scanner;

/**
 * В этой программе выводится трассировка стека вызовов рекурсивного метода
 * @version 1.00 2018-09-28
 * @author Nikita Postnikov
 */
public class StackTraceTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = in.nextInt();
        factorial(n);
    }
    /**
     * Вычисляет факториал заданного числа
     * @param n Положительное целове число
     * @return n! = 1 * 2 * ... * n
     */
    public static int factorial (int n) {
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f: frames){
            System.out.println(f);
        }
        int r;
        if (n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;
    }
}
;
