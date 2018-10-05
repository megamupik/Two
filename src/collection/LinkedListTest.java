package collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> staff = new LinkedList<>();
        // Обьект типа LinkedList реализующий связанный список
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        Iterator iter = staff.iterator();
        String first = (String) iter.next(); // Обратиться к первому элементу
        Object second = iter.next(); // Обратиться ко второму элементу
//        String three = String.valueOf(iter.next()); // Обратиться к третьему элементу
        iter.remove();
        String three = String.valueOf(iter.next()); // Обратиться к третьему элементу
        System.out.println(first);
        System.out.println(second);
        System.out.println(three);
    }
}
