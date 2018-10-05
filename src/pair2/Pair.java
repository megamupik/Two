package pair2;

/**
 * @version 1.00 2018-09-30
 * @author Nikita Postnikov
 */

public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
