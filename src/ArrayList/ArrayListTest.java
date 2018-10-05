package ArrayList;

import java.util.ArrayList;
//import org.omg.CORBA;

/**
 * Проверяем работу ArrayList
 * @version 1.00
 * @author Nikita Postnikov
 */

public class ArrayListTest {
    public static void main(String[] args) {
        // заполнить списочный массив staff тремя обьектами типа Employee
//        ArrayList<ArrayListTest> arrayList = new ArrayList<ArrayListTest> (3);
////        arrayList.add(new ArrayListTest("Carl Cracker", 75000, 1987, 12, 15));
////
////        for (ArrayListTest a, arrayList) {
////            System.out.println(a);
////        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(new Integer(3));
        int a = list.get(1);
        System.out.println(a);
        int b = list.get(1).intValue();
        System.out.println(b);
        Integer n = 3;
        n++;
        System.out.println(n);
        Integer a1 = 1000;
        Integer a2 = 1000;
        if (a1 == a2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        int b1 = 1000;
        int b2 = 1000;
        if (b1 == b2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

//        NullPointerException:
//        Integer n = 1;
//        Double x = 2.0;
//        System.out.println(true ? n : x); // выводится значение 1.0

//        public static void triple (int x) // не сработает
//        {
//            x++;
//        }
//
//        public static void triple (Integer x) // не сработает
//        {
//            x++;
//        }

//        public static void triple (IntHolder x) // должно сработает
//        {
//            x.value++;
//        }

        System.out.printf("%d", n);
        System.out.println("");
        System.out.printf("%d %s", n, "widgest");

//        public static double max (double... values)
//        {
//            double largest = Double.MAX_VALUE;
//            for (double d : values) {
//                if (v > largest) {
//                    largest = v;
//                }
//                return largest;
//            }
//        }
//
//        double m = max {3.1, 40.4, -5};
//        System.out.println(m);


    }
}
