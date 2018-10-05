package pair2;

import java.time.LocalDate;

/**
 * @version 1.00 2018-09-30
 * @author Nikita Postnikov
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] borthdays = {
                LocalDate.of(1906, 12, 9), // G. Hopper
                LocalDate.of(1815, 12, 10), // A. Lovelace
                LocalDate.of(1903, 12, 3), // J. vin Neumann
                LocalDate.of(1910, 6, 22), // K. Zuse
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(borthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
