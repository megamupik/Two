package staticInnerClass;

/**
 * В этой программе демонстрируется применение статического класса
 * @version 1.00 2018-09-27
 * @author Nikita Postnikov
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = new ArrayAlg.Pair(10,5);
//        ArrayAlg.Pair p = ArrayAlg.minmax(d); // Не может найти метод minmax
        System.out.println("min = " + p.getFirst());
        System.out.println("min = " + p.getSecond());
    }
}
