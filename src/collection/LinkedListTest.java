package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> staff = new LinkedList<>();
        // Обьект типа LinkedList реализующий связанный список
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        ListIterator<String> iter = staff.listIterator();
        iter.next(); // Пройти первый элемент списка
        iter.add("Juliet");

        String first = (String) iter.next(); // Обратиться к первому элементу
//        Object second = iter.next(); // Обратиться ко второму элементу
        String second = String.valueOf(iter.next()); // Обратиться к третьему элементу
//        iter.remove();
//        String three = String.valueOf(iter.next()); // Обратиться к третьему элементу
        System.out.println(first);
        System.out.println(second);
//        System.out.println(three);
    }
}
